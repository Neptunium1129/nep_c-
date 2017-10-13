package frontController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article_presentation.IController;
import article_presentation.ModelAndView;
import article_presentation.게시물등록준비하다;
import article_presentation.게시물등록하다;
import article_presentation.게시물목록출력;
import article_presentation.게시물상세출력;

@WebServlet("/mfc")
public class MyFrontController extends HttpServlet {

	void 처리하다(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		System.out.println("실행함");

		int len = request.getContextPath().length();
		String 요청 = request.getRequestURI().substring(len + 1);
		System.out.println("요청:" + request.getRequestURI().substring(len + 1));
		boolean bForward = true;
		while(bForward) {
			IController controller = null;
			if (요청.equals("list")) {
				controller = new 게시물목록출력();
			} else if (요청.equals("view")) {
				controller = new 게시물상세출력();
			}else if (요청.equals("preparewrite")) {
				controller = new 게시물등록준비하다();
			}else if (요청.equals("write")) {
				
				controller = new 게시물등록하다();
			} else {

				return;
			}
			ModelAndView mv = controller.처리하다(request, response);
			String path = mv.getViewName();
			if(path.contains("forward:")) {
				요청=path.substring("forward:".length());
			}else {
			bForward=false;
			for (Entry<String, Object> entry : mv.attributes.entrySet()) {

				request.setAttribute(entry.getKey(), entry.getValue());

			}
			RequestDispatcher rd = request.getRequestDispatcher(mv.getViewName());
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

	}
			
}
		

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		처리하다(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		처리하다(request, response);
	}

}
