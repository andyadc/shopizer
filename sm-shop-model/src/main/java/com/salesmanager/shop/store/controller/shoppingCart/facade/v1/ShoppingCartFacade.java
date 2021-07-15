package com.salesmanager.shop.store.controller.shoppingCart.facade.v1;

import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.core.model.reference.language.Language;
import com.salesmanager.shop.model.shoppingcart.ReadableShoppingCart;

import java.util.Optional;

public interface ShoppingCartFacade {
	
	ReadableShoppingCart get(Optional<String> cart, Long customerId, MerchantStore store, Language language);

}
