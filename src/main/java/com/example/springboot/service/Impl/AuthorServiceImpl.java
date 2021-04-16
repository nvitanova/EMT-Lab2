package com.example.springboot.service.Impl;

import com.example.springboot.model.Author;
import com.example.springboot.model.Book;
import com.example.springboot.model.Country;
import com.example.springboot.model.exceptions.AuthorNotFoundException;
import com.example.springboot.model.exceptions.CountryNotFoundException;
import com.example.springboot.repository.AuthorRepository;
import com.example.springboot.repository.CountryRepository;
import com.example.springboot.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> save(String name, String surname, Country country) {
        Country c = this.countryRepository.findById(country.getId())
                .orElseThrow(() -> new CountryNotFoundException(country.getId()));

        this.authorRepository.deleteByName(name);
        Author author = new Author(name, surname, c);
        this.authorRepository.save(author);
        return Optional.of(author);
    }

}
