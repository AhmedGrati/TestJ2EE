package dao;

import metier.Article;
import metier.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDAO{

    @Override
    public User login(String email, String password) {
        User user = null;
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from users WHERE email LIKE ? and user_password like ?");
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setAge(rs.getInt("age"));
                user.setEmail(rs.getString("email"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setPassword(rs.getString("user_password"));
                user.setRole(rs.getString("user_role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<User>();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user = new User();
                user.setId(rs.getInt("id"));
                user.setAge(rs.getInt("age"));
                user.setEmail(rs.getString("email"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setPassword(rs.getString("user_password"));
                user.setRole(rs.getString("user_role"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void saveUser(User user) {
        Connection connection = SingletonConnection.getConnection();
        try {

            String query = "INSERT INTO users(first_name,last_name,age,email,user_password,user_role) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,user.getFirstName());
            ps.setString(2,user.getLastName());
            ps.setDouble(3,user.getAge());
            ps.setString(4,user.getEmail());
            ps.setString(5,user.getPassword());
            ps.setString(6,user.getRole());
            int resultSet = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        System.out.println("id : "+user.getId());
        Connection connection = SingletonConnection.getConnection();
        try {

            String query = "UPDATE users\n" +
                    "SET first_name = ?, last_name= ? , age = ? , email = ? , user_role = ? , user_password = ? \n" +
                    "WHERE id = ?;";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,user.getFirstName());
            ps.setString(2,user.getLastName());
            ps.setDouble(3,user.getAge());
            ps.setString(4,user.getEmail());
            ps.setString(5,user.getRole());
            ps.setString(6,user.getPassword());
            ps.setInt(7,user.getId());
            int resultSet = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUserById(int id) {
        Connection connection = SingletonConnection.getConnection();
        try {

            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            int resultSet = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(int id) {
        User user = new User();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from users where id LIKE ?");
            ps.setInt(1, id );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setAge(rs.getInt("age"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("user_role"));
                user.setPassword(rs.getString("user_password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
