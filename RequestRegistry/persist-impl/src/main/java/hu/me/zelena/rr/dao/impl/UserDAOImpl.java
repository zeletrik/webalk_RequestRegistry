package hu.me.zelena.rr.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.me.zelena.rr.dao.UserDAO;
import hu.me.zelena.rr.model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<User> findAll() {
		List<User> users = 
				manager.createQuery("Select p From User p", User.class).getResultList();
	return users;
	}

	@Override
	public User findByName(String name) {
		return manager.find(User.class, name);
	}

	@Override
	public void insertUser(User user) {
		manager.persist(user);

	}

	@Override
	public void deleteUser(User user) {
		manager.remove(user);

	}

}
