package com.demo.sakila;

import com.demo.sakila.actor.ActorDto;
import com.demo.sakila.actor.ActorRepository;
import com.demo.sakila.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called actorRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ActorRepository actorRepository;

    @Autowired
    private MapService mapService;
    @GetMapping(path="/all")
    public @ResponseBody Iterable<ActorDto> getAllActors() {
        // This returns a JSON or XML with the users
        return mapService.getAllActors();
    }
}