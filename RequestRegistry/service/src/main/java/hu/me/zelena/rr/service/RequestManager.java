package hu.me.zelena.rr.service;

import java.util.List;

import hu.me.zelena.rr.model.Request;

public interface RequestManager {
	
	List<Request> findAll();
	Request findByUser (String username);
	Request find (int id);
	public void createRequest(Request request);
	public void deleteRequest(Request request);
	public void makeVerdict(int id, String verdict);

}
