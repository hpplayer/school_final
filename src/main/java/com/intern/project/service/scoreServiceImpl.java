package com.intern.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intern.project.POJO.Score;
import com.intern.project.daoImpl.ScoreDaoImpl;
import com.intern.project.daoImpl.StudentDaoImpl;
@Service
public class scoreServiceImpl implements scoreService{
	@Autowired
	private ScoreDaoImpl scoreDaoImpl;
	
	public ScoreDaoImpl getScoreDaoImpl() {
		return scoreDaoImpl;
	}

	public void setScoreDaoImpl(ScoreDaoImpl scoreDaoImpl) {
		this.scoreDaoImpl = scoreDaoImpl;
	}

	@Transactional
	public void deleteByStuIdANDCrsID(long stuid, long crsid) throws Exception {
		scoreDaoImpl.deleteByStuIdANDCrsID(stuid, crsid);
	}

	@Transactional
	public List<Score> findByStudentID(long id) throws Exception {
		return scoreDaoImpl.findByStudentID(id);
	}

	@Transactional
	public List<Score> findByCourseID(long id) throws Exception {
		return scoreDaoImpl.findByCourseID(id);
	}

	@Transactional
	public Score findbyStuIDandCrsID(long StuID, long crsID) {
		return scoreDaoImpl.findbyStuIDandCrsID(StuID, crsID);
	}

	@Transactional
	public List<Score> findByStuIDWLimit(long StuIDmax, long StuIDmin,
			long crsMax, long crsMin, int scrMax, int scrMin) throws Exception {
		
		return scoreDaoImpl.findByStuIDWLimit(StuIDmax, StuIDmin, crsMax, crsMin, scrMax, scrMin);
	}

	@Transactional
	public List<Long> findStulistWlimit(long StuIDmax, long StuIDmin,
			long crsMax, long crsMin, int scrMax, int scrMin) {
		return scoreDaoImpl.findStulistWlimit(StuIDmax, StuIDmin, crsMax, crsMin, scrMax, scrMin);
	}

	@Transactional
	public List<Long> ReturnStuList() {
		return scoreDaoImpl.ReturnStuList();
	}

	@Transactional
	public long CountStudent() {
		return scoreDaoImpl.CountStudent();
	}

	@Transactional
	public void add(Score t) throws Exception {
		scoreDaoImpl.add(t);
		
	}

	@Transactional
	public void delete(Score t) throws Exception {
		scoreDaoImpl.delete(t);
		
	}

	@Transactional
	public void deleteById(long id) throws Exception {
		scoreDaoImpl.deleteById(id);
	}

	@Transactional
	public void update(Score t) throws Exception {
		scoreDaoImpl.update(t);
		
	}

	@Transactional
	public Score findByID(long id) throws Exception {
		return scoreDaoImpl.findByID(id);
	}

	@Transactional
	public List<Score> findAll() throws Exception {
		return scoreDaoImpl.findAll();
	}

}
