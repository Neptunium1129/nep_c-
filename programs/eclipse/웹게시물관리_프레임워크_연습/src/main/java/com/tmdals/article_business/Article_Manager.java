package com.tmdals.article_business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmdals.article_common.Article;
import com.tmdals.article_dataservice.ArticleDAO;

@Service
public class Article_Manager {
@Autowired
ArticleDAO articledao;

	public List<Article> get_all_list(int 시작번호, int 페이지당게시물수) {
	
		
		
		return articledao.get_all_list(시작번호,페이지당게시물수);
	}

	public int allcount() {

		
		
		return articledao.allcount();
	}

}
