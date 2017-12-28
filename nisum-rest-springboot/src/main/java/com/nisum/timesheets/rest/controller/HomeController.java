package com.nisum.timesheets.rest.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.timesheets.rest.domain.User;
import com.nisum.timesheets.rest.ro.RestUser;
import com.nisum.timesheets.rest.service.UserService;

@RestController
@RequestMapping("/api")
public class HomeController {
	
	@Autowired
	private UserService userService;

    @GetMapping("/message")
    public Map<String, Object> greeting() {
        return Collections.singletonMap("message", "Hello World");
    }
    
}