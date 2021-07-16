package com.andyadc.shopizer.search.services.field;

public abstract class Field {


  private String name;
  private Object object;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  protected Object getValue() {
    return object;
  }

  public void setValue(Object o) {
    this.object = o;
  }


}
