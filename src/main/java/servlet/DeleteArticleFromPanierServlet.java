package servlet;

import dao.PanierService;
import metier.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delete_article_from_panier", urlPatterns = {"/deleteFromPanier"})
public class DeleteArticleFromPanierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PanierService panierService = new PanierService();
        int articleId = Integer.parseInt(req.getParameter("articleId"));
        int userId = ((User)req.getSession(false).getAttribute("user")).getId();

        panierService.deleteArticleFromPanier(userId,articleId);
        resp.sendRedirect("fetchPanier");
    }
}
