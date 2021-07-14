package com.salesmanager.core.business.exception;

public class ConversionException extends Exception {
    public ConversionException(final String msg, final Throwable cause) {
        super(msg, cause);
    }

    public ConversionException(final String msg) {
        super(msg);
    }

    public ConversionException(Throwable t) {
        super(t);
    }
}
