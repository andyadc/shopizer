package com.salesmanager.core.modules;

/**
 * Root interface for all modules
 */
public interface Module {
    String getName();

    void setName(String name);

    String getCode();

    void setCode(String code);
}
