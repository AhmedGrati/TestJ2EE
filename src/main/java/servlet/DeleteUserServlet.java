package servlet;

import dao.ArticleService;
import dao.UserService;
import metier.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "delete_user", urlPatterns = {"/deleteUser"})
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("user");
        if(user != null && user.getRole().equals("admin")) {
            int id = Integer.parseInt(req.getParameter("id"));
            UserService userService = new UserService();

            userService.deleteUserById(id);

            resp.sendRedirect("allUsers");
        }else{
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }

    }


}
