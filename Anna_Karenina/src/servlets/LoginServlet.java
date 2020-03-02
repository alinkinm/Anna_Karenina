package servlets;

import dao.UserDAO;
import models.Password;
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
        User user = dao.find(username);
        boolean yuy = false;

        try {
            yuy = Password.checkPassword(password, user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (user == null || !yuy ) {

            String errorMessage = "Invalid userName or Password";

            request.getSession().setAttribute("errorMessage", errorMessage);

            RequestDispatcher dispatcher
                    = this.getServletContext().getRequestDispatcher("/LoginPage.jsp");

            dispatcher.forward(request, response);
        } else {

            HttpSession session = request.getSession(true);

            session.setAttribute("currentSessionUser", user);


            session.setAttribute("username", username);
            session.setAttribute("photo", user.getPhoto());
            session.setAttribute("about", user.getAbout());

            if(request.getParameter("rememberMe").equals("true")) {


            }


        }



        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/profile.jsp");

        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/LoginPage.jsp");

        dispatcher.forward(request, response);
    }
}

