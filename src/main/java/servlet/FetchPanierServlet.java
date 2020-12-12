package servlet;

import dao.ArticleService;
import dao.PanierService;
import metier.Article;
import metier.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "fetch_panier", urlPatterns = {"/fetchPanier"})
public class FetchPanierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("user");
        PanierService panierService = new PanierService();
        if(user != null) {
            List<Article> panierArticles = panierService.fetchPanierArticlesByUserId(user.getId());
            ArticleService articleService = new ArticleService();
            String code = req.getParameter("code");
            String name = req.getParameter("name");
            boolean tri = Boolean.parseBoolean(req.getParameter("tri"));
            List<Article> articleList = new ArrayList<>();
            if(code != null) {
                articleList = articleService.findByCode(code);
                if(articleList == null || articleList.size() == 0) {
                    Cookie cookie = new Cookie("Article_Not_Found","There_is_no_article_with_this_code"+code);
                    resp.addCookie(cookie);
                    req.setAttribute("Result Search","Article Not Found:"+"There is no article with this code: "+code);
                    req.getRequestDispatcher("Article404.jsp").forward(req,resp);
                }else{
                    req.setAttribute("allArticles",articleList);
                    httpSession.setAttribute("panier",panierArticles);
                    req.getRequestDispatcher("Panier.jsp").forward(req,resp);
                }
            }else if(name != null) {
                articleList = articleService.findByName(name);
                if(articleList == null || articleList.size() == 0) {
                    Cookie cookie = new Cookie("Article_Not_Found","There_is_no_article_with_this_name"+name);
                    resp.addCookie(cookie);
                    req.setAttribute("Result Search","Article Not Found-"+"There is no article with this name: "+name);
                    req.getRequestDispatcher("Article404.jsp").forward(req,resp);
                }else{
                    req.setAttribute("allArticles",articleList);
                    httpSession.setAttribute("panier",panierArticles);
                    req.getRequestDispatcher("Panier.jsp").forward(req,resp);
                }
            }else{
                articleList = articleService.findAll();
                req.setAttribute("allArticles",articleList);
                httpSession.setAttribute("panier",panierArticles);
                req.getRequestDispatcher("Panier.jsp").forward(req,resp);
            }

            if(tri) {
                articleList = articleList.stream()
                        .sorted(Comparator.comparingDouble(Article::getPrice))
                        .collect(Collectors.toList());
                req.setAttribute("allArticles",articleList);
                httpSession.setAttribute("panier",panierArticles);
                req.getRequestDispatcher("Panier.jsp").forward(req,resp);
            }

        }else{
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }

}
