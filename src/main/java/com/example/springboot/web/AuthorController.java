package com.example.springboot.web;


import com.example.springboot.model.Author;
import com.example.springboot.model.Country;
import com.example.springboot.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/author")

public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping
    public List<Author> findAll(){
        return this.authorService.findAll();
    }


    @PostMapping("/add")
    public ResponseEntity<Author> save(@RequestBody Author author) {
        return this.authorService.save(author.getName(), author.getSurname(), author.getCountry())
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
