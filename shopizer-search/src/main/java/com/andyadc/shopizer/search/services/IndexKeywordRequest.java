package com.andyadc.shopizer.search.services;

import com.andyadc.shopizer.search.services.field.Field;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class IndexKeywordRequest implements Serializable {

  private static final long serialVersionUID = 1L;
  private String id;
  private String keyword;
  private String original;
  private Collection<Field> filters = new ArrayList<>();

  public Collection<Field> getFilters() {
    return filters;
  }

  public void setFilters(Collection<Field> filters) {
    this.filters = filters;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public String getOriginal() {
    return original;
  }

  public void setOriginal(String original) {
    this.original = original;
  }

}
