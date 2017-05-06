package hu.me.zelena.rr.controller;

import hu.me.zelena.rr.model.Request;
import hu.me.zelena.rr.service.RequestManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by patrik on 2017.05.06..
 */

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    RequestManager requestmanager;

    @GetMapping(path = "/requests/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Request> allRequest() {
        return requestmanager.findAll();
    }

    @PostMapping(path = "/requests/forward/{request}/{admin}")
    public void forwardRequest(@PathVariable("request") int id, @PathVariable("admin") String admin) {
        requestmanager.forward(id, admin);
    }

    @GetMapping(path = "/requests/{request}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Request showRequest(@PathVariable("request") int id) {
        return requestmanager.find(id);
    }

    @PostMapping(path = "/requests/{request}/{comment}")
    public void createReq(@PathVariable("request") int id, @PathVariable("comment") String comment) {
        requestmanager.addComment(id, comment);
    }

}