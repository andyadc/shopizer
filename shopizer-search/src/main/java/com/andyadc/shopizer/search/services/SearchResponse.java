package com.andyadc.shopizer.search.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Object used for autocomplete and regular search
 * 
 * @author Carl Samson
 *
 */
public class SearchResponse {

  @Deprecated
  private String inputSearchJson;
  private Collection<String> ids = new ArrayList<String>();
  private long count;


  private Collection<SearchHit> searchHits = new ArrayList<SearchHit>();
  private Map<String, Facet> facets = new HashMap<String, Facet>();
  @Deprecated
  private String[] inlineSearchList;

  public Map<String, Facet> getFacets() {
    return facets;
  }

  public void setFacets(Map<String, Facet> facets) {
    this.facets = facets;
  }

  public String[] getInlineSearchList() {
    return inlineSearchList;
  }

  public void setInlineSearchList(String[] inlineSearchList) {
    this.inlineSearchList = inlineSearchList;
  }

  public Collection<SearchHit> getSearchHits() {
    return searchHits;
  }

  public void setSearchHits(Collection<SearchHit> searchHits) {
    this.searchHits = searchHits;
  }

  public String getInputSearchJson() {
    return inputSearchJson;
  }

  public void setInputSearchJson(String inputSearchJson) {
    this.inputSearchJson = inputSearchJson;
  }

  public Collection<String> getIds() {
    return ids;
  }

  public void setIds(Collection<String> ids) {
    this.ids = ids;
  }

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }



}
