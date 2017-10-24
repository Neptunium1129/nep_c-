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
		if(path.equals("/main") ||
				path.equals("/로그인하다")||
				path.equals("/로그아웃")||
				path.equals("/회원등록준비")||
				path.equals("/로그인준비")||
				path.equals("/주소조회준비")||
				path.equals("/주소조회")||
				path.equals("/아이디중복검사")||
				path.equals("/회원등록")||
				path.equals("/welcome")||
				path.equals("/아이디중복검사준비")
				
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
