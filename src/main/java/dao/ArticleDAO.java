package dao;

import metier.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleDAO {
    public List<Article> findAll();
    public Optional<Article> findByCode(String code);
    public Optional<Article> findByName(String name);

    public void saveArticle(Article article);
    public void updateArticle(Article article);

    public void deleteArticleById(int id);
}
