package com.salesmanager.core.business.modules.cms.product;

import com.salesmanager.core.business.modules.cms.common.AssetsManager;

import java.io.Serializable;

public interface ProductAssetsManager
    extends AssetsManager, ProductImageGet, ProductImagePut, ProductImageRemove, Serializable {

}
