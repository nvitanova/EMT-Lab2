package com.example.springboot.repository;

import com.example.springboot.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
    void deleteByName(String name);
}
