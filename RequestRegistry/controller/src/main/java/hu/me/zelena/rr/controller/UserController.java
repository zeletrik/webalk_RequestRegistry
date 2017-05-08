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


    @GetMapping(path = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User details(@PathVariable("name") String name) {
        return usermanager.findByName(name);
    }

    @PostMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody User update) {
        usermanager.updateUser(update);
    }

    @GetMapping(path = "/requests/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Request> userRequests(@PathVariable("name") String name) {
        return requestmanager.findByUser(name);
    }

    @GetMapping(path = "/template/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Template> showTemplates() {
        return templatemanager.findAll();
    }

    @GetMapping(path = "/template/{template}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Template selectedTemplate(@PathVariable("template") String template) {
        return templatemanager.findByName(template);
    }

    @PostMapping(path = "/requests/make-request", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createReq(@RequestBody Request req) {
        requestmanager.createRequest(req);
    }

}
