package com.company.lib.dto.session;

import com.company.lib.dto.auth.UserDTO;
import com.company.lib.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 00:50 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
public class Session {
    public static SessionUser sessionUser;

    public static void setSessionUser(UserDTO user) {
        if (Objects.isNull(user)) {
            sessionUser = null;
        } else
            sessionUser = new SessionUser(user);
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SessionUser {
        private Long id;
        private String email;
        private UserStatus status;

        public SessionUser(UserDTO userDTO) {
            this.id = userDTO.getId();
            this.email = userDTO.getEmail();
            this.status = userDTO.getStatus();
        }
    }
}
