package com.company.lib.exceptions;

import javax.servlet.ServletException;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 03:42 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
public class AuthenticationException extends ServletException {

    public AuthenticationException(String message){
        super(message);
    }
}
