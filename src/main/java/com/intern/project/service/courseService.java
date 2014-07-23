package com.intern.project.service;

import java.util.List;

import com.intern.project.POJO.Course;
import com.intern.project.dao.CourseDao;

public interface courseService extends CourseDao{
	List<Course> findByAnyInfo(String ID, String Name, String passline, String remarks);
}
