package com.tmdals.article_dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tmdals.article_common.Article;
import com.tmdals.common.Datasetting;
import com.tmdals.member_common.Member;
import com.tmdals.member_dataservice.MemberDAO;

@Repository
public class ArticleDAO {
@Autowired
MemberDAO memberDAO;
	public List<Article> get_all_list(int 시작번호, int 페이지당게시물수) {
		ArrayList<Article> 게시물들 = new ArrayList<Article>();
		// select * from ("select * from article order by wdate) where rownum>=%d and rownum <= $d",시작번호,시작번호+(갯수)-1
		//String sql = String.format("select * from article  where rownum>=%d and rownum <= %d order by wdate",시작번호,시작번호+(갯수)-1);
		String sql=String.format(				
				"SELECT * "+
				"FROM ("+
				    "SELECT a.*, ROWNUM AS rnum "+ 
				    "FROM ("+
				        "select * from article order by wdate desc"+
				    ") a "+
				    "WHERE ROWNUM <= %d"+
				") a "+
				"WHERE rnum >= %d",
	
				시작번호+(페이지당게시물수)-1, 시작번호);		
		
		try {
			//연결준비
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//연결
			Connection con = DriverManager.getConnection(Datasetting.path,Datasetting.ID,Datasetting.Password);
			
			Statement st = con.createStatement();
		
			ResultSet 게시물행= st.executeQuery(sql);
			System.out.println(게시물행);
			
			while(게시물행.next()) {
				
				int 번호 = 게시물행.getInt("no");
				String 제목 = 게시물행.getString("title");
				String 내용 = 게시물행.getString("contents");
				int 작성자번호 = 게시물행.getInt("member_no");
				Date 날짜 = 게시물행.getDate("wdate");
				//Date 날짜변환 = (Date)날짜;
				Member 찾은회원 = memberDAO.select_member_info(작성자번호);
				
				//회원 객체로 변환
				Article 한게시물 = new Article();
				한게시물.setNo(번호);
				한게시물.setTitle(제목);
				한게시물.setContents(내용);
				한게시물.setMember(찾은회원);
				한게시물.setDate(날짜);
				
				게시물들.add(한게시물);
				
			}
			게시물행.close();
			
			
			
			//연결x
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	
		return 게시물들;
	}

	public int allcount() {
		//select count(no) from article;
				int num = 0;
						String sql = String.format("select count(no) as cnt from article");
						try {
							//연결준비
							Class.forName("oracle.jdbc.driver.OracleDriver");
							
							//연결
							Connection con = DriverManager.getConnection(Datasetting.path,Datasetting.ID,Datasetting.Password);
							
							Statement st = con.createStatement();
						
							ResultSet 게시물행= st.executeQuery(sql);
							
							while(게시물행.next()) {
								
							 num = 게시물행.getInt("cnt");
								
								
							}
						
							게시물행.close();
							//연결x
							con.close();
						}catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
						System.out.println(num);
			return num;
	}

}
