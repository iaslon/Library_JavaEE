package com.company.lib.utils;

import com.company.lib.configs.PasswordConfigurer;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 04:18 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
public class BaseUtils {

    private static BaseUtils instance;

    public String encode(String rawPassword) {
        return PasswordConfigurer.encode(rawPassword);
    }

    public boolean matchPassword(String rawPassword, String encodedPassword) {
        return PasswordConfigurer.matchPassword(rawPassword, encodedPassword);

    }

    public static BaseUtils getInstance() {
        if (instance == null) {
            instance = new BaseUtils();
        }
        return instance;
    }

}
