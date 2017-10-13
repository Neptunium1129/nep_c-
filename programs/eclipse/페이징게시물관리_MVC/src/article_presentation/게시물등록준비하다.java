package article_presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article_common.Article;

public class 게시물등록준비하다  implements IController {
	
	@Override
	public ModelAndView 처리하다(HttpServletRequest request, HttpServletResponse response) {
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("글등록창.jsp");

	
		//mv.addObject("pno", Integer.valueOf(str페이지번호));
		return mv;

	}

}
