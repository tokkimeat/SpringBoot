package com.spboot.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spboot.test.entity.FileInfo;


public interface FileRepository extends JpaRepository<FileInfo, Long > {

	public List<FileInfo> findAllByOrderByFiiNumAsc();
	public List<FileInfo> findAllByFiiTitleOrderByFiiNumAsc(String fiiTitle);
	public List<FileInfo> findAllByFiiContentLikeOrderByFiiNumAsc(String string);
	public List<FileInfo> findAllByFiiTitleAndFiiContentContainsOrderByFiiNumAsc(String fiiTitle, String fiiContent);
}
