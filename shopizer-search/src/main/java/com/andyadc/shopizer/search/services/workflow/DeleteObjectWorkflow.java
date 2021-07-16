package com.andyadc.shopizer.search.services.workflow;

import com.andyadc.shopizer.search.services.worker.DeleteObjectWorker;
import com.andyadc.shopizer.search.services.worker.ExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteObjectWorkflow extends Workflow {

  private static final Logger log = LoggerFactory.getLogger(DeleteObjectWorkflow.class);

  private List deleteObjectWorkflow;


  public List getDeleteObjectWorkflow() {
    return deleteObjectWorkflow;
  }


  public void setDeleteObjectWorkflow(List deleteObjectWorkflow) {
    this.deleteObjectWorkflow = deleteObjectWorkflow;
  }


  public void deleteObject(String collection, String id) throws Exception {


    if (deleteObjectWorkflow != null) {
      ExecutionContext context = new ExecutionContext();
      for (Object o : deleteObjectWorkflow) {
        DeleteObjectWorker iw = (DeleteObjectWorker) o;
        iw.deleteObject(super.getSearchClient(), collection,  id, context);
      }
    }
  }

}
