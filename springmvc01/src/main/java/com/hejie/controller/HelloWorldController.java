package com.hejie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloWorldController {

		
	@RequestMapping (value="/hello")
	public String helloWorld (HttpServletRequest request,
			HttpServletResponse response,Model model) {
		
		//获取前端传递的值
		String name = request.getParameter("name");
		System.out.println("name==============="+name);
		model.addAttribute("name", name);
		return "/hello";
	}
	
	@RequestMapping(value="/hello1")
	public ModelAndView helloWorld1(@RequestParam String name, ModelAndView mav){
		System.out.println("name==============="+name);
		mav.setViewName("hello");
		mav.addObject("name", name);
		return mav;
	}
	
	@RequestMapping(value="/hello2")
	@ResponseBody
	public String helloWorld2(String name){
	
		return name;
	}
}
