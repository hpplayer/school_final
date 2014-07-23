package com.intern.project.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intern.project.POJO.Course;
import com.intern.project.dao.*;
import com.intern.project.daoImpl.CourseDaoImpl;

@Service

public class courseServiceImpl implements courseService{
	@Autowired
	private CourseDaoImpl courseDAOImpl;

	public CourseDaoImpl getCourseDAOImpl() {
		return courseDAOImpl;
	}

	public void setCourseDAOImpl(CourseDaoImpl courseDAOImpl) {
		this.courseDAOImpl = courseDAOImpl;
	}

	@Transactional
	public void add(Course t) throws Exception {
		courseDAOImpl.add(t);
	}

	@Transactional
	public void delete(Course t) throws Exception {
		courseDAOImpl.delete(t);
	}

	@Transactional
	public void deleteById(long id) throws Exception {
		courseDAOImpl.deleteById(id);
		
	}

	@Transactional
	public void update(Course t) throws Exception {
		courseDAOImpl.update(t);
		
	}

	@Transactional
	public Course findByID(long id) throws Exception {
		return courseDAOImpl.findByID(id);
	}

	@Transactional
	public List<Course> findAll() throws Exception {
		return courseDAOImpl.findAll();
	}

	@Transactional
	public List<Course> findByAnyInfo(String ID, String Name, String passline,
			String remarks) {
		return courseDAOImpl.findByAnyInfo(ID, Name, passline, remarks);
	}

}
