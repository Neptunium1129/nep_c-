package com.celab.게시물관리.데이터서비스;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.celab.게시물관리.공통.게시물;

@Repository
public class 게시물DAO {

	public List<게시물> 모든게시물수집하다(){
		
		List<게시물> 게시물들 = new ArrayList<게시물>();

		
		for(int i = 1 ; i<100;i++) {
			
			게시물 게시물 = new 게시물();
			게시물.set번호(i);
			게시물.set제목("게시물" + String.valueOf(i));
			게시물.set내용("안녕" + String.valueOf(i));
			게시물들.add(게시물);
			
		}
		return 게시물들;
	}
	
	
}
