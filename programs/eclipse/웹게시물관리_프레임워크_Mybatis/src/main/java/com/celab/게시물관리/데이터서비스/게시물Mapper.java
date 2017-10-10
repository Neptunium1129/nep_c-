package com.celab.게시물관리.데이터서비스;

import java.util.List;

import com.celab.articlemanage.common.Article;

public interface 게시물Mapper {
	public void 저장하다(Article 게시물);
      public Article 읽다_게시물By게시물번호(long 게시물번호);
      public List<Article> 읽다_모든게시물들();
}
