package com.andyadc.shopizer.search.services;

import java.util.HashMap;
import java.util.Map;

public class SearchHit {

  private final String id;
  private final String internalId;
  private String index;
  private Map<String, Object> item = new HashMap<String, Object>();


  public SearchHit(Map<String, Object> item, String id, String internalId) {

    this.id = id;
    this.internalId = internalId;
    this.item = item;


  }

  public Map<String, Object> getItem() {
    return item;
  }

  public String getId() {
    return id;
  }

  public String getIndex() {
    return index;
  }

  public String getInternalId() {
    return internalId;
  }



}
