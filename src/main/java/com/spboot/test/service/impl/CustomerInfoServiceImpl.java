package com.spboot.test.service.impl;

import java.util.List;

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

		return customerInfoRepository.findByCuiIdAndCuiPwd(customerInfo.getCuiId(),customerInfo.getCuiPwd());
	}


	@Override
	public CustomerInfo saveCustomerInfo(CustomerInfo Ci) {

		return customerInfoRepository.save(Ci);
	}
	

}
