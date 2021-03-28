package com.spboot.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spboot.test.entity.FileInfo;
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
	public FoodInfo getFoodInfo(Integer fiNum) {
		Optional<FoodInfo> opFi = fr.findById(fiNum);
		if(opFi.isEmpty()) return null;
		return opFi.get();
	}

	@Override
	public int deleteFoodInfo(Integer fiNum) {
	fr.deleteById(fiNum);
	if(getFoodInfo(fiNum)==null) {
		return 1;
	}
		return 0;
	}

}
