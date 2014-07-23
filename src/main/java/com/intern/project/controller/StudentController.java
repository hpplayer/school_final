package com.intern.project.controller;

import javax.annotation.Resource;

import com.intern.project.service.*;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Resource(name="studentServiceImpl")
	private studentServiceImpl service;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public ModelAndView hello2(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "HelloMVC");
		mv.setViewName("student");
		return mv;
	}

	
	@RequestMapping(value="/count",method=RequestMethod.GET)
	public ModelAndView count() throws Exception{
		
		int c = service.findAll().size();
		String b = service.findByID(222).getName();
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", b);
		mv.addObject("message2", c);
		mv.setViewName("student");
		return mv;
	}
}


