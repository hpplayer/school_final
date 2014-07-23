package com.intern.project.controller;

import javax.annotation.Resource;

import com.intern.project.service.*;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/score")
public class ScoreController {
	
	@Resource(name="scoreServiceImpl")
	private scoreServiceImpl service;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public ModelAndView hello2(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "HelloMVC");
		mv.setViewName("score");
		return mv;
	}

	
	@RequestMapping(value="/count",method=RequestMethod.GET)
	public ModelAndView count() throws Exception{
		
		int c = service.findAll().size();
		long b = service.findByID(8).getCourse_ID();
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", b);
		mv.addObject("message2", c);
		mv.setViewName("score");
		return mv;
	}
}


