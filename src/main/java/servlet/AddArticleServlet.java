package servlet;

import dao.ArticleService;
import metier.Article;
import metier.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "add_article",urlPatterns = {"/addArticle"})
public class AddArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("user");
        if(user != null && user.getRole().equals("admin")) {
            req.getRequestDispatcher("AddArticle.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");

        Article article = new Article();
        article.setName(name);
        article.setDescription(description);
        article.setPrice(price);
        article.setCode(code);

        ArticleService articleService = new ArticleService();
        articleService.saveArticle(article);
        resp.sendRedirect("allArticle");
    }
}
