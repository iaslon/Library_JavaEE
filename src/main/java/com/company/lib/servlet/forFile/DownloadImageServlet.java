package com.company.lib.servlet.forFile;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author "Khazratov Aslonbek"
 * @since 11/09/2022 05:29 (Wednesday)
 * Library_JavaEE/IntelliJ IDEA
 */
@WebServlet("/download")
public class DownloadImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestedImage = req.getParameter("img");
        Path path = Paths.get("/home/dilshodbek/Uploads", requestedImage);
        ServletOutputStream outputStream = resp.getOutputStream();
        Files.copy(path,outputStream);

    }

}
