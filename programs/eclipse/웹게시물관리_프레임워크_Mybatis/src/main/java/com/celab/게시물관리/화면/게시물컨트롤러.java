package com.celab.게시물관리.화면;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.celab.articlemanage.common.Article;
import com.celab.게시물관리.업무.게시물관리;

@Controller
public class 게시물컨트롤러 {
//	@Autowired
//	게시물관리  게시물관리; 

	@RequestMapping("/등록준비")
	public ModelAndView 등록준비하다(){
		System.out.println("등록준비하다");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("게시물등록");
		return mv;
	}	
	
	@RequestMapping("/등록")
	public ModelAndView 등록하다(Article 새게시물){
		
//		게시물관리.게시물을기록하다(새게시물);
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("forward:목록");
		return mv;
	}	
	
	@RequestMapping("/목록")
	public ModelAndView 목록하다(){
		
		//게시물수집
//		List<Article> 게시물들=게시물관리.모든게시물들을수집하다();
		//결과
		ModelAndView mv=new ModelAndView();
		mv.setViewName("게시물목록");
//		mv.addObject("게시물들",게시물들);
		return mv;
	}	

}






