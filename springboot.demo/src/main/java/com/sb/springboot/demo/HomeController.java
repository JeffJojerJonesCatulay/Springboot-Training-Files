package com.sb.springboot.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String home() {
		return "Hello World";
	}
}
