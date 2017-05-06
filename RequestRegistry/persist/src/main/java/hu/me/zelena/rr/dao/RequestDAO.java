package hu.me.zelena.rr.dao;

import java.util.List;

import hu.me.zelena.rr.model.Request;

public interface RequestDAO {
	
	List<Request> findAll();
	Request findByUser (String username);
	Request find (int id);
	public void createRequest(Request request);
	public void deleteRequest(Request request);
	public void makeVerdict(int id, String verdict);

}
