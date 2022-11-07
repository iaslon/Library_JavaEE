package com.company.lib.dto.auth;

import com.company.lib.enums.UserStatus;
import lombok.*;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/08/2022 01:20 (Tuesday)
 * Library_JavaEE/IntelliJ IDEA
 */

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String email;
    private String name;
    private String surname;
    private UserStatus status;

}
