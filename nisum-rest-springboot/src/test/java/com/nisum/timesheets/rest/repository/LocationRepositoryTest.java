package com.nisum.timesheets.rest.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.nisum.timesheets.rest.domain.Country;
import com.nisum.timesheets.rest.domain.Location;
import com.nisum.timesheets.rest.domain.Region;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LocationRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Test
	@Ignore
	public void whenFindById_thenReturnLocation() {
		
		Location location = new Location();
		location.setLocationId(1);
		location.setLocationName("Fremont");
		
		Region region = new Region();
		region.setName("West");
		Country country = new Country();
		country.setCountryId(1);
		country.setCountryName("United States");
		region.setCountry(country);
		location.setRegion(region);
		
		entityManager.persist(region);
		entityManager.flush();
		// when
		Location found = locationRepository.findByLocationName("Fremont");
		
		// then
		assertThat(found.getLocationName()).isEqualTo(location.getLocationName());
	}
	


}
