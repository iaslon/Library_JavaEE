package com.company.lib.domains;

import com.company.lib.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/08/2022 00:25 (Tuesday)
 * Library_JavaEE/IntelliJ IDEA
 */


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    private String name;
    private String surname;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.USER;

}
