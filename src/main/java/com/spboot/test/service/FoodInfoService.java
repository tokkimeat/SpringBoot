package com.spboot.test.service;

import java.util.List;

import com.spboot.test.entity.FileInfo;
import com.spboot.test.entity.FoodInfo;

public interface FoodInfoService {

	FoodInfo saveFoodInfo(FoodInfo fi);
	public List<FoodInfo> getFoodInfos(FoodInfo foodInfo);
	int deleteFoodInfo(Integer fiNum);
	FoodInfo getFoodInfo(Integer fiNum);
	
}
