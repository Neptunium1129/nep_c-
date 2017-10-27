package com.celab.membermanage_presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.celab.membermanage_business.회원관리자;
import com.celab.membermanage_common.Member;

@Controller
public class 회원컨트롤러 {
@Autowired 회원관리자 회원관리자;
	@RequestMapping("회원등록준비")
	public String 회원등록준비하다() {

		return "회원등록창";
	}
	@RequestMapping("회원등록")
	public ModelAndView 회원등록하다(Member 회원) {
		ModelAndView mv = new ModelAndView();
		int 결과 = 회원관리자.회원등록하다(회원);
		if(결과==1) {
			
			mv.addObject("name",회원.getName());
			mv.addObject("email",회원.getEmail());
			mv.setViewName("redirect:welcome");
		}else {
			

			mv.setViewName("redirect:main");
			
		}

		return mv;
	}
	@RequestMapping("welcome")
	public ModelAndView 회원등록환영창(Member 회원) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("회원등록환영창");
		mv.addObject("name",회원.getName());
		mv.addObject("email",회원.getEmail());
		return mv;
	}
	@RequestMapping("아이디중복검사준비")
	public String 아이디중복검사준비하다() {
		
		return "아이디중복검사창";
	}
	@RequestMapping("아이디중복검사")
	public ModelAndView 아이디중복검사준비하다(@RequestParam("ID")String id) {
		
	boolean ID존재 = 회원관리자.ID존재여부확인하다(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("아이디중복검사창");
		
		mv.addObject("ID사용가능여부", (ID존재));
		mv.addObject("ID", id);
		return mv;
		
		
	}

	
	
	
}
