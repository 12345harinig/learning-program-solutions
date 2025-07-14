package com.cognizant.ormlearn.repository;
import org.springframework.data.jpa.repository.Query;
import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Query Methods for Hands-on 1

    // 1. Get all countries whose name contains a substring (case-insensitive)
    List<Country> findByNameContainingIgnoreCase(String substring);

    // 2. Get all countries whose name starts with a particular letter
    List<Country> findByNameStartingWith(String prefix);
    @Query("SELECT c FROM Country c ORDER BY c.name ASC")
    List<Country> getAllCountriesSortedByName();

    // 3. Get a country by exact name
    Country findByName(String name);
}
