package com.tmdals.logincontrol;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tmdals.member_business.Member_Manager;

@Controller
public class LoginController {
@Autowired
Member_Manager member_Manager;
	@RequestMapping("login_process")
	public ModelAndView Login_process(@RequestParam("ID")String ID, @RequestParam("Password")String Password, HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		if(member_Manager.Login(ID,Password)) {
			session.setAttribute("ID", ID);
			mv.setViewName("redirect:main");
			
		}else {
			mv.addObject("check",false);
			mv.setViewName("forward:main");	
	
		}

		return mv;
		
	}
	
	@RequestMapping("logout")
	public String 로그아웃하다(HttpSession session) {
		session.invalidate();
		

		return "redirect:main";
	}
		
	
}
