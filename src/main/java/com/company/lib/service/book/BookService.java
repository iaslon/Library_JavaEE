package com.company.lib.service.book;

import com.company.lib.domains.Book;
import com.company.lib.dto.BookCreateDTO;
import com.company.lib.dto.BookUpdateDTO;
import com.company.lib.enums.BookStatus;
import com.company.lib.exceptions.NotFoundException;

import javax.servlet.http.Part;
import java.util.List;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 04:46 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
public interface BookService {

    void create(BookCreateDTO dto, Part book);

    Book get(long id);

    void delete(long l);

    void update(BookUpdateDTO dto) throws NotFoundException;


    List<Book> getAll();

    List<Book> getAll(String searchQuery, Integer page, Integer limit);

    List<Book> getAllByStatus(BookStatus pending);

    void updateDownloadCount(Long uploadFileId);

}
