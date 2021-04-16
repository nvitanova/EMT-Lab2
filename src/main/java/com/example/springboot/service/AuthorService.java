package com.example.springboot.service;

import com.example.springboot.model.Author;
import com.example.springboot.model.Book;
import com.example.springboot.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> save(String name, String surname, Country country);
}
