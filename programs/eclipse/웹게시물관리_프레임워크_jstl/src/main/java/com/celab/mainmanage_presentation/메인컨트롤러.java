package com.celab.mainmanage_presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class 메인컨트롤러 {
	
	@RequestMapping("main")
	public ModelAndView giveContents(HttpServletRequest requset, HttpSession session) {
		
		
		//String id = (String)session.getAttribute("ID");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");

		//mv.addObject("",);
		//mv.addObject("ID", "tmdals");
		return mv;
	}
	
	

}
