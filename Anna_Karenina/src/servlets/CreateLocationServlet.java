package servlets;

import dao.LocationDAO;
import dao.UserDAO;
import models.Location;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "LocationServlet")
@MultipartConfig
public class CreateLocationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String locationName = request.getParameter("locationName");
        String description = request.getParameter("about");

        LocationDAO dao = new LocationDAO();

        request.getSession().setAttribute("locationDescription", description);
        request.getSession().setAttribute("locationName", locationName);

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

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();

        Location location = new Location(1, locationName, localdir + "/" + filename, description,
                dtf.format(localDate));

        dao.save(location);

        LocationDAO ld = new LocationDAO();
        ArrayList<Location> locations = ld.getAll();

        request.setAttribute("locations", locations);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/locations.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/createLocation.jsp");
        dispatcher.forward(request, response);
    }
}
