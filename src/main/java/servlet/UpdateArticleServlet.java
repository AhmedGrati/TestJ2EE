package servlet;

import dao.ArticleService;
import metier.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "update_article",urlPatterns = {"/updateArticle"})
public class UpdateArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ArticleService articleService = new ArticleService();
        Article article = articleService.findById(id);
        req.setAttribute("article",article);
        req.getRequestDispatcher("UpdateArticle.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        int id = Integer.parseInt(req.getParameter("id"));
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");

        Article article = new Article();
        article.setName(name);
        article.setDescription(description);
        article.setPrice(price);
        article.setCode(code);
        article.setId(id);
        ArticleService articleService = new ArticleService();
        articleService.updateArticle(article);


        resp.sendRedirect("allArticle");
    }
}
