package com.hejie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/user")
public class HelloWorldController {

	@RequestMapping(value="/hello1")
	public String hello1(String name,Model model) {
		model.addAttribute("name",name);
		return "message";
		
	}
	
	@RequestMapping(value="/hello2")
	public ModelAndView hello2(ModelAndView mav,@RequestParam(value="name") String name) {
		mav.addObject("name", name);
		mav.setViewName("message");
		return mav;
	}
	
	@RequestMapping(value={"/hello3","/hello4"})
	public String hello3(String name,Model model) {
		model.addAttribute("name",name);
		return "message";
		
	}
//	模板映射
	@RequestMapping(value="/hello5/{id}")
	public String hello5(String name,Model model,@PathVariable(value="id") String id) {
		model.addAttribute("name",name);
		return "message";
		
	}
//	Ant风格映射
	@RequestMapping(value="/hello6/**")
	public String hello6(String name,Model model,@PathVariable(value="id") String id) {
		model.addAttribute("name",name);
		return "message";
		
	}
	
	/**
	 * 
	 * 请求参数映射<BR>
	 * params:请求参数中必须有abc，如：http://localhost:8080/springmvc02/user/hello7/123?abc=13
	 * 请求数据中有指定参数名
		@RequestMapping(params=“create”, method=RequestMethod. GET) ：表示请求中有”create” 的参数名且请求方法为”GET” 即可匹配
		请求数据中没有指定参数名@RequestMapping(params=“!create”,method=RequestMethod. GET)
		请求数据中指定参数名=值@RequestMapping(params="submitFlag=create")
		
		请求数据中指定参数名!=值@RequestMapping(params="submitFlag! =create", method=RequestMethod. GET)
		组合使用是“且”的关系@RequestMapping(params={“test1” , “test2=create”})
	 * 
	 * 方法名：hello7<BR>
	 * 创建人：hejie <BR>
	 * 时间：2017年6月9日-下午3:52:12 <BR>
	 * @param name
	 * @param model
	 * @param id
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	@RequestMapping(value="/hello7/{id}",params="abc")
	public String hello7(String name,Model model,@PathVariable(value="id") String id) {
		model.addAttribute("name",name);
		return "message";
		
	}
	
	/**
	 * 
	 * 请求限定头<BR>
	 * 同理params
	 * 方法名：hello7<BR>
	 * 创建人：hejie <BR>
	 * 时间：2017年6月9日-下午3:59:12 <BR>
	 * @param name
	 * @param model
	 * @param id
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	@RequestMapping(value="/hello8",headers="abc")
	public String hello8(String name,Model model,@PathVariable(value="id") String id) {
		model.addAttribute("name",name);
		return "message";
		
	}
	
}
