package servlet;

import dao.ArticleService;
import metier.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "delete_article",urlPatterns = {"/deleteArticle"})
public class DeleteArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("user");
        if(user != null) {
            int id = Integer.parseInt(req.getParameter("id"));
            ArticleService articleService = new ArticleService();

            articleService.deleteArticleById(id);

            resp.sendRedirect("allArticle");
        }else{
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }

    }
}
