package com.spboot.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spboot.test.entity.FoodInfo;
import com.spboot.test.repository.FoodRepository;
import com.spboot.test.service.FoodInfoService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class FoodInfoServiceImpl implements FoodInfoService {

	@Autowired
	private FoodRepository fr ;
	
	@Override
	public FoodInfo saveFoodInfo(FoodInfo fi) {
	
		return fr.save(fi);
	}

	@Override
	public List<FoodInfo> getFoodInfos(FoodInfo foodInfo) {
		if(foodInfo.getFiName()!=null&&foodInfo.getFiType()!=null) {
			return fr.findAllByFiNameAndFiTypeContainsOrderByFiNumAsc(foodInfo.getFiName(),foodInfo.getFiType());
		}
		if(foodInfo.getFiName()!=null) {
			return fr.findAllByFiNameLikeOrderByFiNumAsc(foodInfo.getFiName());
		}
		if(foodInfo.getFiType()!=null) {
			return fr.findAllByFiTypeOrderByFiNumAsc(foodInfo.getFiType());
		}
		return fr.findAllByOrderByFiNumAsc();
	}

}
