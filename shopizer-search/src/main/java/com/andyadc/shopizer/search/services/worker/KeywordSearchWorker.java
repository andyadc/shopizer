package com.andyadc.shopizer.search.services.worker;

import com.andyadc.shopizer.search.services.SearchResponse;
import com.andyadc.shopizer.search.utils.SearchClient;

public interface KeywordSearchWorker {

  SearchResponse execute(SearchClient client, String collection, String json, int size,
                         ExecutionContext context) throws Exception;

}
