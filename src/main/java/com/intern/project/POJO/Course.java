package com.intern.project.POJO;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "course")
public class Course {
	@Id
	@Column (name = "course_ID")
	private long courseID;
	
	@Column (name = "course_Name")
	private String courseName;
	
	@Column (name = "Remarks")
	private String Remarks;
	
	@Column (name = "course_Passline")
	private int passline;
	





	public long getCourseID() {
		return courseID;
	}

	public void setCourseID(long courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public int getPassline() {
		return passline;
	}

	public void setPassline(int passline) {
		this.passline = passline;
	}

	public String toString(){
		Course cor = new Course();
		return cor.getCourseName() + cor.getCourseID() + cor.getPassline() + cor.getRemarks();
	}
	
	public static Course CreateAccount(long ID, String name, int PL, String Remarks){
		Course cor = new Course();
		cor.setCourseID(ID);
		cor.setCourseName(name);
		cor.setPassline(PL);
		cor.setRemarks(Remarks);	
		return cor;
	}
	
}
