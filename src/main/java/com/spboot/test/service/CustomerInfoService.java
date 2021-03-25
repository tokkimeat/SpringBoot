package com.spboot.test.service;

import java.util.List;

import com.spboot.test.entity.CustomerInfo;

public interface CustomerInfoService {
	public CustomerInfo login(CustomerInfo customerInfo);

	CustomerInfo saveCustomerInfo (CustomerInfo Ci);
}
