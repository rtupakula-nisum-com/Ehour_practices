package com.nisum.timesheets.rest.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.nisum.timesheets.rest.domain.Country;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CountryRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Test
	public void whenFindById_thenReturnCountry() {
		
		Country country = new Country();
		country.setCountryName("United States");
		
		entityManager.persist(country);
		entityManager.flush();
		// when
		Country found = countryRepository.findByCountryName("United States");
		
		// then
		assertThat(found.getCountryName()).isEqualTo(country.getCountryName());
	}
	


}
