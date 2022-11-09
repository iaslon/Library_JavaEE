package com.company.lib.service.file;

import com.company.lib.domains.Uploads;
import com.company.lib.dto.UploadsDTO;
import com.company.lib.exceptions.NotFoundException;
import lombok.NonNull;

import javax.servlet.http.Part;
import java.io.File;
import java.util.List;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 05:11 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
public interface FileStorageService {

    Uploads upload(Part part);

    File download(@NonNull String fileName);

    UploadsDTO get(@NonNull String fileName);

    List<Uploads> getAll();

    UploadsDTO getByPath(String path) throws NotFoundException;

    Uploads extractCover(Part book);

}
