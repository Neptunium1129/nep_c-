package com.celab.common;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class 로그인인터셉터 implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("---Before Method Execution---");
		String path = request.getServletPath();    
		System.out.println(path);
		if(path.equals("/curl")
				
				) {  
			        return true;
		}
		System.out.println("인터셉터");
		String id=(String)request.getSession().getAttribute("ID");
		if(id==null){
			RequestDispatcher 요청전달자=request.getRequestDispatcher("로그인준비");
			요청전달자.forward(request, response);
			return false;
		}		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
		
	}

	
	
}
