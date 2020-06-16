package com.vega.springit.controller;

import com.vega.springit.model.Link;
import com.vega.springit.repository.LinkRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/links")
public class LinkController {

    private LinkRepository linkRepository;

    public LinkController(LinkRepository linkRepository){
        this.linkRepository =linkRepository;
    }

    // list
    @GetMapping("/")
    public List<Link> list() {
        return linkRepository.findAll();
    }

    // CRUD
    @PostMapping("/create")
    public Link create() {
        return null;
    }
    @GetMapping("/{id}")
    public Link read(Long id) {
        return null;
    }
    @PutMapping("/update")
    public Link update() {
        return null;
    }

    @DeleteMapping("/delete")
    public void delete() {

    }
}
