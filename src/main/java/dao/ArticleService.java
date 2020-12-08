package dao;

import metier.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArticleService implements ArticleDAO {
    @Override
    public List<Article> findAll() {
        List<Article> prods = new ArrayList<Article>();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from article");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Article p = new Article();
                p.setId(rs.getInt("ARTICLE_ID"));
                p.setCode(rs.getString("ARTICLE_CODE"));
                p.setPrice(rs.getDouble("ARTICLE_PRICE"));
                p.setName(rs.getString("ARTICLE_NAME"));
                p.setDescription(rs.getString("ARTICLE_DESCRIPTION"));
                prods.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prods;
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
        Connection connection = SingletonConnection.getConnection();
        try {

            String query = "INSERT INTO article(ARTICLE_CODE,ARTICLE_NAME,ARTICLE_PRICE,ARTICLE_DESCRIPTION) VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,article.getCode());
            ps.setString(2,article.getName());
            ps.setDouble(3,article.getPrice());
            ps.setString(4,article.getDescription());
            int resultSet = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateArticle(Article article) {

    }

    @Override
    public void deleteArticleById(int id) {

    }
}
