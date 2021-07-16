package com.andyadc.shopizer.search.services.worker;

import com.andyadc.shopizer.search.services.SearchResponse;
import com.andyadc.shopizer.search.services.impl.SearchDelegate;
import com.andyadc.shopizer.search.utils.SearchClient;

import javax.inject.Inject;
import java.util.Collection;

public class KeywordSearchWorkerImpl implements KeywordSearchWorker {

  @Inject
  private SearchDelegate searchDelegate;

  public SearchResponse execute(SearchClient client, String collection, String json, int size,
                                ExecutionContext context) throws Exception {

    Collection<String> hits = searchDelegate.searchAutocomplete(collection, json, size);
    SearchResponse resp = new SearchResponse();

    if (hits != null) {

      String[] array = hits.toArray(new String[hits.size()]);

      resp.setInlineSearchList(array);
      if (array.length > 0) {
        resp.setCount(array.length);
      }
    }
    return resp;
  }
}
