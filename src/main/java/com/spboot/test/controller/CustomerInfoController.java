package com.spboot.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public @ResponseBody CustomerInfo login(@RequestBody CustomerInfo customerInfo, HttpServletRequest req) {
		CustomerInfo cui = customerInfoService.login(customerInfo);
		if (cui != null) {
			HttpSession session = req.getSession();
			session.setAttribute("customerInfo", cui);
		}

		log.info("cui=>{}", cui);
		return cui;
	}

	@PostMapping("/join")
	public @ResponseBody CustomerInfo join(@ModelAttribute CustomerInfo cutomerInfo) {
		log.info("ют╥б{}", cutomerInfo);
		return customerInfoService.saveCustomerInfo(cutomerInfo);
	}

	@PostMapping("/logout")
	public @ResponseBody boolean logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return true;
	}

}
