package cn.et.springmvc.lesson04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TokenInteractor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String s1 = request.getParameter("myToken");
		Object s2 = request.getSession().getAttribute("myToken");
		//需要验证重复提交
		if(s1!=null){
			//重复提交
			if(s2==null){
				return false;
			}else{
				if(s1.equals(s2)){
					request.getSession().removeAttribute("myToken");
					return true;
				}else{
					return false;
				}
			}
		}else{
			return true;
		}
	}
}