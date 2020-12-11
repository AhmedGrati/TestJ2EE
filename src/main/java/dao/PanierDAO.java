package dao;

import metier.Article;
import metier.Panier;

import java.util.List;

public interface PanierDAO {
    List<Article> fetchPanierArticlesByUserId(int userId);

    void addArticleToPanier(int userId, int articleId);

    boolean getPanierByUserId(int userId);

}
