package 테입관리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import 설정.데이터설정;
import 영화관리.영화;
import 영화관리.영화DAO;

public class 테입DAO {
	영화DAO 한영화DAO = new 영화DAO();
	public int 저장하다(테입 새테입) {
		int result = 0;
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 String sql=String.format("insert into 테입(상태,매입일자,영화_번호) values('%s','%s',%d)",
					새테입.get상태내용(),
					df.format(새테입.get매입일자()),
					새테입.get영화_번호());

		/*String sql = String.format("insert into 테입 (상태,매입일자,영화_번호) values('%s', '%s', %d, '%s')",
				새테입.get상태().toString(), 
				df.format(새테입.get매입일자()),
				새테입.get영화().get번호()
				);*/
		System.out.println(sql);
		// 영화 개봉일 date => sql 날짜 포맷 String
		try {
			// 연결준비
			Class.forName("com.mysql.jdbc.Driver");

			// 연결
			Connection con = DriverManager.getConnection(데이터설정.연결문자열, 데이터설정.ID, 데이터설정.Password);

			Statement st = con.createStatement();

			result = st.executeUpdate(sql);
			
			
			System.out.println(con + "연결");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
		
		
	}
	
	public List<테입> 테입을수집하다By영화번호(int 영화번호) {
	     // ArrayList<테입> 테입들 = new ArrayList<테입>();
	  	List<테입> 테입들=new ArrayList<테입>();
	    //  String sql = "select * from 테입 where 영화_번호 ='"+영화번호+"'";
	      String sql = String.format("select * from 테입 where 영화_번호 =%d", 영화번호);
	      System.out.println(sql);
	      
	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");

				// 연결
				Connection con = DriverManager.getConnection(데이터설정.연결문자열, 데이터설정.ID, 데이터설정.Password);
				Statement st = con.createStatement();

				ResultSet 테입행들= st.executeQuery(sql);
				
				while(테입행들.next()) {
				/*	int 번호 = 테입행들.getInt("영화_번호");
					int 테입번호 = 테입행들.getInt("번호");
					테입 테입_ = new 테입();
					테입_.set번호(테입번호);*/
					
					
					int 번호= 테입행들.getInt("번호");
					테입상태 상태 = 테입상태.valueOf(테입행들.getString("상태"));
					Date 매입일자 = 테입행들.getDate("매입일자");
					int 영화_번호=테입행들.getInt("영화_번호");
					Boolean 대여여부 = 테입행들.getBoolean("대여여부");
					System.out.println(대여여부);
					영화 찾은영화 = 한영화DAO.찾다By번호(영화_번호);
					System.out.println("@@@@"+찾은영화.get제목());
					테입 테입_ = new 테입();
					테입_.set번호(번호);
					테입_.set상태(상태);
					테입_.set매입일자(매입일자);
					테입_.set대여여부(대여여부);
					테입_.set영화(찾은영화);
					테입들.add(테입_);
					
				}
				테입행들.close();
				
				
				
				//연결x
				con.close();
	      }catch (Exception e) {
			// TODO: handle exception
	    	  e.printStackTrace();
		}
	      
	      return 테입들;
	
	}
	
	public List<영화> 영화를가져오다By영화제목(String 영화제목) {
	      ArrayList<영화> 영화들 = new ArrayList<영화>();
	  //  String sql = "select * from 테입 where 영화_번호 ='"+영화번호+"'";
	  	String sql = "select * from 영화 where 제목 like '%"+영화제목+"%'";
	      System.out.println(sql);
	      
	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");

				// 연결
				Connection con = DriverManager.getConnection(데이터설정.연결문자열, 데이터설정.ID, 데이터설정.Password);
				Statement st = con.createStatement();

				ResultSet 영화행들= st.executeQuery(sql);
				
				while(영화행들.next()) {
					
					int 번호 = 영화행들.getInt("번호");
					String 제목 = 영화행들.getString("제목");
					영화 영화_ = new 영화();
					영화_.set번호(번호);
					영화_.set제목(제목);

					영화들.add(영화_);
					
				
				}
				영화행들.close();
				
				
				
				//연결x
				con.close();
	      }catch (Exception e) {
			// TODO: handle exception
	    	  e.printStackTrace();
		}
	      
	      
	      return 영화들;
	
	
	

}


}

