package com.company.lib.dao;

import com.company.lib.domains.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Optional;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 03:14 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDAO extends GenericDAO<User,Long>{

    private static UserDAO userDAO;

    public static UserDAO getInstance(){
        if (userDAO==null){
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    public Optional<User> findByEmail(String email){
        Session session = getSession();
        session.beginTransaction();
        Query<User> query = session.createQuery("select t from User t where t.email=:email", User.class);
        User user = query.setParameter("email", email).getSingleResultOrNull();
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(user);
    }

}
