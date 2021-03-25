package com.spboot.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spboot.test.entity.FileInfo;
import com.spboot.test.entity.FoodInfo;
import com.spboot.test.repository.FileRepository;
import com.spboot.test.repository.FoodRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class SpbootApplicationTests {

	@Autowired
	private FoodRepository fr;
	
	@Test
	void contextLoads() {		
		List<FoodInfo> fi = fr.findAllByFiNameLikeOrderByFiNumAsc("%ÈÄ¶ó%");
		log.info("repo=>{}",fi);
	}
}
