package com.intern.project.daoImpl;

import java.util.List;


import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intern.project.POJO.Course;
import com.intern.project.dao.CourseDao;

//@Repository
public class CourseDaoImpl implements CourseDao{
	//private Session session;
	//@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void add(Course t)  {
		sessionFactory.getCurrentSession().save(t);
	}


	public void delete(Course t) {
		sessionFactory.getCurrentSession().delete(t);
	}

	public void deleteById(long id) throws Exception {
		sessionFactory.getCurrentSession().delete(this.findByID(id));
		
	}

	public void update(Course t) throws Exception {
		
		String crsName = t.getCourseName();
		int PL = t.getPassline();
		String remarks = t.getRemarks();
		long crsID = t.getCourseID();
		Course tempo = findByID(crsID);
		tempo.setCourseName(crsName);
		tempo.setPassline(PL);
		tempo.setRemarks(remarks);
		sessionFactory.getCurrentSession().update(tempo);
		
	}


	public List<Course> findByAnyInfo (String ID, String Name, String passline, String remarks ){

		
		
		String sql = "select course_ID, course_Name, course_Passline, Remarks from course where course_ID like :course_ID AND course_Name like :course_Name AND course_Passline like :course_Passline AND Remarks like :course_RMKS"  ;
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(Course.class);
		query.setParameter("course_ID", ID);
		query.setParameter("course_Name", Name);
		query.setParameter("course_Passline", passline);
		query.setParameter("course_RMKS", remarks);

		
		List<Course> results = query.list();
		
	    return results;
	
		
	
	}
	
	
	public Course findByID(long id)  {
		Course crs = (Course)sessionFactory.getCurrentSession().load(Course.class, id);
		return crs;
	}

	public List<Course> findAll(){

	        List<Course> Courses = (List<Course>)sessionFactory.getCurrentSession().createQuery("from course").list();
	        return Courses;

	}

}
