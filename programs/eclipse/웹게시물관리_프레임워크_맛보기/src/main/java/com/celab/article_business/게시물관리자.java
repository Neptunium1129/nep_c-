package com.celab.article_business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celab.article_common.Article;
import com.celab.article_dataservice.게시물DAO;

@Service
public class 게시물관리자 {
	
	@Autowired
	게시물DAO 게시물DAO;
	
	int 총게시물수 = 133;
	public List<Article> 게시물을수집하다(int 시작번호, int 갯수) {
		
		//게시물DAO.모든게시물수집하다(시작번호, 갯수);
		//업무규칙검사
		//----
		//DB처리
		List<Article> Articles = 게시물DAO.모든게시물수집하다(시작번호, 갯수);
		return Articles;

	}

	public int 총게시물수를주다() {
		
		
		return 게시물DAO.총게시물수구하기();

	}

	public Article 조회하다게시물By번호(int 게시물번호) {
		/*Article Article = new Article();
		Article.setNo(게시물번호);
		Article.setTitle("title" + 게시물번호);
		Article.setWriter("라이터" + 게시물번호);
		Article.setContents("작성글" + 게시물번호);*/
		// Articles.add(Article);

		return 게시물DAO.수집하다게시물By게시물번호(게시물번호);
	}
	
	public void 등록하다(Article 새게시물) {
		
		
		System.out.println("등록성공");
		게시물DAO.저장하다(새게시물);
		
	}

}
