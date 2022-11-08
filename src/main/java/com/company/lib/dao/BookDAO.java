package com.company.lib.dao;


import com.company.lib.domains.Book;
import com.company.lib.enums.BookStatus;
import com.company.lib.enums.Genre;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;
import java.util.Optional;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 02:15 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
public class BookDAO extends GenericDAO<Book,Long>{

    private static BookDAO bookDAO;

    public static BaseDAO getInstance(){
        if (bookDAO==null){
            bookDAO = new BookDAO();
        }
        return bookDAO;
    }

    public Optional<List<Book>> findAll(String searchQuery, Integer page, Integer limit){

        Session session = getSession();
        session.beginTransaction();
        Integer skip = (page - 1) * limit;

        NativeQuery<Book> nativeQuery = session.createNativeQuery("select t.* from book t where t.status'ACTIVE' and (t.name ilike '%' ||: searchQuery || '%' or t.author ilike '%' ||:searchQuery || '%') order by t.id desc offset :skip limit", Book.class);
        List<Book> resultList = nativeQuery.setParameter("searchQuery", searchQuery)
                .setParameter("page", page)
                .setParameter("limit", limit)
                .getResultList();
        session.getTransaction().commit();
        session.close();

        return Optional.ofNullable(resultList);
    }


    public Optional<List<Book>> findAll(Genre searchQuery, Integer page, Integer limit) {
        Session session = getSession();
        session.beginTransaction();
        Integer skip = (page - 1) * limit;

        List<Book> resultList = session.createQuery("select t from Book t  where t.status=com.company.lib.enums.BookStatus.ACTIVE and t.genre=:genre order by t.id desc", Book.class)
                .setParameter("genre", searchQuery)
                .setFirstResult(skip)
                .setMaxResults(limit)
                .getResultList();
        session.getTransaction().commit();
        session.close();

        return Optional.ofNullable(resultList);
    }

    public Integer findNumberOfElementBySearch(String search) {
        Session session = getSession();
        session.beginTransaction();
        List<Book> resultList = session.createNativeQuery("select t.* from book t where t.status='ACTIVE' and (t.name ilike '%'||:searchQuery||'%' or t.author ilike '%'||:searchQuery||'%')", Book.class)
                .setParameter("searchQuery", search)
                .getResultList();
        session.getTransaction().commit();
        session.close();

        return resultList.size();
    }

    public List<Book> findAllByStatus(BookStatus pending) {
        Session session = getSession();
        session.beginTransaction();

        List<Book> resultList = session.createQuery("select t from Book t where t.status=com.company.lib.enums.BookStatus.PENDING", Book.class).getResultList();

        session.getTransaction().commit();
        session.close();
        return resultList;
    }

    public Integer findNumberOfElementByGenre(Genre genre) {
        Session session = getSession();
        session.beginTransaction();
        List<Book> resultList = session.createQuery("select t from Book t where t.status=com.company.lib.enums.BookStatus.ACTIVE and t.genre=:genre", Book.class)
                .setParameter("genre", genre)
                .getResultList();
        session.getTransaction().commit();
        session.close();

        return resultList.size();
    }

    public Book findByUploadFileId(Long uploadFileId) {
        Session session = getSession();
        session.beginTransaction();
        Book book = session.createQuery("select t from Book t where t.file.id=:uploadFileId", Book.class)
                .setParameter("uploadFileId", uploadFileId)
                .getSingleResultOrNull();
        session.getTransaction().commit();
        session.close();
        return book;
    }


}
