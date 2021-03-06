package com.nisum.timesheets.rest.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.nisum.timesheets.rest.domain.User;
import com.nisum.timesheets.rest.repository.UserRepository;

@RunWith(SpringRunner.class)
public class UserServiceTest {
	
	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public UserService userService() {
            return new UserService();
        }
    }
	
	@Autowired
    private UserService userService;
	
	@MockBean
    private UserRepository userRepository;
	
	@Before
	public void setUp() {
	    User rtupakula = new User();
	    rtupakula.setFirstName("rajni Kanth");
	    rtupakula.setLastName("tupakula");
	    rtupakula.setUsername("rtupakula");
	    rtupakula.setActive(true);
	    
	    Mockito.when(userService.getUser(any(String.class)))
        .thenReturn(rtupakula);
	}
	
	
	@Test
	public void whenValidName_thenEmployeeShouldBeFound() {
	    String name = "rtupakula";
	    User found = userService.getUser(name);
	     assertThat(found.getUsername())
	      .isEqualTo(name);
	 }

}
