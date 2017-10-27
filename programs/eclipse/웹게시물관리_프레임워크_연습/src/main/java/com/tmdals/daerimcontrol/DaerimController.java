package com.tmdals.daerimcontrol;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tmdals.daerim_common.daerimDTO;
import com.tmdals.daerim_business.*;

@Controller
public class DaerimController {
	@Autowired
	대림관리자 대림관리자;
	
	@RequestMapping("daerim")
	public ModelAndView drmain(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		
		List<daerimDTO> daerim = 대림관리자.정보가져오기();
		System.out.println(daerim.size());
		
		mv.setViewName("daerim");

		mv.addObject("Books", daerim);

		return mv;
	}
	
	@RequestMapping("daerim_view")
	public ModelAndView daerim_view(HttpServletRequest req, HttpServletResponse res, @RequestParam("no") int no) {
	ModelAndView mv = new ModelAndView();
	
	System.out.println(no);
	daerimDTO 게시물2 = 대림관리자.조회하다게시물By번호(no);

	mv.setViewName("daerim_view");
	mv.addObject("views",게시물2);
		return mv;
	}
	
	@RequestMapping("register")
	public String register(daerimDTO drdto) {
	
		System.out.println(drdto.getTitle());
		System.out.println(drdto.getImg());
		
			return "gggg";
		}
	
}
