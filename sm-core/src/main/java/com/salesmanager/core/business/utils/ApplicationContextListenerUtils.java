package com.salesmanager.core.business.utils;

import com.andyadc.shopizer.search.services.SearchService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class ApplicationContextListenerUtils implements ApplicationListener<ContextStartedEvent> {

	@Override
	public void onApplicationEvent(ContextStartedEvent event) {
		 ApplicationContext applicationContext = event.getApplicationContext();
		 /** init search service **/
		 SearchService searchService = (SearchService)applicationContext.getBean("productSearchService");
		 searchService.initService();
	}

}
