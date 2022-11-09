package com.company.lib.configs;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 04:26 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
public class PasswordConfigurer {


    public static String encode(String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt(12));
    }

    public static boolean matchPassword(String rawPassword, String encodedPassword) {
        return BCrypt.checkpw(rawPassword, encodedPassword);
    }


}
