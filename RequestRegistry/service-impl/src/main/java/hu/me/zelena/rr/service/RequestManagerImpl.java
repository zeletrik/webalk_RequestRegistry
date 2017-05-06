package hu.me.zelena.rr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.me.zelena.rr.dao.RequestDAO;
import hu.me.zelena.rr.model.Request;

@Service
public class RequestManagerImpl implements RequestManager {
	
	@Autowired
	RequestDAO dao;

	@Override
	public List<Request> findAll() {
		return dao.findAll();
	}

	@Override
	public Request findByUser(String username) {
		return dao.findByUser(username);
	}

	@Override
	public Request find(int id) {
		return dao.find(id);
	}

	@Override
	public void createRequest(Request request) {
		dao.createRequest(request);

	}

	@Override
	public void deleteRequest(Request request) {
		dao.deleteRequest(request);

	}

	@Override
	public void makeVerdict(int id, String verdict) {
		dao.makeVerdict(id, verdict);

	}

}
