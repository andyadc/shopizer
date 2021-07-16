package com.andyadc.shopizer.search.services.worker;

import com.andyadc.shopizer.search.services.SearchRequest;
import com.andyadc.shopizer.search.services.SearchResponse;
import com.andyadc.shopizer.search.services.impl.SearchDelegate;
import com.andyadc.shopizer.search.utils.SearchClient;

import javax.inject.Inject;

public class SearchWorkerImpl implements SearchWorker {

  @Inject
  private SearchDelegate searchDelegate;

  public SearchResponse execute(SearchClient client, SearchRequest request,
                                ExecutionContext context) throws Exception {

    SearchResponse response = searchDelegate.search(request);

    response.setInputSearchJson(request.getJson());
    if (context == null) {
      context = new ExecutionContext();
    }
    context.setObject("response", response);
    return response;

  }

}
