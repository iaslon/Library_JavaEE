package com.company.lib.service.file;

import com.company.lib.domains.Uploads;

import javax.servlet.http.Part;
import java.io.File;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 05:11 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
public interface FileStorageService {

    Uploads upload(Part part);



}
