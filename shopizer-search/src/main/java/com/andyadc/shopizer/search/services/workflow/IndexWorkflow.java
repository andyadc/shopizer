package com.andyadc.shopizer.search.services.workflow;

import com.andyadc.shopizer.search.services.worker.ExecutionContext;
import com.andyadc.shopizer.search.services.worker.IndexWorker;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@Component
public class IndexWorkflow extends Workflow {

  private static final Logger log = LoggerFactory.getLogger(IndexWorkflow.class);

  @SuppressWarnings("rawtypes")
  private List indexWorkflow;

  @SuppressWarnings("rawtypes")
  public List getIndexWorkflow() {
    return indexWorkflow;
  }

  public void setIndexWorkflow(@SuppressWarnings("rawtypes") List indexWorkflow) {
    this.indexWorkflow = indexWorkflow;
  }

  @SuppressWarnings("unchecked")
  public void index(String json, String collection) throws Exception {

    ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> indexData = mapper.readValue(json, Map.class);

    // get id
    String _id = (String) indexData.get("id");
    if (StringUtils.isBlank(_id)) {
      log.warn("No id exist for object " + json + " will create a generic one");
      UUID uid = UUID.randomUUID();
      _id = uid.toString();
      indexData.put("id", _id);
      json = mapper.writeValueAsString(indexData);
    }
    ExecutionContext context = new ExecutionContext();
    context.setObject("indexData", indexData);

    if (indexWorkflow != null) {
      for (Object o : indexWorkflow) {
        IndexWorker iw = (IndexWorker) o;
        iw.execute(this.getSearchClient(), json, collection, _id, context);
      }
    }
  }

}
