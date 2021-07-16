package com.andyadc.shopizer.search.services.worker;

import com.andyadc.shopizer.search.services.IndexKeywordRequest;
import com.andyadc.shopizer.search.services.field.BooleanField;
import com.andyadc.shopizer.search.services.field.DoubleField;
import com.andyadc.shopizer.search.services.field.Field;
import com.andyadc.shopizer.search.services.field.IntegerField;
import com.andyadc.shopizer.search.services.field.ListField;
import com.andyadc.shopizer.search.services.field.LongField;
import com.andyadc.shopizer.search.services.field.StringField;
import com.andyadc.shopizer.search.services.impl.SearchDelegate;
import com.andyadc.shopizer.search.utils.CustomIndexConfiguration;
import com.andyadc.shopizer.search.utils.CustomIndexFieldConfiguration;
import com.andyadc.shopizer.search.utils.DateUtil;
import com.andyadc.shopizer.search.utils.FileUtil;
import com.andyadc.shopizer.search.utils.SearchClient;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KeywordIndexerImpl implements IndexWorker {

  private static final Logger log = LoggerFactory.getLogger(KeywordIndexerImpl.class);
  private static boolean init = false;
  private static Map<String, CustomIndexConfiguration> indexConfigurationsMap = null;
  @Inject
  DeleteKeywordsImpl deleteKeywordsImpl;
  @Inject
  private SearchDelegate searchDelegate;
  private Map<String, String> mappings = new ConcurrentHashMap<String, String>();
  private Map<String, String> settings = new ConcurrentHashMap<String, String>();
  private List<CustomIndexConfiguration> indexConfigurations = null;

  public List<CustomIndexConfiguration> getIndexConfigurations() {
    return indexConfigurations;
  }

  public void setIndexConfigurations(List<CustomIndexConfiguration> indexConfigurations) {
    this.indexConfigurations = indexConfigurations;
  }
  
  private String validateIndex(String index) throws Exception {
    Validate.notNull(index, "Index name must not be null");
    String keywordIndexPrefix = index.substring(index.indexOf("_"));//en_defau;t
    String indexNameSubstitution = new StringBuilder().append("keyword").append(keywordIndexPrefix).toString();
    String mapKey  = indexNameSubstitution.substring(0,indexNameSubstitution.lastIndexOf("_"));

    //indexname must be transformed product_en_default - >keyword_en_default -> keyword + keywordIndexPrefix

    if(!searchDelegate.indexExist(indexNameSubstitution)) {
      searchDelegate.createIndice(getMappings().get(mapKey), getSettings().get(mapKey), indexNameSubstitution);
    }
    
    return indexNameSubstitution;
  }

  private synchronized void init() {

    if (init) {
      return;
    }

    try {

      if (indexConfigurations != null) {

        for (Object o : indexConfigurations) {

          CustomIndexConfiguration ic = (CustomIndexConfiguration) o;
          String key = ic.getCreateOnIndexName();
          if (indexConfigurationsMap == null) {
            indexConfigurationsMap = new HashMap();
          }
          if (StringUtils.isBlank(key)) {
            log.error("*********************************************");
            log.error("Require property createOnIndexName in keyword indexer");
            log.error("*********************************************");
            continue;
          }
          indexConfigurationsMap.put(key, ic);

          // settings mapping

          String mappingFile = null;
          String settingsFile = null;
          if (!StringUtils.isBlank(ic.getMappingFileName())) {
            mappingFile = ic.getMappingFileName();
          }
          if (!StringUtils.isBlank(ic.getSettingsFileName())) {
            settingsFile = ic.getSettingsFileName();
          }

          if (mappingFile != null || settingsFile != null) {

            String metadata = null;
            String settingsdata = null;
            try {

              /*
               * if (mappingFile != null) { metadata = FileUtil.readFileAsString(mappingFile); }
               * 
               * if (settingsFile != null) { settingsdata = FileUtil.readFileAsString(settingsFile);
               * }
               */

              if (mappingFile != null) {
                metadata = FileUtil.readFileAsString(mappingFile);
                mappings.put(ic.getIndexName(), metadata);
              }

              if (settingsFile != null) {
                settingsdata = FileUtil.readFileAsString(settingsFile);
                settings.put(ic.getIndexName(), settingsdata);
              }

              /*
               * if (!StringUtils.isBlank(ic.getIndexName())) {
               * 
               * if (ic.getCollectionName() != null &&
               * !searchDelegate.indexExist(ic.getCollectionName())) {
               * searchDelegate.createIndice(metadata, settingsdata, ic.getCollectionName()); } }
               */

            } catch (Exception e) {
              log.error("",e);
              log.error("*********************************************");
              init = false;
            }
          }
        }

      }

      init = true;

    } catch (Exception e) {
      log.error("*********************************************");
      log.error("",e);
      log.error("*********************************************");
    }

  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  public void execute(SearchClient client, String json, String collection, String id,
                      ExecutionContext context) throws Exception {

    if (!init) {
      init();
    }

    try {

      // strip last _ of collection
      int indexOf = collection.lastIndexOf("_");
      String indexName = collection.substring(0, indexOf);
      indexName = indexName + "_*";
      
      String index = validateIndex(collection);

      if (indexConfigurationsMap != null && indexConfigurationsMap.containsKey(indexName)) {

        // get json
        Map indexData = (Map) context.getObject("indexData");


        CustomIndexConfiguration conf = indexConfigurationsMap.get(indexName);

        // get fields to index
        List fields = conf.getFields();
        if (fields != null) {

          // list of keyword - original
          List<Keyword> k = new ArrayList<Keyword>();
          for (Object o : fields) {


            CustomIndexFieldConfiguration cifc = (CustomIndexFieldConfiguration) o;

            String fieldName = cifc.getFieldName();

            if (fieldName.trim().equalsIgnoreCase("_id_")) {// we have our own id
              continue;
            }

            String fieldType = cifc.getFieldType();

            if (!StringUtils.isBlank(fieldType)) {
              if (fieldType.equals("List")) {
                try {
                  List<String> keyWords = (List) indexData.get(fieldName);
                  if (keyWords != null) {

                    // k.addAll(keyWords);
                    for (String keyword : keyWords) {
                      Keyword word = new Keyword();
                      word.setKeyword(keyword);
                      word.setOriginal(keyword);
                      k.add(word);
                    }
                  }

                } catch (Exception e) {// might have one instead of a list
                  String keyword = (String) indexData.get(fieldName);

                  if (keyword != null) {
                    Keyword word = new Keyword();
                    word.setKeyword(keyword);
                    word.setOriginal(keyword);
                    k.add(word);

                  }
                }

              } else {// String

                String keyword = (String) indexData.get(fieldName);


                String[] splitted = keyword.split(" ");

                if (keyword != null) {
                  if (k == null) {
                    k = new ArrayList();
                  }
                  for (int i = 0; i < splitted.length; i++) {
                    Keyword word = new Keyword();
                    word.setKeyword(splitted[i]);
                    word.setOriginal(keyword);
                    k.add(word);
                  }
                }
              }
            } // end field type

          } // end for

          if (!CollectionUtils.isEmpty(k)) {

            Collection bulks = new ArrayList();

            for (Keyword o : k) {

              IndexKeywordRequest kr = new IndexKeywordRequest();

              // id is the key trimed in lower case
              String value = o.getKeyword();
              String original = o.getOriginal();

              if (StringUtils.isBlank(value)) {
                continue;
              }

              String _id = (String) indexData.get("id");
              kr.setId(_id);
              kr.setOriginal(original);
              kr.setKeyword(value.toLowerCase().trim());

              // check fields to add

              if (conf.getFilters() != null && conf.getFilters().size() > 0) {

                for (Object oo : conf.getFilters()) {

                  CustomIndexFieldConfiguration filter = (CustomIndexFieldConfiguration) oo;
                  String fieldName = filter.getFieldName();
                  String fieldType = filter.getFieldType();
                  Field f = null;

                  if (fieldType.equals("List")) {
                    List ooo = (List) indexData.get(fieldName);
                    f = new ListField();
                    f.setValue(ooo);
                    f.setName(fieldName);
                    kr.getFilters().add(f);

                  } else if (fieldType.equals("Boolean")) {

                    String s = (String) indexData.get(fieldName);
                    Boolean ooo = new Boolean(s);
                    f = new BooleanField();
                    f.setValue(ooo);
                    f.setName(fieldName);
                    kr.getFilters().add(f);

                  } else if (fieldType.equals("Integer")) {

                    // String s = (String)indexData.get(fieldName);
                    Integer ooo = (Integer) indexData.get(fieldName);
                    f = new IntegerField();
                    f.setValue(ooo);
                    f.setName(fieldName);
                    kr.getFilters().add(f);

                  } else if (fieldType.equals("Long")) {

                    // String s = (String)indexData.get(fieldName);
                    Long ooo = (Long) indexData.get(fieldName);
                    f = new LongField();
                    f.setValue(ooo);
                    f.setName(fieldName);
                    kr.getFilters().add(f);

                  } else if (fieldType.equals("Double")) {

                    // String s = (String)indexData.get(fieldName);
                    Double ooo = (Double) indexData.get(fieldName);
                    f = new DoubleField();
                    f.setValue(ooo);
                    f.setName(fieldName);
                    kr.getFilters().add(f);

                  } else if (fieldType.equals("Date")) {

                    String d = (String) indexData.get(fieldName);
                    // parse date
                    try {
                      Date dt = DateUtil.formatDate(d);
                      f = new DoubleField();
                      f.setValue(dt);
                      f.setName(fieldName);
                      kr.getFilters().add(f);
                    } catch (Exception e) {
                      log.error("Invalid date format " + d);
                    }


                  } else {

                    String ooo = (String) indexData.get(fieldName);
                    f = new StringField();
                    f.setValue(ooo.toLowerCase());
                    f.setName(fieldName);
                    kr.getFilters().add(f);

                  }
                }

              }

              bulks.add(kr);

            }


            // delete previous keywords for the same id
            deleteKeywordsImpl.deleteObject(client, index, id);

            // searchDelegate.bulkIndexKeywords(bulks, collectionName, "keyword");
            searchDelegate.bulkIndexKeywords(bulks, index);

          }

        }

      }

    } catch (Exception e) {
      log.error("Cannot index keywords, maybe a timing ussue for no shards available", e);
    }

  }

  @Override
  public void init(SearchClient client) {
    if (!init) {
      init();
    }

  }

  public Map<String, String> getMappings() {
    return mappings;
  }

  public void setMappings(Map<String, String> mappings) {
    this.mappings = mappings;
  }

  public Map<String, String> getSettings() {
    return settings;
  }

  public void setSettings(Map<String, String> settings) {
    this.settings = settings;
  }



}


class Keyword {
  private String keyword;
  private String original;

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public String getOriginal() {
    return original;
  }

  public void setOriginal(String original) {
    this.original = original;
  }


}
