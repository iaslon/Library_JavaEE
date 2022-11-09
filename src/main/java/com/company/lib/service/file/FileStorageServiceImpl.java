package com.company.lib.service.file;

import com.company.lib.configs.ApplicationContextHolder;
import com.company.lib.dao.AbstractDAO;
import com.company.lib.dao.UploadDAO;
import com.company.lib.domains.Uploads;
import com.company.lib.dto.UploadsDTO;
import com.company.lib.exceptions.NotFoundException;
import lombok.NonNull;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 04:52 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
public class FileStorageServiceImpl extends AbstractDAO<UploadDAO> implements FileStorageService {

    private static FileStorageServiceImpl instance;

    private Path rootPath = Paths.get("\"C:\\Users\\Admin\\Desktop\\Uploads\"");
    public FileStorageServiceImpl() {
        super(ApplicationContextHolder.getBean(UploadDAO.class));
    }

    @Override
    public Uploads upload(Part part) {

        try {

            String contentType = part.getContentType();
            String originalName = part.getSubmittedFileName();
            originalName = originalName.replaceAll(",", "_");
            long size = part.getSize();
            String[] split = originalName.split("\\.");
            String fileNameExtension = split[split.length - 1];

            String generatedName = System.currentTimeMillis() + "." + fileNameExtension;
            String path = "/uploads/" + generatedName;
            Uploads uploads = Uploads.builder()
                    .contentType(contentType)
                    .originalName(originalName)
                    .generatedName(generatedName)
                    .size(size)
                    .path(path)
                    .build();
            Path uploadPath = rootPath.resolve(generatedName);
            dao.save(uploads);
            Files.copy(part.getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
            return uploads;
        }catch (IOException e){
            throw new RuntimeException("Something wrong try again");
        }

    }

    @Override
    public File download(@NonNull String fileName) {
        return null;
    }

    @Override
    public UploadsDTO get(@NonNull String fileName) {
        return null;
    }

    @Override
    public List<Uploads> getAll() {
        return null;
    }

    @Override
    public UploadsDTO getByPath(String path) throws NotFoundException {
        Optional<Uploads> byPath = dao.getByPath(path);

        if (byPath.isEmpty()){
            throw new NotFoundException("File not found");
        }

        Uploads uploads = byPath.get();

        return UploadsDTO.builder()
                .id(uploads.getId())
                .path(uploads.getPath())
                .contentType(uploads.getContentType())
                .generatedName(uploads.getGeneratedName())
                .size(uploads.getSize())
                .originalName(uploads.getOriginalName())
                .build();
    }

    @Override
    public Uploads extractCover(Part part) {

        try {
            String contentType = "image/png";
            String[] split = part.getSubmittedFileName().split("\\.");
            String originalFilename = split[0] + "\\.png";
            originalFilename = originalFilename.replaceAll(",","_");
            long size = part.getSize();

            String generatedName = System.currentTimeMillis() + ".png";
            String path = "/uploads/" + generatedName;
            Uploads uploads = Uploads.builder()
                    .contentType(contentType)
                    .originalName(originalFilename)
                    .generatedName(generatedName)
                    .size(size)
                    .path(path)
                    .build();
            String uploadPath = rootPath.resolve(generatedName).toString();
            dao.save(uploads);
            PDDocument document = PDDocument.load(part.getInputStream());
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            BufferedImage bufferedImage = pdfRenderer.renderImageWithDPI(0, 300, ImageType.RGB);
            ImageIOUtil.writeImage(bufferedImage, uploadPath, 300);
            return uploads;
        }catch (IOException e){
            throw new RuntimeException("Something wrong try again");
        }
    }

    public static FileStorageServiceImpl getInstance(){
        if (instance==null){
            instance=new FileStorageServiceImpl();
        }
        return instance;
    }
}
