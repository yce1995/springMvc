package cn.et.springmvc.lesson04.controller;

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
import cn.et.springmvc.lesson04.MyInteractor;
import cn.et.springmvc.lesson04.dao.MoneyDaoImpl;
/**
 * 后台验证步骤
 * 	1.javabean验证注解
 * 	2.action中使用@Valid表示javabean 使用Errors或BindingResult判断是否验证失败
 * 	3.出现jar冲突 4.3.2
 * @author Administrator
 *
 */
@Controller
public class InterController {

	@RequestMapping(value="/inter",method=RequestMethod.GET)
	public String reg(@Valid RegBean user,BindingResult er) throws Exception{
		return "lesson03/Jsp.jsp"; 
	}
	
	@Autowired
	MoneyDaoImpl mi;
	@RequestMapping(value="/tm",method=RequestMethod.GET)
	public String reg(Integer money,OutputStream os) throws Exception{
		mi.insert(money);
		os.write(("money:"+mi.select()).getBytes());
		return null;
	}
}
