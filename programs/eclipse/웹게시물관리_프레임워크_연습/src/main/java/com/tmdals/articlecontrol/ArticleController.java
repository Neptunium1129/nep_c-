package com.tmdals.articlecontrol;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tmdals.article_business.Article_Manager;
import com.tmdals.article_common.Article;

@Controller
public class ArticleController {
	@Autowired
	Article_Manager article_Manager;
	
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		
	String id = (String)session.getAttribute("ID");
		
		String str페이지번호 = request.getParameter("pno");
		int 요청페이지번호 = (str페이지번호 == null) ? 1 : Integer.valueOf(str페이지번호);
		int 페이지당게시물수 = 10;
		int 시작번호 = (요청페이지번호 - 1) * 페이지당게시물수 + 1; // 어떤페이지에서 게시물의 시작번호
		
		
		List<Article> Articles = article_Manager.get_all_list(시작번호, 페이지당게시물수);

		int 총게시물수 = article_Manager.allcount(); // db

	
		
		mv.addObject("Articles", Articles);
		mv.addObject("pno", 요청페이지번호);
		mv.addObject("totalArticleCount", 총게시물수);
		mv.setViewName("board_list");
		
		
		return mv;
	}

}
