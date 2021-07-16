package com.andyadc.shopizer.search.services.worker;

import com.andyadc.shopizer.search.utils.SearchClient;

public interface IndexWorker {

  void init(SearchClient client);

  void execute(SearchClient client, String json, String collection, String id,
               ExecutionContext context) throws Exception;

}
