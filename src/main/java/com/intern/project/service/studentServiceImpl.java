package com.intern.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intern.project.POJO.Student;
import com.intern.project.daoImpl.StudentDaoImpl;

@Service
public class studentServiceImpl implements studentService{
	@Autowired
	private StudentDaoImpl studentDAOImpl;


	public StudentDaoImpl getStudentDAOImpl() {
		return studentDAOImpl;
	}

	public void setStudentDAOImpl(StudentDaoImpl studentDAOImpl) {
		this.studentDAOImpl = studentDAOImpl;
	}

	@Transactional
	public void add(Student t) throws Exception {
		studentDAOImpl.add(t);
	}

	@Transactional
	public void delete(Student t) throws Exception {
		studentDAOImpl.delete(t);
	}

	@Transactional
	public void deleteById(long id) throws Exception {
		studentDAOImpl.deleteById(id);
		
	}

	@Transactional
	public void update(Student t) throws Exception {
		studentDAOImpl.update(t);
		
	}

	@Transactional
	public Student findByID(long id) throws Exception {
		return studentDAOImpl.findByID(id);
	}

	@Transactional
	public List<Student> findAll() throws Exception {
		return studentDAOImpl.findAll();
	}


}
