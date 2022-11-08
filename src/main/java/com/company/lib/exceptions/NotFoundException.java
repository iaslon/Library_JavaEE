package com.company.lib.exceptions;

import javax.servlet.ServletException;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 03:45 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
public class NotFoundException extends ServletException {

    public NotFoundException(String message) {
        super(message);
    }
}
