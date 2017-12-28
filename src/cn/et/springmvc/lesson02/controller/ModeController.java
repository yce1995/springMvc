package cn.et.springmvc.lesson02.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * springmvc中Model相关对象 是处理和数据相关的对象
 * @ModelAttribute 重命名 参数数据
 * Model（ModelMap|Map）传递数据到视图（request.setAttribute）
 * ModelAndView 绑定数据到视图（ModelMap用于传递数据 View对象用于跳转）
 * 
 * 
 * @author Administrator
 *
 */
@Controller
public class ModeController {
	@RequestMapping(value="/case",method=RequestMethod.GET)
	public String case1(Map map) throws Exception{
		map.put("hello", "我去");
		return "/lesson03/Jsp.jsp";
	}
	
	@RequestMapping(value="/case2",method=RequestMethod.GET)
	public ModelAndView case2() throws Exception{
		ModelAndView ma = new ModelAndView("/lesson03/Jsp.jsp");
		ma.addObject("sex","boy");
		return ma;
	}
}
