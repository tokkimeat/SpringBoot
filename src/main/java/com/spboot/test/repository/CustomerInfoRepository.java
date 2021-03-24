package com.spboot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spboot.test.entity.CustomerInfo;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Integer> {
	
	public CustomerInfo findByCuiIdAndCuiPwd(String cuiId, String cuiPwd);

}
