package com.salesmanager.shop.application.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Properties;

@WebListener
public class ShopServletContextListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(ShopServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("=== context init ===");
        System.getenv().forEach((k, v) -> {
            logger.debug(k + ":" + v);
        });
        Properties properties = System.getProperties();
        properties.forEach((k, v) -> {
            logger.debug(k + ":" + v);
        });
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("=== context destroy ===");

    }
}
