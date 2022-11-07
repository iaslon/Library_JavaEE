package com.company.lib.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/08/2022 01:20 (Tuesday)
 * Library_JavaEE/IntelliJ IDEA
 */

@AllArgsConstructor
@Getter
@Setter
public class UserUpdateDTO {

    private Long id;
    private String name;
    private String surname;
    private String email;

}
