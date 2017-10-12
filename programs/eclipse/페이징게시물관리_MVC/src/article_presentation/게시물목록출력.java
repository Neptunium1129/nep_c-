package article_presentation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article_business.게시물관리자;
import article_common.Article;

public class 게시물목록출력 implements IController {
	@Override
	public ModelAndView 처리하다(HttpServletRequest request, HttpServletResponse response) {
		String str페이지번호 = request.getParameter("pno");
		int 요청페이지번호 = (str페이지번호 == null) ? 1 : Integer.valueOf(str페이지번호);

		int 페이지당게시물수 = 10;
		int 시작번호 = (요청페이지번호 - 1) * 페이지당게시물수 + 1; // 어떤페이지에서 게시물의 시작번호
		게시물관리자 한게시물관리자 = new 게시물관리자();
		List<Article> Articles = 한게시물관리자.게시물을수집하다(시작번호, 페이지당게시물수);

		int 총게시물수 = 한게시물관리자.총게시물수를주다(); // db

		ModelAndView mv = new ModelAndView();
		mv.setViewName("게시물목록2.jsp");
		mv.addObject("Articles", Articles);
		mv.addObject("총게시물수", 총게시물수);
		mv.addObject("요청페이지번호", 요청페이지번호);

		return mv;
	}

}
