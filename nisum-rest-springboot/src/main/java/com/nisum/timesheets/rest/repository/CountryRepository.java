package com.nisum.timesheets.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nisum.timesheets.rest.domain.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

	Country findByCountryName(String name);

}