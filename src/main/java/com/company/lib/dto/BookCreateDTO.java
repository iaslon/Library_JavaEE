package com.company.lib.dto;

import com.company.lib.domains.Book;
import com.company.lib.enums.Genre;
import com.company.lib.enums.Language;
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
public class BookCreateDTO {

    private String name;
    private String description;
    private String author;
    private Genre genre;
    private Language language;
    private int pageCount;

}
