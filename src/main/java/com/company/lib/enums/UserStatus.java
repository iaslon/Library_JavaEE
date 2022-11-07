package com.company.lib.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/08/2022 00:59 (Tuesday)
 * Library_JavaEE/IntelliJ IDEA
 */

@AllArgsConstructor
@Getter
public enum UserStatus {

    USER(50),
    ADMIN(75),
    SUPER_ADMIN(100);
    private final Integer priority;

}
