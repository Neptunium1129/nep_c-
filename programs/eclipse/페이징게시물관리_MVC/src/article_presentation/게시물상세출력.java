package article_presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article_business.게시물관리자;
import article_common.Article;

public class 게시물상세출력 implements IController {
	게시물관리자 한게시물관리자 = new 게시물관리자();

	@Override
	public ModelAndView 처리하다(HttpServletRequest request, HttpServletResponse response) {
		String str게시물번호 = request.getParameter("vno");
		int 게시물번호 = Integer.valueOf(str게시물번호);
		//String str페이지번호 =  request.getParameter("pno");
		Article 게시물 = 한게시물관리자.조회하다게시물By번호(게시물번호);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("게시물상세.jsp");

		mv.addObject("article", 게시물);
		//mv.addObject("pno", Integer.valueOf(str페이지번호));
		return mv;

	}

}
