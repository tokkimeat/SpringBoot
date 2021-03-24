package com.spboot.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spboot.test.entity.CustomerInfo;
import com.spboot.test.repository.CustomerInfoRepository;
import com.spboot.test.service.CustomerInfoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerInfoServiceImpl implements CustomerInfoService {

	@Autowired
	private CustomerInfoRepository customerInfoRepository;
	
	
	@Override
	public CustomerInfo login(CustomerInfo customerInfo) {
CustomerInfo tmpCui = customerInfoRepository.findByCuiIdAndCuiPwd(customerInfo.getCuiId(),customerInfo.getCuiPwd());
log.info("tmpCui=>{}",tmpCui);
		return null;
	}

}
