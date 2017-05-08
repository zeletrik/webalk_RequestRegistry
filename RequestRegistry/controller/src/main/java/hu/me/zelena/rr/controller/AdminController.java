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

/**
 * Created by patrik on 2017.05.06..
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserManager usermanager;

    @Autowired
    TemplateManager templatemanager;

    @Autowired
    RequestManager requestmanager;

    @PostMapping(path = "/templates/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void newTemplate(@RequestBody Template newTemplate) {
        templatemanager.insertTemplate(newTemplate);
    }

    @GetMapping(path = "/requests/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Request> allRequest() {
        return requestmanager.findAll();
    }

    @GetMapping(path = "/requests/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Request> userRequests(@PathVariable("username") String name) {
        return requestmanager.findByUser(name);
    }

    @GetMapping(path = "/requests/{request}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Request showRequest(@PathVariable("request") int id) {
        return requestmanager.find(id);
    }

    @PostMapping(path = "/requests/{request}/{verdict}")
    public void makeVerdict(@PathVariable("request") int id, @PathVariable("verdict") String verdict) {
        requestmanager.makeVerdict(id, verdict);
    }

    @GetMapping(path = "/user/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> allUser() {
        return usermanager.findAll();
    }

    @PostMapping(path = "/user/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void newUser(@RequestBody User newUser) {
        usermanager.insertUser(newUser);
    }

}
