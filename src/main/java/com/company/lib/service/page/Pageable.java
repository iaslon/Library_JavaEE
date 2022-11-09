package com.company.lib.service.page;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 05:18 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
public interface Pageable {
    Boolean hasNext(String search,Integer offset,Integer limit);

    Boolean hasPrevious(Integer offset);

    Integer totalPage(String search,Integer limit);

}
