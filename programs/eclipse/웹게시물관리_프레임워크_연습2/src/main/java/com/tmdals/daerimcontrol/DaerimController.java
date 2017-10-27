package com.tmdals.daerimcontrol;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tmdals.daerim_common.commentDTO;
import com.tmdals.daerim_common.daerimDTO;
import com.tmdals.daerim_business.*;

@Controller
public class DaerimController {
	@Autowired
	대림관리자 대림관리자;
	
	@RequestMapping("daerim")
	public ModelAndView drmain(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		
		List<daerimDTO> daerim = 대림관리자.정보가져오기();
		System.out.println(daerim.size());
		
		mv.setViewName("daerim");

		mv.addObject("Books", daerim);

		return mv;
	}
	
	@RequestMapping("daerim_view")
	public ModelAndView daerim_view(HttpServletRequest req, HttpServletResponse res, @RequestParam("no") int no) {
	ModelAndView mv = new ModelAndView();
	
	System.out.println(no);
	daerimDTO 게시물2 = 대림관리자.조회하다게시물By번호(no);
	List<commentDTO> 댓글리스트 = 대림관리자.댓글리스트(no);
	
	
	
	mv.setViewName("daerim_view");
	mv.addObject("views",게시물2);
	mv.addObject("d_comment", 댓글리스트);
		return mv;
	}
	
	@RequestMapping("prepare")
	public String prepare() {
		
		return "registerBook";
	}
	@RequestMapping("register" )
	public String register(daerimDTO drdto,@RequestParam("cimg") MultipartFile cimg, HttpServletRequest req) {

		
		try {
			ServletContext context = req.getServletContext();
			String appPath = context.getRealPath("/");
			System.out.println(appPath);
			
			String 표지그림명 = cimg.getOriginalFilename();
			drdto.setImg(표지그림명);
			
			File 쓰기파일 = new File(appPath+"img//"+표지그림명);
			cimg.transferTo(쓰기파일);
			대림관리자.책등록(drdto);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		

		return "redirect:daerim";
		}
	
	@RequestMapping("comment_write")
	public ModelAndView commentwrite(commentDTO comment_DTO,@RequestParam("parent_id") int parent_id, @RequestParam("m_name") String m_name, @RequestParam("memoText") String memoText ) {
		ModelAndView mv = new ModelAndView();
		
		comment_DTO.setP_id(parent_id);
		comment_DTO.setC_writer(m_name);
		comment_DTO.setC_contents(memoText);		
		대림관리자.댓글저장(comment_DTO);
		
		System.out.println(parent_id+"/"+m_name+"/"+memoText);
		
		mv.setViewName("forward:daerim_view?no="+parent_id);
		return mv;
		
	}
	

}
