package com.intern.project.POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "score")
public class Score {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long ID;
	
	@Column (name = "Student_ID")
	private long student_ID;
	
	@Column (name = "course_ID")
	private long course_ID;
	
	@Column (name = "course_Score")
	private int score;

	
	
	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public long getStudent_ID() {
		return student_ID;
	}
	public void setStudent_ID(long student_ID) {
		this.student_ID = student_ID;
	}
	public long getCourse_ID() {
		return course_ID;
	}
	public void setCourse_ID(long course_ID) {
		this.course_ID = course_ID;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
