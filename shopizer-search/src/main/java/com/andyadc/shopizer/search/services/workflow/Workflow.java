package com.andyadc.shopizer.search.services.workflow;

import com.andyadc.shopizer.search.utils.SearchClient;

public class Workflow {

  private SearchClient searchClient;

  public Workflow() {
    super();
  }

  public SearchClient getSearchClient() {
    return searchClient;
  }

  public void setSearchClient(SearchClient searchClient) {
    this.searchClient = searchClient;
  }

}
