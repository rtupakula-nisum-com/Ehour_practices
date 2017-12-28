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
import com.nisum.timesheets.rest.domain.EmployeeType;
import com.nisum.timesheets.rest.domain.EmployeeTypeType;
import com.nisum.timesheets.rest.domain.Location;
import com.nisum.timesheets.rest.domain.Region;
import com.nisum.timesheets.rest.domain.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository userRepository;

	@Test
	@Ignore
	public void whenFindByName_thenReturnUser() {
		// given
		User rtupakula = new User();
		rtupakula.setFirstName("rajni Kanth");
		rtupakula.setLastName("tupakula");
		rtupakula.setPassword("rtupakula");
		rtupakula.setUsername("rtupakula");
		EmployeeType empType = new EmployeeType();
		empType.setEmployeeTypeId(1);
		empType.setEmployeeTypeName("Nisum");
		empType.setEmployeeTypeType(EmployeeTypeType.FULLTIMEEMPLOYEE);
		rtupakula.setEmployeeType(empType);
		Location location = new Location();
		location.setLocationId(1);
		location.setLocationName("Fremont");
		Region region = new Region();
		region.setRegionId(1);
		region.setName("West");
		Country country = new Country();
		country.setCountryId(1);
		country.setCountryName("United States");
		region.setCountry(country);
		rtupakula.setCountry(country);
		location.setRegion(region);
		rtupakula.setLocation(location);
		rtupakula.setActive(true);
		rtupakula.setApprover(null);
		
		
		
		entityManager.persist(rtupakula);
		entityManager.flush();

		// when
		User found = userRepository.findByUsername(rtupakula.getUsername());

		// then
		assertThat(found.getUsername()).isEqualTo(rtupakula.getUsername());
	}
}
