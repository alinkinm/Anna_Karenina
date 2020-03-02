package servlets;

import dao.UserDAO;
import models.Password;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

import java.util.Date;

@WebServlet(name = "RegistrationServlet")
@MultipartConfig
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("cp1251");
        response.setContentType("text/html;charset=cp1251");

        String username = request.getParameter("username");
        String name = request.getParameter("firstname");
        String password = request.getParameter("password");




            String newsuperpass = Password.hashPassword(password);


        String about = request.getParameter("about");


        Date date = new Date();
        UserDAO dao = new UserDAO();

        request.getSession().setAttribute("name", name);
        Part p = request.getPart("photo");
        String localdir = "uploads";
        String pathDir = getServletContext().getRealPath("") + File.separator + localdir;
        File dir = new File(pathDir);
        if (!dir.exists()) {
            dir.mkdir();
        }

        String[] filename_data = p.getSubmittedFileName().split("\\.");
        String filename = Math.random() + "." + filename_data[filename_data.length - 1];
        String fullpath = pathDir + File.separator + filename;
        p.write(fullpath);

        if (dao.usernameExist(username)) {
            String errorMessage = "такой пользователь уже существует";
            request.getSession().setAttribute("errorMessage", errorMessage);
            response.sendRedirect(request.getRequestURI());
            //RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/registration");
            //dispatcher.forward(request, response);
            //response.sendRedirect("/reg.jsp");

        } else {

            User user = new User(username, newsuperpass, (long) 1, date, about,
                    localdir + "/" + filename);
            dao.save(user);
            RequestDispatcher dispatcher
                    = this.getServletContext().getRequestDispatcher("/login");

            dispatcher.forward(request, response);
        }

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
