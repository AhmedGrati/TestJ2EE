package dao;

import metier.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleDAO {
    public List<Article> findAll();
    public List<Article> findByCode(String code);
    public List<Article> findByName(String name);

    public void saveArticle(Article article);
    public void updateArticle(Article article);

    public void deleteArticleById(int id);

    public Article findById(int id);
}
