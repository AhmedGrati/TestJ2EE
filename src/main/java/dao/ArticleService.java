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
        List<Article> articleList = new ArrayList<Article>();
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
                articleList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articleList;
    }

    @Override
    public List<Article> findByCode(String code) {
        List<Article> articleList = new ArrayList<Article>();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from article WHERE UPPER(article_code) LIKE UPPER(?)");
            ps.setString(1,code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Article p = new Article();
                p.setId(rs.getInt("ARTICLE_ID"));
                p.setCode(rs.getString("ARTICLE_CODE"));
                p.setPrice(rs.getDouble("ARTICLE_PRICE"));
                p.setName(rs.getString("ARTICLE_NAME"));
                p.setDescription(rs.getString("ARTICLE_DESCRIPTION"));
                articleList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articleList;
    }

    @Override
    public List<Article> findByName(String name) {
        List<Article> articleList = new ArrayList<Article>();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from article WHERE UPPER(article_name) LIKE UPPER(?)");
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Article p = new Article();
                p.setId(rs.getInt("ARTICLE_ID"));
                p.setCode(rs.getString("ARTICLE_CODE"));
                p.setPrice(rs.getDouble("ARTICLE_PRICE"));
                p.setName(rs.getString("ARTICLE_NAME"));
                p.setDescription(rs.getString("ARTICLE_DESCRIPTION"));
                articleList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articleList;
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
        System.out.println("id : "+article.getId());
        Connection connection = SingletonConnection.getConnection();
        try {

            String query = "UPDATE article\n" +
                    "SET article_code = ?, article_name= ? , article_price = ? , article_description = ? \n" +
                    "WHERE article_id = ?;";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,article.getCode());
            ps.setString(2,article.getName());
            ps.setDouble(3,article.getPrice());
            ps.setString(4,article.getDescription());
            ps.setInt(5,article.getId());
            int resultSet = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteArticleById(int id) {
        Connection connection = SingletonConnection.getConnection();
        try {

            String query = "DELETE FROM article WHERE ARTICLE_ID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            int resultSet = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Article findById(int id) {
        Article article = new Article();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from article where article_id LIKE ?");
            ps.setInt(1, id );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                article.setId(rs.getInt("article_id"));
                article.setCode(rs.getString("article_code"));
                article.setName(rs.getString("article_name"));
                article.setPrice(rs.getDouble("article_price"));
                article.setDescription(rs.getString("article_description"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }
}
