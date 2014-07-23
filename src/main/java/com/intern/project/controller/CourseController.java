package com.intern.project.controller;

import javax.annotation.Resource;

import com.intern.project.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Resource(name="courseServiceImpl")
	private courseServiceImpl service;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public ModelAndView hello2(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "HelloMVC");
		mv.setViewName("course");
		return mv;
	}

	
	@RequestMapping(value="/count",method=RequestMethod.GET)
	public ModelAndView count() throws Exception{
		
		int c = service.findAll().size();
		String b = service.findByID(1101).getCourseName();
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", b);
		mv.addObject("message2", c);
		mv.setViewName("course");
		return mv;
	}
}


