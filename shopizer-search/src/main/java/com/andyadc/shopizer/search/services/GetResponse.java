package com.andyadc.shopizer.search.services;

import java.util.Map;


public class GetResponse {

  private final Map<String, Object> objectMap;
  private String objectJson;
  public GetResponse(Map<String, Object> source) {
    this.objectMap = source;
  }

  public Map<String, Object> getFieldMap() {
    return objectMap;
  }


  public String getObjectJson() {
    return objectJson;
  }

  public void setObjectJson(String objectJson) {
    this.objectJson = objectJson;
  }

}
