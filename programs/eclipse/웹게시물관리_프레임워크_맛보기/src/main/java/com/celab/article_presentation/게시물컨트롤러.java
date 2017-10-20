package com.celab.article_presentation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.celab.article_business.게시물관리자;
import com.celab.article_common.Article;


@Controller
public class 게시물컨트롤러{
	
	@Autowired
	게시물관리자 한게시물관리자;
	
	
	@RequestMapping("list")
	public ModelAndView 목록을출력하다(HttpServletRequest request, HttpServletResponse response,HttpSession session) {

		String id = (String)session.getAttribute("ID");
		
		String str페이지번호 = request.getParameter("pno");
		int 요청페이지번호 = (str페이지번호 == null) ? 1 : Integer.valueOf(str페이지번호);

		int 페이지당게시물수 = 10;
		int 시작번호 = (요청페이지번호 - 1) * 페이지당게시물수 + 1; // 어떤페이지에서 게시물의 시작번호
		List<Article> Articles = 한게시물관리자.게시물을수집하다(시작번호, 페이지당게시물수);

		int 총게시물수 = 한게시물관리자.총게시물수를주다(); // db

		ModelAndView mv = new ModelAndView();
	
	/*		if(id==null) {
				mv.addObject("log_check", "0");
				
			}else {
				mv.addObject("log_check", "1");
			}*/
			mv.setViewName("게시물목록3");
	
		
		mv.addObject("Articles", Articles);
		mv.addObject("총게시물수", 총게시물수);
		mv.addObject("요청페이지번호", 요청페이지번호);

		return mv;
		
	}
		
		
		
		
		@RequestMapping("view")
		public ModelAndView 상세출력하다(HttpServletRequest request, HttpServletResponse response) {
			String str게시물번호 = request.getParameter("vno");
			int 게시물번호 = Integer.valueOf(str게시물번호);
			//String str페이지번호 =  request.getParameter("pno");
			Article 게시물 = 한게시물관리자.조회하다게시물By번호(게시물번호);

			ModelAndView mv = new ModelAndView();
			mv.setViewName("게시물상세");

			mv.addObject("article", 게시물);
			//mv.addObject("pno", Integer.valueOf(str페이지번호));
			return mv;
			
			
	}
	
		
		@RequestMapping("write")
		public ModelAndView 글등록하다(HttpServletRequest request, HttpServletResponse response) {
			
			String 제목 = request.getParameter("title");
			String 내용 = request.getParameter("contents");
			String 작성자 = request.getParameter("writer");
			
			Article 새게시물 = new Article();
			새게시물.setTitle(제목);
			새게시물.setContents(내용);
			새게시물.setWriter(작성자);
			한게시물관리자.등록하다(새게시물);


			ModelAndView mv = new ModelAndView();
			//mv.setViewName("등록테스트.jsp");//forward:list
			//\mv.addObject("title", 제목);
			mv.setViewName("redirect:list");
			return mv;

		}
		
		@RequestMapping("write2")
		public ModelAndView 글등록하다2(@RequestParam("title")String 제목,
									@RequestParam("contents")String 내용,
									@RequestParam("writer")String 작성자) {
			                     //만든놈이 이렇게하라고함
			

			Article 새게시물 = new Article();
			새게시물.setTitle(제목);
			새게시물.setContents(내용);
			새게시물.setWriter(작성자);
			한게시물관리자.등록하다(새게시물);


			ModelAndView mv = new ModelAndView();
			//mv.setViewName("등록테스트.jsp");//forward:list
			//\mv.addObject("title", 제목);
			mv.setViewName("redirect:list");
			return mv;

		}
		
		
		@RequestMapping("write3")
		public ModelAndView 글등록하다3(Article 새게시물) {
			                     //만든놈이 이렇게하라고함
			

		/*	Article 새게시물 = new Article();
			새게시물.setTitle(제목);
			새게시물.setContents(내용);
			새게시물.setWriter(작성자);
			한게시물관리자.등록하다(새게시물);*/

			한게시물관리자.등록하다(새게시물);
			ModelAndView mv = new ModelAndView();
			//mv.setViewName("등록테스트.jsp");//forward:list
			//\mv.addObject("title", 제목);
			mv.setViewName("redirect:list");
			return mv;

		}
		
		@RequestMapping("write4")
		public String 글등록하다4(Article 새게시물) {
			                     //만든놈이 이렇게하라고함
			

	

			한게시물관리자.등록하다(새게시물);
			ModelAndView mv = new ModelAndView();
			
			return "redirect:list";

		}
		
		
		
		@RequestMapping("preparewrite")
		public ModelAndView 글등록준비하다(HttpServletRequest request, HttpServletResponse response) {
		
			
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("글등록창");

		
			//mv.addObject("pno", Integer.valueOf(str페이지번호));
			return mv;

		}

	
	

}
