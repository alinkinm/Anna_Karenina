package servlets;

import dao.HeroDAO;
import dao.UserDAO;
import models.Hero;
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
import java.nio.file.StandardCopyOption;

@WebServlet(name = "CreateHeroServlet")
@MultipartConfig
public class CreateHeroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("cp1251");
        response.setCharacterEncoding("cp1251");
        response.setContentType("text/html;charset=cp1251");

        HeroDAO dao = new HeroDAO();
        String name = request.getParameter("heroname");
        String desc = request.getParameter("desc");

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

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentSessionUser");
        long user_id = user.getId();

        Hero hero = new Hero(1, user_id, name,  localdir + "/" + filename, desc);

        dao.save(hero);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/myheroes");
        dispatcher.forward(request, response);

        /*Part part = request.getPart("photo");
        if (part == null) {
            response.sendRedirect("null.jsp");
        } else {
            InputStream is = part.getInputStream();

            File uploads = new File("/home/alina");

            File file = File.createTempFile("file-", ".png", uploads);

            try (is) {
                Files.copy(is, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
            
            String photo = file.getName();

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("currentSessionUser");
            long user_id = user.getId();

            Hero hero = new Hero(1, user_id, name, photo, desc);

            dao.save(hero);
            response.sendRedirect("my_heroes.jsp");

        }*/


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("currentSessionUser") != null) {
            RequestDispatcher dispatcher
                    = this.getServletContext().getRequestDispatcher("/createHero.jsp");
            dispatcher.forward(request, response);
        }

        else {
            RequestDispatcher dispatcher
                    = this.getServletContext().getRequestDispatcher("/login");
            dispatcher.forward(request, response);
        }

    }
}
