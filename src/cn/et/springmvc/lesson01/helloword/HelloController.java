package cn.et.springmvc.lesson01.helloword;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * springmvc中一个路径和方法的映射 叫做一个action（动作）
 * @author Administrator
 *
 */
@Controller
public class HelloController {
	@RequestMapping("/test")
	public String index(User user,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print("你来了！"+user.getId()+"--"+user.getName());
		return null;
	}
	
	@RequestMapping("/mvc")
	public String index() throws IOException{
		return "/index.jsp";
	}
}
