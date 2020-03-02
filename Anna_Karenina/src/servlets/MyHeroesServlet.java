package servlets;

import dao.HeroDAO;
import dao.PostDAO;
import models.Hero;
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
import java.util.List;

@WebServlet(name = "MyHeroesServlet")
public class MyHeroesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("currentSessionUser") == null) {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login");
            dispatcher.forward(request, response);
        }

        else {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/profile.jsp");
            dispatcher.forward(request, response);
        }


        User user  = (User) session.getAttribute("currentSessionUser");
        PostDAO dao;
        HeroDAO herodao = new HeroDAO();
        ArrayList<Hero> my_heroes = herodao.get2(user.getId());

        session.setAttribute("heroes", my_heroes);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/location.jsp");
        dispatcher.forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/my_heroes.jsp");
        dispatcher.forward(request, response);
    }
}
