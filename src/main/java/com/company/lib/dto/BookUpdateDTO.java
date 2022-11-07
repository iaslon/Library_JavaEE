package com.company.lib.dto;

import com.company.lib.enums.BookStatus;
import lombok.*;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/08/2022 01:24 (Tuesday)
 * Library_JavaEE/IntelliJ IDEA
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookUpdateDTO {

    private Long id;
    private String name;
    private String description;
    private Integer downloadCount;
    private BookStatus status;

}
