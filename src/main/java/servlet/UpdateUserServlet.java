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

@WebServlet(name = "update_user", urlPatterns = {"/updateUser"})
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("user");
        if(user != null && user.getRole().equals("admin")) {
            int id = Integer.parseInt(req.getParameter("id"));
            UserService userService = new UserService();
            User user1 = userService.findById(id);
            req.setAttribute("user",user1);
            req.getRequestDispatcher("UpdateUser.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        int age = Integer.parseInt(req.getParameter("age"));
        int id = Integer.parseInt(req.getParameter("id"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");


        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        user.setId(id);
        UserService userService = new UserService();
        userService.updateUser(user);


        resp.sendRedirect("allUsers");
    }
}
