package com.company.lib.dao;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 00:54 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
public class AbstractDAO <D extends BaseDAO>{

    protected final D dao;

    public AbstractDAO(D dao) {
        this.dao = dao;
    }
}
