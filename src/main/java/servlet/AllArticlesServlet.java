package servlet;

import dao.ArticleService;
import metier.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "all_article",urlPatterns = {"/allArticle"})
public class AllArticlesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArticleService articleService = new ArticleService();
        List<Article> articleList = articleService.findAll();

        req.setAttribute("allArticles",articleList);
        req.getRequestDispatcher("AllArticles.jsp").forward(req,resp);
    }
}
