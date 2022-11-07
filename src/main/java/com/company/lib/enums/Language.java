package com.company.lib.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/08/2022 00:45 (Tuesday)
 * Library_JavaEE/IntelliJ IDEA
 */

@AllArgsConstructor
@Getter
public enum Language {

    UZ("Uzbek"),
    RU("Russian"),
    EN("English");
    private final String value;

}
