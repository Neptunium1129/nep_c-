package com.celab.addressmanage_presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.celab.addressmanage_business.주소관리자;
import com.celab.addressmanage_common.ZipAddress;

@Controller
public class 주소컨트롤러 {
	
	@Autowired
      주소관리자 주소관리자;
	@RequestMapping("주소조회준비")
	public String 주소조회준비하다() {
		
		return "주소조회창";
	}
	@RequestMapping("주소조회")
	public ModelAndView 주소조회하다(@RequestParam("동이름")String 동이름) {
		List<ZipAddress> 주소들 = 주소관리자.주소를조회하다(동이름);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("주소조회창");
		mv.addObject("addresses", 주소들);
		return mv;
	}

	
	
}
