package servlets;

import dao.UserDAO;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "RegistrationServlet")
@MultipartConfig
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");
        String name = request.getParameter("firstname");
        String password = request.getParameter("password");
        String about = request.getParameter("about");


        Date date = new Date();
        UserDAO dao = new UserDAO();

        request.getSession().setAttribute("name", name);

        Part filePart = request.getPart("photo");
        String photo = null;

        if (filePart == null) {
            response.sendRedirect("null.jsp");
        }
        else {
            InputStream fileContent = filePart.getInputStream();
            File uploads = new File("");
            File file = File.createTempFile("somefilename-", ".png", uploads);
            try (fileContent) {
                Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
            photo = file.getName();
        }

        if (dao.usernameExist(username)) {
            String errorMessage = "такой пользователь уже существует";
            request.getSession().setAttribute("errorMessage", errorMessage);

        } else {

            User user = new User(username, password, (long) 1, date, about, photo);
            dao.save(user);
            response.sendRedirect("LoginPage.jsp");
        }


       /* Part filePart = request.getPart("photo"); // Retrieves <input type="file" name="file">
        //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        if (filePart == null) {
            response.sendRedirect("null.jsp");
        }
        else {
            InputStream fileContent = filePart.getInputStream();

            File uploads = new File("uploads");

            File file = File.createTempFile("somefilename-", ".ext", uploads);

            try (fileContent) {
                Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
            String photo = file.getName();


            if (dao.usernameExist(username)) {
                String errorMessage = "Invalid userName or Password";
                request.getSession().setAttribute("errorMessage", errorMessage);

            } else {

                User user = new User(username, password, (long) 1, date, photo, about);
                dao.save(user);
                response.sendRedirect("LoginPage.jsp");
            }*/
        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("cp1251");
        response.setCharacterEncoding("cp1251");
        response.setContentType("text/html;charset=cp1251");

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/reg.jsp");

        dispatcher.forward(request, response);

    }
}
