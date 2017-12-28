package cn.et.springmvc.lesson02.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.springmvc.lesson02.entity.RegBean;
/**
 * 后台验证步骤
 * 	1.javabean验证注解
 * 	2.action中使用@Valid表示javabean 使用Errors或BindingResult判断是否验证失败
 * 	3.出现jar冲突 4.3.2
 * @author Administrator
 *
 */
@Controller
public class RegController {

	@RequestMapping(value="/regs",method=RequestMethod.POST)
	public String reg(@Valid RegBean user,BindingResult er) throws Exception{
		if(!user.getPassword().equals(user.getRepassword())){
			er.addError(new FieldError("regBean", "repassword", "两次密码不一致"));
		}
		if(user.getAge() == null || "".equals(user.getAge().trim())){
			er.addError(new FieldError("regBean", "age", "年龄不能为空"));
		}else{
			try{
				Integer age = Integer.parseInt(user.getAge());
				if(age<1 || age>100){
					er.addError(new FieldError("regBean", "age", "年龄有误（1~100）"));
				}	
			}catch (Exception e) {
				er.addError(new FieldError("regBean", "age", "年龄必须是数字"));
			}
		}
		if(er.hasErrors()){
			return "lesson03/index.jsp"; 
		}
		return "lesson03/Jsp.jsp"; 
	}
}
