package com.company.lib.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/08/2022 01:24 (Tuesday)
 * Library_JavaEE/IntelliJ IDEA
 */@Data
@Builder
public class UploadsDTO {

    private Long id;
    private String originalName;
    private String generatedName;
    private String contentType;
    private String path;
    private long size;

}
