package com.tmdals.maincontrol;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("main")
	public ModelAndView mainopen(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("main");
		
		return mv;
	}
	

}
