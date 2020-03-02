package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LocationPageServlet")
public class LocationPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String id = request.getParameter("id");
        request.setAttribute("title", title);
        request.setAttribute("locId", id);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/location.jsp");
        dispatcher.forward(request, response);
    }
}
