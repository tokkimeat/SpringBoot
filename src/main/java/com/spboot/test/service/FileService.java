package com.spboot.test.service;

import java.util.List;

import com.spboot.test.entity.FileInfo;

public interface FileService {

	FileInfo saveFileInfo(FileInfo fi);
	public List<FileInfo> getFileInfos(FileInfo fileInfo);
	FileInfo getFileInfo(Long fiiNum);
	int deleteFileInfo(Long fiiNum);
	FileInfo updateFileInfo(FileInfo fi);
}

