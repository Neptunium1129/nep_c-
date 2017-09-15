package com.celab.게시물관리.업무서비스;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celab.게시물관리.공통.게시물;
import com.celab.게시물관리.데이터서비스.게시물DAO;

@Service

public class 게시물관리 {
	@Autowired
	게시물DAO 게시물DAO;
    //게시물DAO 한게시물DAO = new 게시물DAO();

	

	//게시물들 수집
	public List<게시물> 모든게시물을수집하다(){
		
		return 게시물DAO.모든게시물수집하다();
	}

	//게시물(게시물번호)수집						
	public 게시물 게시물수집하다By게시물번호(int 게시물번호) {
		return 게시물DAO.게시물을수집하다By게시물번호(게시물번호);
	}
	
	//게시물 변경
	public void 게시물정보변경하다(게시물 변경된게시물) {
		
		게시물DAO.변경하다(변경된게시물);
		
	}
	//게시물삭제
	public void 게시물을삭제하다(int 게시물번호) {
		게시물DAO.삭제하다(게시물번호);
		
		
	}
	//게시물창 등럭		
	public void 게시물을등록하다(게시물 새게시물) {
		게시물DAO.등록하다(새게시물);
	}
	
	public boolean 비번확인(게시물 검증게시물) {
		
		return 게시물DAO.비번확인(검증게시물);
		
		
	}
	
	
	
}
