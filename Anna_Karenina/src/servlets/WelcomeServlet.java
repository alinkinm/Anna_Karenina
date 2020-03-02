package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("currentSessionUser") != null) {
            RequestDispatcher dispatcher
                    = this.getServletContext().getRequestDispatcher("/profile");
            dispatcher.forward(request, response);
        }

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }
}
