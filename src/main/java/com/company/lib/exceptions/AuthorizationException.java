package com.company.lib.exceptions;

import javax.servlet.ServletException;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 03:43 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
public class AuthorizationException extends ServletException {

    public AuthorizationException(String message) {
        super(message);
    }
}
