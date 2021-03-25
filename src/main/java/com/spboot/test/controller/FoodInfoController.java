package com.spboot.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spboot.test.entity.FoodInfo;
import com.spboot.test.service.FoodInfoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FoodInfoController {
	
	@Autowired
	private FoodInfoService foodInfoService;
	
	@GetMapping("/food-infos")
	public @ResponseBody List<FoodInfo> getFoodInfos(@ModelAttribute FoodInfo foodInfo) {
		log.info("fiName,fiType=>{}",foodInfoService.getFoodInfos(foodInfo));
		return foodInfoService.getFoodInfos(foodInfo);
	}
	@PostMapping("/food-insert")
	public @ResponseBody FoodInfo saveFoodInfo(@ModelAttribute FoodInfo foodInfo) {
		log.info("foodInfo=>{}",foodInfo);
		return null;
	}

}
