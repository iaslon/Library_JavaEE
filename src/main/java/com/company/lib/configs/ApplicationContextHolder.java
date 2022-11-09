package com.company.lib.configs;

import com.company.lib.dao.BookDAO;
import com.company.lib.dao.UploadDAO;
import com.company.lib.dao.UserDAO;
import com.company.lib.service.auth.UserServiceImpl;
import com.company.lib.service.book.BookServiceImpl;
import com.company.lib.service.file.FileStorageServiceImpl;
import com.company.lib.utils.BaseUtils;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 03:53 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
public class ApplicationContextHolder {

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName){

        return switch (beanName){
            case "BaseUtils" -> (T) BaseUtils.getInstance();
            case "UserServiceImpl" -> (T) UserServiceImpl.getInstance();
            case "BookServiceImpl" -> (T) BookServiceImpl.getInstance();
            case "FileStorageServiceImpl" -> (T) FileStorageServiceImpl.getInstance();
            case "UserDAO" -> (T) UserDAO.getInstance();
            case "BookDAO" -> (T) BookDAO.getInstance();
            case "UploadDAO" -> (T) UploadDAO.getInstance();
            default -> throw new RuntimeException("Bean not found %s".formatted(beanName));
        };
    }

    public static <T> T getBean(Class<T> clazz){

        String simpleName = clazz.getSimpleName();
        return getBean(simpleName);
    }

}
