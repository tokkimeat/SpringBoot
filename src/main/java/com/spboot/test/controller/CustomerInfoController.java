package com.spboot.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spboot.test.entity.CustomerInfo;
import com.spboot.test.service.CustomerInfoService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class CustomerInfoController {
	
	@Autowired
	private CustomerInfoService customerInfoService;
	
	
	@PostMapping("/login")
	public @ResponseBody CustomerInfo login(@ModelAttribute CustomerInfo customerInfo) {
		log.info("cuiId,cuiPwd=>{}",customerInfo);
		return customerInfoService.login(customerInfo);
	}

}
