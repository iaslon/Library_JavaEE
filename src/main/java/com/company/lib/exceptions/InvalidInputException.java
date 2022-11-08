package com.company.lib.exceptions;

import javax.servlet.ServletException;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 03:39 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
public class InvalidInputException extends ServletException {

   public InvalidInputException(String message){
       super(message);
   }

}
