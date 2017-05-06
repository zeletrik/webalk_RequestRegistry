package hu.me.zelena.rr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.me.zelena.rr.dao.UserDAO;
import hu.me.zelena.rr.model.User;

@Service
public class UserManagerImpl implements UserManager {

	@Autowired
	UserDAO dao;
	
	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public User findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public void insertUser(User user) {
		dao.insertUser(user);
		
	}

	@Override
	public void deleteUser(User user) {
		dao.deleteUser(user);
		
	}

}
