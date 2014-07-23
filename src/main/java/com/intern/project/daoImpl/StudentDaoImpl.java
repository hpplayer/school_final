package com.intern.project.daoImpl;



import java.util.Iterator;
import java.util.List;

import org.aspectj.bridge.Message;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.intern.project.POJO.Score;
import com.intern.project.POJO.Student;
import com.intern.project.dao.StudentDao;

public class StudentDaoImpl implements StudentDao{
	
	private SessionFactory sessionFactory;
	
	
	public void add(Student t) throws Exception {
		sessionFactory.getCurrentSession().save(t);
	}

	public void delete(Student t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);
		
	}

	public void deleteById(long id) throws Exception {
		sessionFactory.getCurrentSession().delete(this.findByID(id));
	}


	
	public void update(Student t) throws Exception {
		long ID = t.getID();
		Student tempo = findByID(ID);
		tempo.setName(t.getName());
		tempo.setBir(t.getBir());
		tempo.setAdr(t.getAdr());
		tempo.setMajor(t.getMajor());
		tempo.setRemarks(t.getRemarks());
		tempo.setSex(t.getSex());
		sessionFactory.getCurrentSession().update(tempo);
	    
	}

	public Student findByID(long iD) throws Exception {
		Student stu = (Student)sessionFactory.getCurrentSession().get(Student.class, iD);
		return stu;
	}

	public List<Student> findAll() throws Exception {

		
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Student.class);
        cr.addOrder(Order.asc("ID"));
        List<Student> students =cr.list();

        return students;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



}
