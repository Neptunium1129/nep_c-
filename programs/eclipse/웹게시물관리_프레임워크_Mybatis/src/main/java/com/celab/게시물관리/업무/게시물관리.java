package com.celab.게시물관리.업무;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.celab.articlemanage.common.Article;
import com.celab.게시물관리.데이터서비스.게시물DAO;

@Service
@Transactional
public class 게시물관리 {
	@Autowired
	게시물DAO 게시물DAO;
	
	public long 게시물을기록하다(Article 게시물){
		return 게시물DAO.저장하다(게시물);
	}
	
	public List<Article> 모든게시물들을수집하다(){
		return 게시물DAO.읽다_모든게시물들();
	}

	public Article 게시물을수집하다By게시물번호(long 게시물번호) {
		return 게시물DAO.읽다_게시물By게시물번호(게시물번호);
	}

}
