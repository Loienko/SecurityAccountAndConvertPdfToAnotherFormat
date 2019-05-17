package net.ukr.dreamsicle.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet({"/", "/index"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,    //2 MB
        maxFileSize = 1024 * 1024 * 10,         //10MB
        maxRequestSize = 1024 * 1024 * 50       //50MB
)
public class HomeServlet extends HttpServlet {

    private static final String SAVE_DIRECTORY = "empty";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/JSP/homeView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String fullSavePath = "";
            Part part = request.getPart("");
            String fileName = extractFileName(part);
            if (fileName != null && fileName.length() > 0) {
                part.write(fullSavePath + File.separator + fileName);
            }

            response.sendRedirect(request.getContextPath() + "/convertFile");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error: " + e.getMessage());
            getServletContext().getRequestDispatcher("/WEB-INF/JSP/convertFile.jsp").forward(request, response);
        }
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                clientFileName = clientFileName.replace("\\", "/");
                return clientFileName.substring(clientFileName.lastIndexOf('/') + 1);
            }
        }
        return null;
    }
}
