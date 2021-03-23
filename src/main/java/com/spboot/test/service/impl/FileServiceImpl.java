package com.spboot.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spboot.test.entity.FileInfo;
import com.spboot.test.service.FileService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class FileServiceImpl implements FileService {

	@Override
	public void saveFileInfo(FileInfo fi) {
		MultipartFile mf = fi.getFiiFile();
		log.info("fileName=>{}",mf.getOriginalFilename());
		int idx = mf.getOriginalFilename().lastIndexOf(".");
		String extName = mf.getOriginalFilename().substring(idx);
		String filePath = System.nanoTime()+extName;
		log.info("filePath=>{}",filePath);
		fi.setFiiFileName(mf.getOriginalFilename());
		fi.setFiiFilePath(filePath);

	}

}
