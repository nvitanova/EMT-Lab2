package com.example.springboot.repository;

import com.example.springboot.model.Author;
import com.example.springboot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    void deleteByName(String name);
}
