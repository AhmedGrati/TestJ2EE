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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "all_article",urlPatterns = {"/allArticle"})
public class AllArticlesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("user");
        if(user != null && user.getRole().equals("admin")) {
            ArticleService articleService = new ArticleService();
            String code = req.getParameter("code");
            String name = req.getParameter("name");
            boolean tri = Boolean.parseBoolean(req.getParameter("tri"));
            List<Article> articleList = new ArrayList<>();
            if(code != null) {
                articleList = articleService.findByCode(code);
            }else if(name != null) {
                articleList = articleService.findByName(name);
            }else{
                articleList = articleService.findAll();
            }

            if(tri) {
                articleList = articleList.stream()
                        .sorted(Comparator.comparingDouble(Article::getPrice))
                        .collect(Collectors.toList());
            }

            req.setAttribute("allArticles",articleList);
            req.getRequestDispatcher("AllArticles.jsp").forward(req,resp);

        }else{
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }

    }
}
