package com.company.lib.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/08/2022 01:20 (Tuesday)
 * Library_JavaEE/IntelliJ IDEA
 */
@AllArgsConstructor
@Data

public class UserLoginDTO {

    private String email;
    private String password;

}
