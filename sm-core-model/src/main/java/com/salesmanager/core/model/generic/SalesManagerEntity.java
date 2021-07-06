package com.salesmanager.core.model.generic;

import java.io.Serializable;

public abstract class SalesManagerEntity<K extends Serializable & Comparable<K>, E extends SalesManagerEntity<K, ?>>
        implements Serializable, Comparable<E> {

    private static final long serialVersionUID = 1L;

}
