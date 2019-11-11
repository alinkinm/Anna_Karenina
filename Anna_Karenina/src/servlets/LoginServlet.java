package servlets;

import dao.UserDAO;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("cp1251");
        response.setContentType("text/html;charset=cp1251");
        String username = request.getParameter("un");
        String password = request.getParameter("pw");
        UserDAO dao = new UserDAO();
        User user = dao.find(username, password);

        if (user == null) {
            String errorMessage = "Invalid userName or Password";

            request.getSession().setAttribute("errorMessage", errorMessage);

            RequestDispatcher dispatcher
                    = this.getServletContext().getRequestDispatcher("/LoginPage.jsp");

            dispatcher.forward(request, response);
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("currentSessionUser", user);
        session.setAttribute("username", username);
        assert user != null;
        session.setAttribute("photo", user.getPhoto());
        response.sendRedirect("profile.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //request.getRequestDispatcher("/test.jsp").forward(request, response);
        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/LoginPage.jsp");

        dispatcher.forward(request, response);
    }
}

