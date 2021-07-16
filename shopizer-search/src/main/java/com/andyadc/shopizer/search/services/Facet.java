package com.andyadc.shopizer.search.services;

import java.util.ArrayList;
import java.util.List;

public class Facet {

  private String name;
  private List<Entry> entries = new ArrayList<Entry>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Entry> getEntries() {
    return entries;
  }

  public void setEntries(List<Entry> entries) {
    this.entries = entries;
  }

}
