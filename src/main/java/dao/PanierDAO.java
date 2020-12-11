package dao;

import metier.Article;

import java.util.List;

public interface PanierDAO {
    List<Article> fetchPanierArticlesByUserId(int userId);

    void addArticleToPanier(int userId, int articleId);
    void deleteArticleFromPanier(int userId, int articleId);

    boolean getPanierByUserId(int userId);

}
