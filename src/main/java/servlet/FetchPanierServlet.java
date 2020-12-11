package servlet;

import dao.ArticleService;
import dao.PanierService;
import metier.Article;
import metier.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "fetch_panier", urlPatterns = {"/fetchPanier"})
public class FetchPanierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("user");
        PanierService panierService = new PanierService();
        ArticleService articleService = new ArticleService();
        if(user != null) {
            List<Article> allArticle = articleService.findAll();
            List<Article> articleList = panierService.fetchPanierArticlesByUserId(user.getId());

            httpSession.setAttribute("allArticles",allArticle);
            httpSession.setAttribute("panier",articleList);
            req.getRequestDispatcher("Panier.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }


}
