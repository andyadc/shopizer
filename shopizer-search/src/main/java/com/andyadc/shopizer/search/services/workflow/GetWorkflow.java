package com.andyadc.shopizer.search.services.workflow;

import com.andyadc.shopizer.search.services.impl.SearchDelegate;
import org.springframework.stereotype.Component;

import javax.inject.Inject;


@Component
public class GetWorkflow extends Workflow {

  @Inject
  private SearchDelegate searchDelegate;

  public com.andyadc.shopizer.search.services.GetResponse getObject(String collection,
      String id) throws Exception {
    return searchDelegate.getObject(collection, id);
  }

}
