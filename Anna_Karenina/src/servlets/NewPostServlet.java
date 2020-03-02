package servlets;

import dao.HeroDAO;
import dao.PostDAO;
import models.Hero;
import models.Post;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "NewPostServlet")
public class NewPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String heroName = request.getParameter("heroName");

        String title = request.getParameter("title");
        String hid = request.getParameter("id");
        int id = Integer.parseInt(hid);
        HttpSession session = request.getSession();
        int userid = (int) ((User)session.getAttribute("currentSessionUser")).getId();
        Date date = new Date();
        Post post = new Post(1, userid, request.getParameter("content"), date, id, heroName);
        PostDAO pd = new PostDAO();
        pd.save(post);


        request.setAttribute("locId", hid);
        request.setAttribute("title", title);


        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/location.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
