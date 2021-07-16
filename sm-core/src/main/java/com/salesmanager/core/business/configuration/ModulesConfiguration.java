package com.salesmanager.core.business.configuration;

import com.salesmanager.core.modules.integration.shipping.model.ShippingQuoteModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Contains injection of external shopizer starter modules
 * @author carlsamson
 * New Way - out of xml config and using spring boot starters
 *
 */
@Configuration
public class ModulesConfiguration {
	
	
	/**
	 * Goes along with
	 * shipping-canadapost-spring-boot-starter
	 */
    @Autowired
    private ShippingQuoteModule canadapost;


}
