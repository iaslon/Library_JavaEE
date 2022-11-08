package com.company.lib.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/08/2022 01:24 (Tuesday)
 * Library_JavaEE/IntelliJ IDEA
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ErrorDTO {
    private String message;

    private String detailedMessage;
    private String path;
    @Builder.Default
    private Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

}
