package com.salesmanager.shop.model.catalog.product.attribute.api;

import com.salesmanager.shop.model.entity.ReadableList;

import java.util.ArrayList;
import java.util.List;

public class ReadableProductOptionValueList extends ReadableList {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  List<ReadableProductOptionValueEntity> optionValues = new ArrayList<ReadableProductOptionValueEntity>();
  public List<ReadableProductOptionValueEntity> getOptionValues() {
    return optionValues;
  }
  public void setOptionValues(List<ReadableProductOptionValueEntity> optionValues) {
    this.optionValues = optionValues;
  }

}
