package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "delete_article",urlPatterns = {"/deleteArticle"})
public class DeleteArticleServlet extends HttpServlet {
}
