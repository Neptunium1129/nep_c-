package com.celab.게시물관리.화면;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.celab.게시물관리.공통.게시물;
import com.celab.게시물관리.업무서비스.게시물관리;

@Controller
public class 게시물컨트롤러 {
	//게시물관리 게시물관리 = new 게시물관리();
	List<게시물> 게시물;
	@Autowired 
	게시물관리 게시물관리;
	
	@RequestMapping("/boardlist")
	public ModelAndView 게시물목록을출력하다() {
		
		//게시물들 수집
		List<게시물> 게시물들 = 	게시물관리.모든게시물을수집하다();
		
		//게시물목록창에 뿌리다
		ModelAndView mv = new ModelAndView();
		mv.setViewName("게시물목록창");
		mv.addObject("게시물들",게시물들);
		return mv;
		
	}
	@RequestMapping("/게시물상세")
	public ModelAndView 게시물상세를출력하다(@RequestParam("no") int 게시물번호) {
		
		//게시물(게시물번호)수집
		System.out.println(게시물번호);
	      게시물 찾은게시물 = 게시물관리.게시물수집하다By게시물번호(게시물번호);
		//게시물 상세창에 출력
		ModelAndView mv = new ModelAndView();
		mv.setViewName("게시물상세창");
		mv.addObject("게시물",찾은게시물);
		return mv;
		
	}
	@RequestMapping("/게시물변경")
	public String 게시물정보를변경하다(게시물 변경된게시물) {
		//게시물 변경
		
		if(게시물관리.비번확인(변경된게시물)==true) {
			게시물관리.게시물정보변경하다(변경된게시물);
		}else {
			return "redirect:/boardlist";
		}
		//게시물목록을출력
		return "redirect:/boardlist";

	}
	@RequestMapping("/게시물삭제")
	public String 게시물을삭제하다(@RequestParam("no") int 게시물번호) {
		
		// 게시물 삭제
		게시물관리.게시물을삭제하다(게시물번호);
		//게시물목록을 출력
		return "redirect:/boardlist";

	}
	@RequestMapping("/게시물등록준비")
	public ModelAndView 게시물을등록준비하다() {
		//게시물창 띄움
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("게시물등록창");
		return mv;
	}
	
	@RequestMapping("/게시물등록")
	public String 게시물을등록하다(게시물 새게시물) {
		//게시물창 등럭
		
		게시물관리.게시물을등록하다(새게시물); //객체로 보낼땐 항상 포스트
		
		System.out.println("#1");
		//게시물목록을출력
		return "redirect:/boardlist";
		
	}
}
