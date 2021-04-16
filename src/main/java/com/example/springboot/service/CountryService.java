package com.example.springboot.service;


import com.example.springboot.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();


    Optional<Country> save(String name, String continent);

}
