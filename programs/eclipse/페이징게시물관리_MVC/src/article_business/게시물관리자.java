package article_business;

import java.util.ArrayList;
import java.util.List;

import article_common.Article;

public class 게시물관리자 {
	int 총게시물수 = 133;
	article_dataservice.게시물DAO 게시물DAO = new article_dataservice.게시물DAO();
	public List<Article> 게시물을수집하다(int 시작번호, int 갯수) {
		
		//게시물DAO.모든게시물수집하다(시작번호, 갯수);
		
		List<Article> Articles = new ArrayList<Article>();
		for (int i = 시작번호; i < 시작번호 + 갯수 && i < 총게시물수; i++) {

			Article Article = new Article();
			Article.setNo(i);
			Article.setTitle("title" + i);
			Article.setWriter("라이터" + i);
			Articles.add(Article);

		}
		return Articles;

	}

	public int 총게시물수를주다() {
		
		return 총게시물수;

	}

	public Article 조회하다게시물By번호(int 게시물번호) {
		Article Article = new Article();
		Article.setNo(게시물번호);
		Article.setTitle("title" + 게시물번호);
		Article.setWriter("라이터" + 게시물번호);
		Article.setContents("작성글" + 게시물번호);
		// Articles.add(Article);

		return Article;
	}
	
	public void 등록하다(Article 새게시물) {
		System.out.println("등록성공");
		
	}

}
