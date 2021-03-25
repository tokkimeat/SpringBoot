package com.spboot.test.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spboot.test.entity.FileInfo;
import com.spboot.test.repository.FileRepository;
import com.spboot.test.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

	private final String ROOT = "C:\\Users\\Si7A-40\\git\\SpringBoot\\src\\main\\webapp\\resources\\";
	@Autowired
	private FileRepository fileRepo;

	@Override
	public FileInfo saveFileInfo(FileInfo fi) {
		MultipartFile mf = fi.getFiiFile();
		log.info("fileName=>{}", mf.getOriginalFilename());
		int idx = mf.getOriginalFilename().lastIndexOf(".");
		String extName = mf.getOriginalFilename().substring(idx);
		String filePath = System.nanoTime() + extName;
		log.info("filePath=>{}", filePath);
		fi.setFiiFileName(mf.getOriginalFilename());
		fi.setFiiFilePath(filePath);
		File f = new File(ROOT + filePath);
		try {
			mf.transferTo(f);
		} catch (IllegalStateException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return fileRepo.save(fi);

	}

	public List<FileInfo> getFileInfos(FileInfo fileInfo){
		if(fileInfo.getFiiTitle()!=null && fileInfo.getFiiContent()!=null) {
		return fileRepo.findAllByFiiTitleAndFiiContentContainsOrderByFiiNumAsc(fileInfo.getFiiTitle(),fileInfo.getFiiContent());
		}
		if(fileInfo.getFiiTitle()!=null) {
			return fileRepo.findAllByFiiTitleOrderByFiiNumAsc(fileInfo.getFiiTitle()); 
		}
		if(fileInfo.getFiiContent()!=null) {
			return fileRepo.findAllByFiiContentLikeOrderByFiiNumAsc("%"+fileInfo.getFiiContent()+"%");
			
		}
		
		return fileRepo.findAllByOrderByFiiNumAsc();
	}

	public FileInfo getFileInfo(Long fiiNum) {
		Optional<FileInfo> opFi = fileRepo.findById(fiiNum);
		if(opFi.isEmpty()) return null;
		return opFi.get();
	}

	@Override
	public int deleteFileInfo(Long fiiNum) {
		fileRepo.deleteById(fiiNum);
		if(getFileInfo(fiiNum)==null) {
			return 1;
		}
		return 0;
	}

	@Override
	public FileInfo updateFileInfo(FileInfo fi) {
		MultipartFile mf = fi.getFiiFile();
		log.info("fileName=>{}", mf.getOriginalFilename());
		int idx = mf.getOriginalFilename().lastIndexOf(".");
		String extName = mf.getOriginalFilename().substring(idx);
		String filePath = System.nanoTime() + extName;
		log.info("filePath=>{}", filePath);
		fi.setFiiFileName(mf.getOriginalFilename());
		fi.setFiiFilePath(filePath);
		File f = new File(ROOT + filePath);
		try {
			mf.transferTo(f);
		} catch (IllegalStateException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return fileRepo.save(fi);

	}

}
