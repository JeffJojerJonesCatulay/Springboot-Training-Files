package com.sb.springmvc.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {
	
	@ResponseBody
	@RequestMapping("/")
	public String display() {
		return "index";
	}
}
