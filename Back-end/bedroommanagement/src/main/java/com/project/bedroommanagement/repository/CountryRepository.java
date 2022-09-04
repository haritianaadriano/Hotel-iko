package com.project.bedroommanagement.repository;

import com.project.bedroommanagement.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findByCountryName(String countryName);
}
