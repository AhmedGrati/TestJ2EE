package servlet;

import dao.ArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delete_article",urlPatterns = {"/deleteArticle"})
public class DeleteArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ArticleService articleService = new ArticleService();

        articleService.deleteArticleById(id);

        resp.sendRedirect("allArticle");
    }
}
