package com.salesmanager.core.modules.integration.shipping.model;

import com.salesmanager.core.business.exception.ServiceException;
import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.core.model.shipping.PackageDetails;
import com.salesmanager.core.model.shipping.ShippingProduct;

import java.util.List;

public interface Packaging {

    List<PackageDetails> getBoxPackagesDetails(
            List<ShippingProduct> products, MerchantStore store) throws ServiceException;

    List<PackageDetails> getItemPackagesDetails(
            List<ShippingProduct> products, MerchantStore store) throws ServiceException;

}
