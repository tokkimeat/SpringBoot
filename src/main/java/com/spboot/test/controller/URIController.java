package com.spboot.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class URIController {

	@GetMapping("/")
	public String hello() {
		
		return "views/index";
	}
	
	@GetMapping("/views/**")
	public void goPage() {
		
	}
}