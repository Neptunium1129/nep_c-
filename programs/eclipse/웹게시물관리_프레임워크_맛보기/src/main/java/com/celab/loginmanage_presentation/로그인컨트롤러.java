package com.celab.loginmanage_presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.celab.membermanage_business.회원관리자;
//@autowierd 회원DAO 회원DAO;
@Controller
public class 로그인컨트롤러 {
@Autowired 회원관리자 회원관리자;
	@RequestMapping("ready")
	public String 로그인준비하다() {
		
			return "로그인창";
		
	
	}

	
	@RequestMapping("로그인하다")
	public ModelAndView 로그인하다(@RequestParam("ID")String ID, @RequestParam("Password")String Password, HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if(회원관리자.존재하는가(ID, Password)) {
			session.setAttribute("ID", ID);
			mv.setViewName("redirect:main");
		}else {
			mv.addObject("check",false);
			mv.setViewName("ready");		
		}
		return mv;
		
	}
		
	@RequestMapping("로그아웃")
	public String 로그아웃하다(HttpSession session) {
		session.invalidate();
		

		return "redirect:main";
	}
		
		//dao @repsotiory
		
		
	
	
	
}
