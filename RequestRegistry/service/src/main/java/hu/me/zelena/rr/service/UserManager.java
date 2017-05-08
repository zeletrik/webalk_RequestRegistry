package hu.me.zelena.rr.service;

import hu.me.zelena.rr.model.User;

import java.util.List;

public interface UserManager {

    List<User> findAll();

    User findByName(String name);

    public void insertUser(User user);

    public void deleteUser(User user);

    public void updateUser(User user);
}
