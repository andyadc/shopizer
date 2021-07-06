package com.salesmanager.core.model.common;

public final class UserContext implements AutoCloseable {

    private static final ThreadLocal<UserContext> instance = new ThreadLocal<>();
    private String ipAddress;

    private UserContext() {
    }

    public static UserContext create() {
        UserContext context = new UserContext();
        instance.set(context);
        return context;
    }

    public static UserContext getCurrentInstance() {
        return instance.get();
    }

    @Override
    public void close() throws Exception {
        instance.remove();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

}
