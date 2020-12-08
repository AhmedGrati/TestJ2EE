package dao;


import metier.User;

import java.util.List;

public interface UserDAO {

    User login(String email, String password);

    public List<User> findAll();


    public void saveUser(User user);
    public void updateUser(User user);

    public void deleteUserById(int id);

    public User findById(int id);



}
