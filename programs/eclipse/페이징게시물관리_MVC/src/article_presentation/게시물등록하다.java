package article_presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article_business.게시물관리자;
import article_common.Article;

public class 게시물등록하다  implements IController {
	게시물관리자 한게시물관리자 = new 게시물관리자();
	@Override
	public ModelAndView 처리하다(HttpServletRequest request, HttpServletResponse response) {
		
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
		mv.setViewName("forward:list");
		return mv;

	}

}
