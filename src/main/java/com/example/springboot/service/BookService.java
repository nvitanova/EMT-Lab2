package com.example.springboot.service;

import com.example.springboot.model.Book;
import com.example.springboot.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> findByName(String name);

    Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> edit(Long id, String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> markTaken(Long id);

    void deleteById(Long id);

}
