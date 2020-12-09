package servlet;

import dao.ArticleService;
import dao.UserService;
import metier.Article;
import metier.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "all_users", urlPatterns = {"/allUsers"})
public class AllUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("user");

        if(user != null && user.getRole().equals("admin")) {
            UserService userService = new UserService();
            List<User> userList = new ArrayList<>();
            userList = userService.findAll();

            req.setAttribute("allUsers",userList);
            req.getRequestDispatcher("AllUsers.jsp").forward(req,resp);

        }else{
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
