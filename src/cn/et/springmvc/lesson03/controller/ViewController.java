package cn.et.springmvc.lesson03.controller;

import java.io.OutputStream;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import cn.et.springmvc.lesson03.entity.RegBean;
/**
 * 后台验证步骤
 * 	1.javabean验证注解
 * 	2.action中使用@Valid表示javabean 使用Errors或BindingResult判断是否验证失败
 * 	3.出现jar冲突 4.3.2
 * @author Administrator
 *
 */
@Controller
public class ViewController {

	@RequestMapping(value="/viewResover",method=RequestMethod.GET)
	public String reg(@Valid RegBean user,BindingResult er) throws Exception{
		return "lesson03/Jsp.jsp"; 
	}
	
	@Autowired
	MessageSource ms;
	@RequestMapping(value="/nation",method=RequestMethod.GET)
	public String reg(HttpServletResponse se,OutputStream os,Locale locale) throws Exception{
		se.setContentType("text/html;setchar=UTF-8");
		os.write(ms.getMessage("key", null, locale).getBytes("UTF-8"));
		return null; 
	}
	
	
	@RequestMapping(value="/mid",method=RequestMethod.GET)
	public String mid() throws Exception{
		return "/lesson04/index.jsp"; 
	}
	
	@RequestMapping(value="/myreg",method=RequestMethod.POST)
	public String mid(@Valid RegBean user,BindingResult resul) throws Exception{
		if(resul.hasErrors()){
			return "/lesson04/index.jsp";
		} 
		return null;
	}
}
