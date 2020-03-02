package servlets;

import dao.LocationDAO;
import models.Location;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LocationsServlet")
public class LocationsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocationDAO dao = new LocationDAO();
        List<Location> locations;
        locations = dao.getAll();
        request.setAttribute("locations", locations);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/locations.jsp");
        dispatcher.forward(request, response);
    }
}
