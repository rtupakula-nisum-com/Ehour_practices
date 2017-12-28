package com.nisum.timesheets.rest.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.timesheets.rest.domain.User;
import com.nisum.timesheets.rest.ro.RestUser;
import com.nisum.timesheets.rest.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
	@PreAuthorize("")
	public Object getUser(@PathVariable("username") String username) {
		if (username != null) {
			User user = userService.getUser(username);
			if (user != null) {
				return new RestUser(user);
			} else {
				return "Given user " + username + " does not exist";
			}
		}
		return "expecting a username input";
	}
	
	@GetMapping("/message")
    public Map<String, Object> greeting() {
        return Collections.singletonMap("message", "Hello World");
    }
	
}
