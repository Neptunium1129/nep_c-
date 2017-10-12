package article_presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IController {
 public ModelAndView 처리하다(HttpServletRequest request, HttpServletResponse response);
	
}
