package hu.me.zelena.rr.dao;

import java.util.List;

import hu.me.zelena.rr.model.User;

public interface UserDAO {
	
	List<User> findAll();
    User findByName(String name);
    public void insertUser(User user);
    public void deleteUser(User user);
}
