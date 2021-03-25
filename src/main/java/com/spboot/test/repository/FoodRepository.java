package com.spboot.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spboot.test.entity.FoodInfo;

public interface FoodRepository extends JpaRepository<FoodInfo, Integer> {
	public List<FoodInfo> findAllByOrderByFiNumAsc();
	public List<FoodInfo> findAllByFiNameAndFiTypeContainsOrderByFiNumAsc(String fiName, String fiType);
	public List<FoodInfo> findAllByFiNameLikeOrderByFiNumAsc(String fiName);
	public List<FoodInfo> findAllByFiTypeOrderByFiNumAsc(String fiType);
}
