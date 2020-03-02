package servlets;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "AnswerServlet")
public class AnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String who = request.getParameter("komuNahuy");

        request.setAttribute("komuNahuy", who);
        String title = request.getParameter("title");
        String hid = request.getParameter("id");
        int id = Integer.parseInt(hid);

        request.setAttribute("locId", hid);
        request.setAttribute("title", title);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/location.jsp");
        dispatcher.forward(request, response);
    }
}
