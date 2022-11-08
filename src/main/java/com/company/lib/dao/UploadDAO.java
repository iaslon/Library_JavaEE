package com.company.lib.dao;

import com.company.lib.domains.Uploads;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Optional;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 03:26 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UploadDAO extends GenericDAO<Uploads, Long> {

    private static UploadDAO uploadDAO;

    public static UploadDAO getInstance(){
        if (uploadDAO==null){
            uploadDAO=new UploadDAO();
        }
        return uploadDAO;
    }

    public Optional<Uploads> getByPath(String path){
        Session session = getSession();
        session.beginTransaction();
        Query<Uploads> query = session.createQuery("select t from Uploads t where t.path=:path", Uploads.class);
        query.setParameter("path",path);
        Uploads resultOrNull = query.getSingleResultOrNull();
        session.getTransaction().commit();
        session.close();

        return Optional.ofNullable(resultOrNull);
    }

}
