package servlet;

import dao.UserService;
import metier.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession httpSession = req.getSession(true);
        User user = null;
        if(email != null && password != null) {
            user = userService.login(email,password);
            System.out.println(user);
            if(user != null) {
                System.out.println(user.getRole());
                if(user.getRole().equals("admin")) {
                    resp.sendRedirect("allUsers");
                } else {
                    resp.sendRedirect("fetchPanier");
                }
            } else {
                req.setAttribute("error","Email Or Password Are Invalid!");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }
        }
        httpSession.setAttribute("user",user);
    }
}
