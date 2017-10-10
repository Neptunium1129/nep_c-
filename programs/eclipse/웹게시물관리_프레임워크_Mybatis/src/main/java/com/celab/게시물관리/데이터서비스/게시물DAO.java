package com.celab.게시물관리.데이터서비스;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.celab.articlemanage.common.Article;

@Repository
public class 게시물DAO {
	@Autowired
	private 게시물Mapper 게시물Mapper; 
	
	public long 저장하다(Article 게시물){
		게시물Mapper.저장하다(게시물);
		return 게시물.getNo();
	}
    public Article 읽다_게시물By게시물번호(long 게시물번호){
    	return 게시물Mapper.읽다_게시물By게시물번호(게시물번호);
    }
    public List<Article> 읽다_모든게시물들(){
    	return 게시물Mapper.읽다_모든게시물들();
    }
}
