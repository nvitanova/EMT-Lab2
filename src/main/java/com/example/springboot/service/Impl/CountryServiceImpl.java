package com.example.springboot.service.Impl;

import com.example.springboot.model.Author;
import com.example.springboot.model.Country;
import com.example.springboot.repository.CountryRepository;
import com.example.springboot.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        this.countryRepository.deleteByName(name);
        Country country = new Country(name, continent);
        this.countryRepository.save(country);
        return Optional.of(country);
    }
}
