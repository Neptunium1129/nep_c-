package com.tmdals.membercontrol;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tmdals.member_business.Member_Manager;
import com.tmdals.member_common.Member;

@Controller
public class MemberController {
@RequestMapping("register")
public ModelAndView Register(HttpServletRequest req, HttpServletResponse res) {
	
	ModelAndView mv = new ModelAndView();
	
	mv.setViewName("register");
	
	
	
	return mv;
}
@RequestMapping("register_success")
public ModelAndView register_success(HttpServletRequest req, HttpServletResponse res) {
	
	ModelAndView mv = new ModelAndView();
	
	mv.setViewName("register_success");
	
	
	
	return mv;
}

@RequestMapping("register_process")
public ModelAndView register_process(Member member) {
	ModelAndView mv = new ModelAndView();
	int 결과 = Member_Manager.Register_process(member);
	if(결과==1) {
		
		mv.addObject("name",member.getName());
		mv.addObject("email",member.getEmail());
		mv.setViewName("redirect:welcome");
		
	}else {
		
		
		mv.setViewName("redirect:register");
		
	}

	return mv;
}


@RequestMapping("id_search")
public String id_search() {
	
	return "check_id";
}


@RequestMapping("id_check")
public ModelAndView id_check(@RequestParam("ID")String id) {
	
boolean ID존재 = Member_Manager.Id_check(id);
	ModelAndView mv = new ModelAndView();
	mv.setViewName("check_id");
	
	mv.addObject("ID사용가능여부", (ID존재));
	mv.addObject("ID", id);
	return mv;
	
	
}
@RequestMapping("welcome")
public ModelAndView welcome(Member member) {
	
	ModelAndView mv = new ModelAndView();
	mv.setViewName("register_success");
	mv.addObject("name",member.getName());
	mv.addObject("email",member.getEmail());
	return mv;
}
	
}
