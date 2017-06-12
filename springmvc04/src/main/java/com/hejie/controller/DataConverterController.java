package com.hejie.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hejie.entity.User;


@Controller
@RequestMapping(value="/converter")
public class DataConverterController {
	
	/**
	 * 内置类型转换器测试
	 * String -> Boolean
	 * @param age
	 * @return
	 */
	@RequestMapping(value="/testConverter")
	public String testConverter(Boolean age){
		System.out.println("------"+age+"---------");
		return null;
	}
	
	@RequestMapping(value="/stringToDateConverter")
	public String stringToDateConverter(User user,BindingResult result,Model model){
		if(result.hasErrors()){
			System.out.println(result.getAllErrors());
			return "error";
		}
		System.out.println("------"+user.getBirthday()+"---------");
		model.addAttribute("msg", user);
		return "message";
	}

}
