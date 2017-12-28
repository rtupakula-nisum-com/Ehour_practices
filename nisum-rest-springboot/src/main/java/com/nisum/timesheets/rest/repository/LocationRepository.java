package com.nisum.timesheets.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nisum.timesheets.rest.domain.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
	
	Location findByLocationName(String name);

}
