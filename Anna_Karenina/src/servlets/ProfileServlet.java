package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("currentSessionUser") == null) {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login");
            dispatcher.forward(request, response);
        }

        else {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/profile.jsp");
            dispatcher.forward(request, response);
        }


    }
}
