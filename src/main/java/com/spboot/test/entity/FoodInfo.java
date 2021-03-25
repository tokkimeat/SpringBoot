package com.spboot.test.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class FoodInfo {
	@SequenceGenerator(name = "seqFiNum",sequenceName = "seq_fi_num",allocationSize = 1)
	@GeneratedValue(generator = "seqFiNum",strategy = GenerationType.SEQUENCE)
	@Id
	@Column(name = "fi_num")
	private Integer fiNum;
	@Column(name = "fi_name")
	private String fiName;
	@Column(name = "fi_price")
	private Integer fiPrice;
	@Column(name = "fi_type")
	private String fiType;
	@Column(name = "fi_desc")
	private String fiDesc;
	@Column(name = "credat")
	private Date credat;
	@Column(name = "active")
	private String active;
	
	

}
