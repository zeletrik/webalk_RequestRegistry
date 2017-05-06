package hu.me.zelena.rr.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.me.zelena.rr.model.Request;
import hu.me.zelena.rr.dao.RequestDAO;

@Repository
@Transactional
public class RequestDAOImpl implements RequestDAO {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Request> findAll() {
		List<Request> requests =
				manager.createQuery("Select p From Request p", Request.class).getResultList();
		return requests;
	}

	@Override
	public Request findByUser(String username) {
		Request req = manager.createQuery("SELECT c from Request c WHERE c.user LIKE ?", Request.class).setParameter(1, username).getSingleResult();
		return req;
	}

	@Override
	public Request find(int id) {
		return manager.find(Request.class, id);
	}

	@Override
	public void createRequest(Request request) {
		manager.persist(request);

	}

	@Override
	public void deleteRequest(Request request) {
		manager.remove(request);

	}

	@Override
	public void makeVerdict(int id, String verdict) {
		Request req = manager.find(Request.class, id);
		req.setStatus(verdict);

	}

}
