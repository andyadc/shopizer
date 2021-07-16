package com.andyadc.shopizer.search.services.worker;

import com.andyadc.shopizer.search.utils.SearchClient;

/**
 * Deletes an object from the index
 * 
 * @author Carl Samson
 *
 */
public interface DeleteObjectWorker {

  void deleteObject(SearchClient client, String collection, String id,
                           ExecutionContext context) throws Exception;

  void deleteObject(SearchClient client, String collection, String id)
      throws Exception;

}
