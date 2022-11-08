package com.company.lib.configs;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.reflections.Reflections;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 00:59 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HibernateConfigurer {

    private static SessionFactory sessionFactory=setUp();

    private static SessionFactory setUp(){

        StandardServiceRegistry registry=null;

        if (sessionFactory==null){
            try {
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
            Properties properties = new Properties();

                properties.load(new FileReader("C:\\Users\\Admin\\Desktop\\ogabek\\Resume_service\\Library_JavaEE\\src\\main\\resources\\datasource.properties"));

                registryBuilder.applySettings(properties);
                 registry = registryBuilder.build();
                MetadataSources sources = new MetadataSources(registry);

                Reflections reflections = new Reflections("com.company.lib.domains");
                reflections.getTypesAnnotatedWith(Entity.class)
                        .forEach(clazz -> sources.addAnnotatedClassName(clazz.getName()));

                Metadata metadata = sources.getMetadataBuilder().build();
                SessionFactory sessionFactory1 = metadata.getSessionFactoryBuilder().build();
                return sessionFactory1;

            } catch (Exception e) {

                if (Objects.nonNull(registry)) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
                throw new RuntimeException("Hibernate exception %s".formatted(e.getMessage()));
            }
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory(){
        if (sessionFactory==null || sessionFactory.isClosed()){
            sessionFactory = setUp();
        }
        return sessionFactory;
    }

}
