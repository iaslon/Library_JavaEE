package com.company.lib.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/08/2022 00:39 (Tuesday)
 * Library_JavaEE/IntelliJ IDEA
 */

@AllArgsConstructor
@Getter
public enum Genre {

    CRIME("Crime"),
    HORROR("Horror"),
    CI_FI("Ci-fi"),
    DRAMA("Drama"),
    ROMANCE("Romance"),
    ROMANCE_DRAMA("Romance Drama"),
    TUTORIAL("Tutorial"),
    FANTASY("Fantasy");
    private final String key;

    public String getKey() {
        return key;
    }
}

