package com.andyadc.shopizer.search.services.worker;

import com.andyadc.shopizer.search.services.SearchRequest;
import com.andyadc.shopizer.search.services.SearchResponse;
import com.andyadc.shopizer.search.utils.SearchClient;

public interface SearchWorker {

  SearchResponse execute(SearchClient client, SearchRequest request,
                         ExecutionContext context) throws Exception;

}
