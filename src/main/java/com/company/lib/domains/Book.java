package com.company.lib.domains;

import com.company.lib.enums.BookStatus;
import com.company.lib.enums.Genre;
import com.company.lib.enums.Language;
import jakarta.persistence.*;
import lombok.*;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/08/2022 00:25 (Tuesday)
 * Library_JavaEE/IntelliJ IDEA
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String author;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private BookStatus status = BookStatus.PENDING;

    @Enumerated(EnumType.STRING)
    private Language language;

    private Integer pageCount;

    @Builder.Default
    private Integer downloadCount = 0;

    @OneToOne(fetch = FetchType.EAGER)
    private Uploads cover;

    @OneToOne(fetch = FetchType.EAGER)
    private Uploads file;


}
