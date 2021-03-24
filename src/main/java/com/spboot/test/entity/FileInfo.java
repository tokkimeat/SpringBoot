package com.spboot.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Entity
@Table(name = "file_info")
public class FileInfo {
	
	@SequenceGenerator(name = "seqFiNum",sequenceName = "seq_fi_num", allocationSize = 1)
	@GeneratedValue(generator = "seqFiNum",strategy = GenerationType.SEQUENCE)
	@Id
	@Column(name="fii_num")
	private Long fiiNum;
	@Column(name="fii_title")
	private String fiiTitle;
	@Column(name="fii_content")
	private String fiiContent;
	@Column(name="fii_file_path")
	private String fiiFilePath;
	@Column(name="fii_file_name")
	private String fiiFileName;
	
	@Transient
	private MultipartFile fiiFile;
}
