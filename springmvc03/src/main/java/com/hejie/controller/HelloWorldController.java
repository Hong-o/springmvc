package com.hejie.controller;

import java.util.Arrays;
import java.util.List;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hejie.entity.User;

@Controller
@RequestMapping(value="/user")
@SessionAttributes(value="sessionUser")
public class HelloWorldController {

	// @RequestParam绑定单个请求参数值；
	// @PathVariable绑定URI 模板变量值；
	@RequestMapping(value="/hello1")
	public String hello1(@RequestParam String id, String name,Model model) {
		model.addAttribute("name",name);
		return "message";
		
	}
	//	@CookieValue绑定Cookie 数据值
	@RequestMapping(value="/hello2")
	public String hello2(@CookieValue(value="JSESSIONID") String cookie, String name,Model model) {
		model.addAttribute("name",name);
		return "message";
		
	}
	
	//	@RequestHeader绑定请求头数据
	@RequestMapping(value="/hello3")
	public String hello3(@RequestHeader(
			value="User-Agent") String header,
			@RequestHeader(value="Accept") String accept, 
			@RequestHeader(value="Cookie") String cookie,String name,Model model) {
		System.out.println(header+"=="+accept+"=="+cookie);
		model.addAttribute("name",name);
		return "message";
		
	}
//	@SessionAttributes绑定命令对象到session
	@RequestMapping(value="/hello4")
	public String hello4( String name,Model model) {	
		User user = new User();
		user.setId("1");
		user.setAge("20");
		user.setUsername("李寻欢");
		model.addAttribute("sessionUser",user);
		return "message";
		
	}
	
	@RequestMapping(value="/getSession")
	public String getSession(HttpSession httpSession){
		Object session = httpSession.getAttribute("sessionUser");
		if(session != null){
			System.out.println((User)session);
		}
		return "message";
	}
	
//	@ModelAttribute 1.作用于方法上 
	@ModelAttribute(value = "cityList")//1.
	public List<String> modeAttrMethod () {
		//这个方法会在请求当前Controller里面的所有其他方法之前执行
		System.out.println("执行了modeAttrMethod...");
		//数据保存在cityList中，前台页面可直接取值
		return Arrays.asList("长沙", "重庆");
	}
	
//	@ModelAttribute 2.作用于方法参数上  3.作用于返回值
	@RequestMapping(value="/modeAttrParment")
	public String modeAttrParment (@ModelAttribute(value = "cityList") List<String> cityList) {
		//这个方法会在请求当前Controller里面的所有其他方法之前执行
		System.out.println("执行了modeAttrMethod2222222...");
		//数据保存在cityList中，前台页面可直接取值
		return "message";
	}
}
