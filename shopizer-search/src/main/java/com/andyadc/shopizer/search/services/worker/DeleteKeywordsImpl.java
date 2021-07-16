package com.andyadc.shopizer.search.services.worker;


import com.andyadc.shopizer.search.services.SearchHit;
import com.andyadc.shopizer.search.services.SearchRequest;
import com.andyadc.shopizer.search.services.SearchResponse;
import com.andyadc.shopizer.search.services.impl.SearchDelegate;
import com.andyadc.shopizer.search.utils.CustomIndexConfiguration;
import com.andyadc.shopizer.search.utils.SearchClient;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DeleteKeywordsImpl implements DeleteObjectWorker {

  private static final Logger log = LoggerFactory.getLogger(DeleteKeywordsImpl.class);

  private List<CustomIndexConfiguration> indexConfigurations = null;
  @Inject
  private SearchDelegate searchDelegate;

  public void deleteObject(SearchClient client, String collection, String id,
                           ExecutionContext context) throws Exception {

    @SuppressWarnings("rawtypes")
    Map indexData = (Map) context.getObject("indexData");

    if (indexData != null) {

      if (!CollectionUtils.isEmpty(this.getIndexConfigurations())) {

        for (CustomIndexConfiguration indexConfiguration : this.getIndexConfigurations()) {

          // build a search string for retrieving the internal id of the keyword
          String query = new StringBuilder().append("{\"query\":{\"term\" : {\"_id_\" : \"")
              .append(id).append("\" }}}").toString();
          
          if(StringUtils.isBlank(indexConfiguration.getCollectionName())) {
            return;
          }

          SearchRequest sr = new SearchRequest();
          sr.addCollection(indexConfiguration.getCollectionName());
          sr.setJson(query);

          SearchResponse r = searchDelegate.search(sr);
          if (r != null && !CollectionUtils.isEmpty(r.getIds())) {
            // Collection<String> ids = r.getIds();
            List<String> ids = new ArrayList<String>();
            Collection<SearchHit> hits = r.getSearchHits();
            for (SearchHit hit : hits) {
              ids.add(hit.getInternalId());
            }
            searchDelegate.bulkDeleteIndex(ids, indexConfiguration.getCollectionName());
          }

        }

      }

    }
  }


  public void deleteObject(SearchClient client, String collection, String id)
      throws Exception {

    if (searchDelegate.indexExist(collection)) {

      //String query = new StringBuilder().append("{\"query\":{\"term\" : {\"_id_\" : \"").append(id)
      //    .append("\" }}}").toString();

      //SearchRequest sr = new SearchRequest();
      //sr.addCollection(collection);
      //sr.setJson(query);


      //SearchResponse r = searchDelegate.search(sr);
      //if (r != null) {
      //  Collection<String> ids = r.getIds();

      //  searchDelegate.bulkDeleteIndex(ids, collection);
      //}
      
      ActionListener<BulkByScrollResponse> listener = new ActionListener<BulkByScrollResponse>() {
        @Override
        public void onResponse(BulkByScrollResponse deleteResponse) {}

        @Override
        public void onFailure(Exception e) {
          log.error("An issue occured while deleting document from index " + collection + " " + e.getMessage());
            
        }
      };
      
      
      DeleteByQueryRequest request =
          new DeleteByQueryRequest(collection);
      
      request.setQuery(new TermQueryBuilder("_id_", id)); 
      client.getClient().deleteByQueryAsync(request, RequestOptions.DEFAULT, listener);

    }

  }

  public List<CustomIndexConfiguration> getIndexConfigurations() {
    return indexConfigurations;
  }

  public void setIndexConfigurations(List<CustomIndexConfiguration> indexConfigurations) {
    this.indexConfigurations = indexConfigurations;
  }

}
