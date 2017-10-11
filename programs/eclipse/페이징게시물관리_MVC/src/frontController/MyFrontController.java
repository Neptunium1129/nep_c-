package frontController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article_presentation.A;
import article_presentation.B;


@WebServlet("/mfc")
public class MyFrontController extends HttpServlet {
	
	void 처리하다(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("실행함");
		System.out.println("request.getRequestURI():"+request.getRequestURI());
		System.out.println("request.getRequestURL():"+request.getRequestURL());
		System.out.println("request.getContext():"+request.getContextPath());
		int len = request.getContextPath().length();
		String 요청 = request.getRequestURI().substring(len+1);
		System.out.println("요청:"+request.getRequestURI().substring(len+1));

		if(요청.equals("aa")) {
			
			new A().work();
			
		}else if(요청.equals("bb")) {
			
			new B().work();
		}
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		처리하다(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		처리하다(request,response);
	}

}
