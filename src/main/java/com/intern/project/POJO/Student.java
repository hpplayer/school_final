package com.intern.project.POJO;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "student")
public class Student {
	
	@Id
	@Column (name = "ID")
	private long ID;
	
	@Column (name = "Name")
	private String name; 
	
	@Column (name = "Sex")
	private String sex;
	
	@Column (name = "Bir")
	private Date Bir;
	
	@Column (name = "Class")
	private String major;
	
	@Column (name = "Adr")
	private String Adr;
	
	@Column (name = "Remarks")
	private String Remarks;
	

	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBir() {
		return Bir;
	}
	public void setBir(Date string) {
		Bir = string;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getAdr() {
		return Adr;
	}
	public void setAdr(String adr) {
		Adr = adr;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remark) {
		Remarks = remark;
	}
	
}
