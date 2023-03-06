package com.javatpoint.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/testing")
	public String hello() {
		return "Hello world";
	}
}
