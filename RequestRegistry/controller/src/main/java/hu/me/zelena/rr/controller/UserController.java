package hu.me.zelena.rr.controller;

import hu.me.zelena.rr.model.Request;
import hu.me.zelena.rr.model.Template;
import hu.me.zelena.rr.model.User;
import hu.me.zelena.rr.service.RequestManager;
import hu.me.zelena.rr.service.TemplateManager;
import hu.me.zelena.rr.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserManager usermanager;
	
	@Autowired
	TemplateManager templatemanager;
	
	@Autowired
	RequestManager requestmanager;
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<User> list() {
		return usermanager.findAll();
	}
	
	@GetMapping(path = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User findByName(@PathVariable("name") String name) {
		return usermanager.findByName(name);
	}
	
	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createNew(@RequestBody User newUser) {
		usermanager.insertUser(newUser);
	}
	
	
	
	
	@GetMapping(path = "/template/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Template>  findTemplate() {
		return templatemanager.findAll();
	}

	
	@GetMapping(path = "/req/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Request>  findReq() {
		return requestmanager.findAll();
	}
	
	@PostMapping(path = "/req/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public void createReq(@RequestBody Request req) {
		requestmanager.createRequest(req);
	}
	
	@PostMapping(path = "/req/{id}/{verdict}")
	public void updateReq(@PathVariable("id") int id, @PathVariable("verdict") String verdict ) {
		requestmanager.makeVerdict(id, verdict);
	}
}
