package com.spboot.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@GetMapping("/hello")
	public @ResponseBody String hello() {
		
		return "hello22";
	}
	
	@GetMapping("/views/**")
	public void goPage() {
		
	}
}