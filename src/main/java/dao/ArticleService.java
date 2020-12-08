package dao;

import metier.Article;

import java.util.List;
import java.util.Optional;

public class ArticleService implements ArticleDAO {
    @Override
    public List<Article> findAll() {
        return null;
    }

    @Override
    public Optional<Article> findByCode(String code) {
        return Optional.empty();
    }

    @Override
    public Optional<Article> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public void saveArticle(Article article) {

    }

    @Override
    public void updateArticle(Article article) {

    }

    @Override
    public void deleteArticleById(int id) {

    }
}
