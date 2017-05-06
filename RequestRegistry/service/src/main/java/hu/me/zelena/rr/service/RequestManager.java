package hu.me.zelena.rr.service;

import hu.me.zelena.rr.model.Request;

import java.util.List;

public interface RequestManager {
	
	List<Request> findAll();
	Request findByUser (String username);
	Request find (int id);
	public void createRequest(Request request);
	public void deleteRequest(Request request);
	public void makeVerdict(int id, String verdict);

	public void forward(int id, String admin);

	public void addComment(int id, String comment);
}
