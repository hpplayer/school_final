package com.intern.project.daoImpl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intern.project.POJO.Course;
import com.intern.project.POJO.Score;
import com.intern.project.POJO.Student;
import com.intern.project.dao.*;

public class ScoreDaoImpl implements ScoreDao{
	private SessionFactory sessionFactory;
	

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(Score t) throws Exception {

		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Score.class);
		cr.add(Restrictions.eq("student_ID", t.getStudent_ID()));
		cr.add(Restrictions.eq("course_ID", t.getCourse_ID()));
		List<Score> results = cr.list();
		if (results.size()>0){
			System.out.println("Same data found, insertion denied");
		}else{
			sessionFactory.getCurrentSession().save(t);
		}


		
	}

	public void delete(Score t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);
		
	}

	public void deleteByStudentId(long id) throws Exception {
		List<Score> tempo = findByStudentID(id);
		for ( int i = 0; i < tempo.size(); i++){
			sessionFactory.getCurrentSession().delete(tempo.get(i));
		}
		
	}
	

	public void deleteByStuIdANDCrsID(long stuid, long crsid) throws Exception {
		Score tempo = findbyStuIDandCrsID(stuid,crsid);
		delete(tempo);
		
	}

	public void update(Score t) throws Exception {
		long stuID = t.getStudent_ID();
		long crsID = t.getCourse_ID();
		Score tempo = findbyStuIDandCrsID(stuID,crsID);
		tempo.setScore(t.getScore());
		sessionFactory.getCurrentSession().update(tempo);
		
	}


	public List<Score> findByStudentID(long id) throws Exception {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Score.class);
		cr.add(Restrictions.eq("student_ID", id));
		List<Score> results = cr.list();
		return results;
	}
	

	public List<Score> findByCourseID(long id) throws Exception {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Score.class);
		cr.add(Restrictions.eq("course_ID", id));
		List<Score> results = cr.list();
		return results;
	}

	public Score findbyStuIDandCrsID(long StuID, long crsID){
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Score.class);
		cr.add(Restrictions.eq("course_ID", crsID));
		cr.add(Restrictions.eq("student_ID", StuID));
		Score result = (Score) cr.list().get(0);
		return result;
	}
	
	public List<Score> findByStuIDWLimit(long StuIDmax, long StuIDmin, long crsMax, long crsMin, int scrMax, int scrMin) throws Exception {
		Criteria cr =sessionFactory.getCurrentSession().createCriteria(Score.class);
		cr.add(Restrictions.ge("student_ID", StuIDmin));
		cr.add(Restrictions.le("student_ID", StuIDmax));
		
		cr.add(Restrictions.le("course_ID", crsMax));
		cr.add(Restrictions.ge("course_ID", crsMin));
		
		cr.add(Restrictions.le("score", scrMax));
		cr.add(Restrictions.ge("score", scrMin));
		
		List<Score> results = cr.list();
		return results;
	}
	
	public List<Long> findStulistWlimit (long StuIDmax, long StuIDmin, long crsMax, long crsMin, int scrMax, int scrMin){

		String hql = "SELECT distinct student_ID FROM Score where student_ID <= :StuIDmax AND student_ID >= :StuIDmin"
		+" AND course_ID >= :crsMin AND course_ID <= :crsMax AND score >= :scrMin AND score <= :scrMax";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
		query.setParameter("StuIDmax",StuIDmax);
		query.setParameter("StuIDmin",StuIDmin);
		query.setParameter("crsMax",crsMax);
		query.setParameter("crsMin",crsMin);
		query.setParameter("scrMax",scrMax);
		query.setParameter("scrMin",scrMin);

		List results = query.list();
		
		return results;	
	}
	
	
	public List<Score> findAll() throws Exception {
	    Criteria cr = sessionFactory.getCurrentSession().createCriteria(Score.class);
        List<Score> score =cr.list();
	    return score;
	}

	public List<Long> ReturnStuList(){
		String hql = "SELECT distinct student_ID FROM Score";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List stuID = query.list();
	    return stuID;
	}
	

	public long CountStudent() {
		String hql = "SELECT count(distinct student_ID) FROM Score";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		long result = (Long) query.uniqueResult();
		return result;
		
	}
	
	public Score findByID(long id) throws Exception {
		Score scr = (Score)sessionFactory.getCurrentSession().get(Score.class, id);
		return scr;
		
	}

	
	public void deleteById(long id) throws Exception {
		sessionFactory.getCurrentSession().delete(this.findByID(id));
	}
	

}
