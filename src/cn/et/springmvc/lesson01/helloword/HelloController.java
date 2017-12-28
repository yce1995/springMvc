package cn.et.springmvc.lesson01.helloword;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * springmvc��һ��·���ͷ�����ӳ�� ����һ��action��������
 * @author Administrator
 *
 */
@Controller
public class HelloController {
	@RequestMapping("/test")
	public String index(User user,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print("�����ˣ�"+user.getId()+"--"+user.getName());
		return null;
	}
	
	@RequestMapping("/mvc")
	public String index() throws IOException{
		return "/index.jsp";
	}
}
