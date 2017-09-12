package com.celab.게시물관리.업무서비스;

import java.util.List;

import org.springframework.stereotype.Service;

import com.celab.게시물관리.공통.게시물;

@Service
public class 게시물관리 {


	//게시물들 수집
	public List<게시물> 모든게시물을수집하다(){
		System.out.println("게시물수집 프린트ln");
		return null;
	}

	//게시물(게시물번호)수집						
	public 게시물 게시물수집하다By게시물번호(int 게시물번호) {
		return null;
	}
	
	//게시물 변경
	public void 게시물정보변경하다(게시물 변경된게시물) {
		
	}
	//게시물삭제
	public void 게시물을삭제하다(int 게시물번호) {
		
	}
	//게시물창 등럭		
	public void 게시물을등록하다(게시물 새게시물) {
		System.out.println(새게시물.get제목());
		System.out.println(	새게시물.get내용());
	}
	
	
	
	
}
