package ru.kpfu.itis.controller.servlets;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.utilite.HashPassword;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("frontend/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = (UserService) req.getServletContext().getAttribute("userService");
        User user;
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        final boolean remember = req.getParameter("remember") != null;

        user = userService.getUser(email);

        if (user != null) {
            req.getSession().setAttribute("user", user);
            if (remember) {
                Cookie emailCookie = new Cookie("email", email);
                emailCookie.setMaxAge(60 * 60 * 24 * 30);
                Cookie hashCookie = new Cookie("password", HashPassword.hash(password));
                hashCookie.setMaxAge(60 * 60 * 24 * 30);
                resp.addCookie(emailCookie);
                resp.addCookie(hashCookie);
            }
            resp.sendRedirect("/profile");
        } else {
            resp.sendRedirect("/login");
        }
    }
}
