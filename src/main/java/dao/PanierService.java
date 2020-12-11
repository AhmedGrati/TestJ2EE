package dao;

import metier.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PanierService implements PanierDAO {
    @Override
    public List<Article> fetchPanierArticlesByUserId(int userId) {
        List<Article> articleList = new ArrayList<>();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT\n" +
                    "    `article`.*\n" +
                    "FROM\n" +
                    "    `article`\n" +
                    "    JOIN `panier` ON `article`.`article_id` = `panier`.`article_id`\n" +
                    "WHERE\n" +
                    "    `panier`.`user_id` = ?");
            ps.setInt(1, userId);
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
    public void addArticleToPanier(int userId, int articleId) {
        Connection connection = SingletonConnection.getConnection();
        try {

            String query = "INSERT INTO panier(user_id,article_id) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,userId);
            ps.setInt(2,articleId);

            int resultSet = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteArticleFromPanier(int userId, int articleId) {
        Connection connection = SingletonConnection.getConnection();
        try {

            String query = "DELETE FROM panier WHERE user_id = ? and article_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, articleId);
            int resultSet = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean getPanierByUserId(int userId) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from panier where user_id LIKE ?");
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("USER HAS PANIER");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("USER HASN'T PANIER");
        return false;
    }
}
