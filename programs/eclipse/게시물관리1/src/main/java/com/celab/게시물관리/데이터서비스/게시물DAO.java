package com.celab.게시물관리.데이터서비스;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.celab.게시물관리.공통.게시물;
import com.celab.게시물관리.공통.데이터설정;


@Repository
public class 게시물DAO {

	public List<게시물> 모든게시물수집하다(){
		ArrayList<게시물> 게시물들 = new ArrayList<게시물>();
		String sql = "select * from 게시물 ORDER BY 번호 DESC";
		try {
			//연결준비
			Class.forName("com.mysql.jdbc.Driver");
			
			//연결
			Connection con = DriverManager.getConnection(데이터설정.연결문자열,데이터설정.ID,데이터설정.Password);
			
			Statement st = con.createStatement();
		
			ResultSet 게시물행= st.executeQuery(sql);
			
			while(게시물행.next()) {
				
				int 번호 = 게시물행.getInt("번호");
				String 제목 = 게시물행.getString("제목");
				String 내용 = 게시물행.getString("내용");
				String 작성자 = 게시물행.getString("작성자");
				String 날짜 = 게시물행.getString("작성일자");
				
				
				//회원 객체로 변환
				게시물 한게시물 = new 게시물();
				한게시물.set번호(번호);
				한게시물.set제목(제목);
				한게시물.set내용(내용);
				한게시물.set작성자(작성자);
				한게시물.set날짜(날짜);
				
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
	
	public void 삭제하다(int 게시물번호) {
		
		String sql = "delete from 게시물 where 게시물.번호="+게시물번호;
		
		//Statement 명령 =null;
		//명령.executeUpdate(sql);
		System.out.println(sql);
		try {
			//연결준비
			Class.forName("com.mysql.jdbc.Driver");
			
			//연결
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bbs","root","");
			
			//Statement st =con.createStatement();
			//st.executeUpdate("sql");
		
			Statement st = con.createStatement();
		
			st.executeUpdate(sql);
			System.out.println(con+"연결");
			
			//연결x
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void 등록하다(게시물 새게시물) {
		String sql = String.format("insert into 게시물 (제목,내용,작성자,작성비번) values('%s', '%s', '%s','%s')", 새게시물.get제목(), 새게시물.get내용(),새게시물.get작성자(),새게시물.get작성비번());
		System.out.println(sql);
		try {
			//연결준비
			Class.forName("com.mysql.jdbc.Driver");
			
			//연결
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bbs","root","");
			
			//Statement st =con.createStatement();
			//st.executeUpdate("sql");
		
			Statement st = con.createStatement();
		
			st.executeUpdate(sql);
			System.out.println(con+"연결");
			
			//연결x
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
	
	public 게시물 게시물을수집하다By게시물번호(int 게시물번호) {
		게시물 찾은게시물 = null;

		String sql = String.format("select * from 게시물 where 번호 =%d", 게시물번호);
		try {
			//연결준비
			Class.forName("com.mysql.jdbc.Driver");
			
			//연결
			Connection con = DriverManager.getConnection(데이터설정.연결문자열,데이터설정.ID,데이터설정.Password);
			
			Statement st = con.createStatement();
		
			ResultSet 게시물행= st.executeQuery(sql);
			while(게시물행.next()) {
				int 번호 = 게시물행.getInt("번호");
				String 제목 = 게시물행.getString("제목");
				String 내용  = 게시물행.getString("내용");
				String 작성자  = 게시물행.getString("작성자");
				String 날짜  = 게시물행.getString("작성일자");
				
				
				찾은게시물 = new 게시물();
				찾은게시물.set번호(번호);
				찾은게시물.set제목(제목);
				찾은게시물.set내용(내용);
				찾은게시물.set작성자(작성자);
				찾은게시물.set날짜(날짜);
				

				
			}
			게시물행.close();
			
			
			
			//연결x
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return 찾은게시물;
	}
	
	
	  public void 변경하다(게시물 변경게시물) {
	        // TODO implement here
			String sql = String.format("update 게시물 set 제목='%s', 내용='%s' where 번호=%d",변경게시물.get제목(), 변경게시물.get내용(),변경게시물.get번호());
			System.out.println(sql);
			try {
				//연결준비
				Class.forName("com.mysql.jdbc.Driver");
				
				//연결
				Connection con = DriverManager.getConnection(데이터설정.연결문자열,데이터설정.ID,데이터설정.Password);
				
				Statement st = con.createStatement();
			
				st.executeUpdate(sql);
				System.out.println(con+"연결");
				
				//연결x
				con.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    	
	    	
	    }

	public boolean 비번확인(게시물 비번검증) {
		// TODO Auto-generated method stub
		boolean 존재여부 = false;
		String sql = String.format("select 작성비번 from 게시물 where 번호=%d AND 작성비번 ='%s'", 비번검증.get번호(),비번검증.get작성비번());
		System.out.println(sql);
		try {
			//연결준비
			Class.forName("com.mysql.jdbc.Driver");
			
			//연결
			Connection con = DriverManager.getConnection(데이터설정.연결문자열,데이터설정.ID,데이터설정.Password);
			
			Statement st = con.createStatement();
		
			
			
			ResultSet rs = st.executeQuery(sql);

			
			if(rs.next()) {
				존재여부=true;
			}else {
				존재여부=false;
			}
			System.out.println(rs+"//"+존재여부);

			
			//연결x

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return 존재여부;
	}
	

}
