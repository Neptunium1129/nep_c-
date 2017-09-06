package 테입관리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import 설정.데이터설정;
import 영화관리.영화;

public class 테입DAO {
	
	public void 저장하다(테입 새테입) {
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		String sql = String.format("insert into 테입 (상태,매입일자,영화_번호,대여여부) values('%s', '%s', %d, '%s')",
				새테입.get상태(), 
				df.format(새테입.get매입일자()),
				3,
				새테입.get대여여부());
		System.out.println(sql);
		// 영화 개봉일 date => sql 날짜 포맷 String
		try {
			// 연결준비
			Class.forName("com.mysql.jdbc.Driver");

			// 연결
			Connection con = DriverManager.getConnection(데이터설정.연결문자열, 데이터설정.ID, 데이터설정.Password);

			Statement st = con.createStatement();

			st.executeUpdate(sql);
			System.out.println(con + "연결");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public List<테입> 테입을수집하다By영화번호(int 영화번호) {
	      ArrayList<테입> 테입들 = new ArrayList<테입>();

	    	String sql = "select * from 테입 where 영화_번호 ='"+영화번호+"'";

	      System.out.println(sql);
	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");

				// 연결
				Connection con = DriverManager.getConnection(데이터설정.연결문자열, 데이터설정.ID, 데이터설정.Password);
				Statement st = con.createStatement();

				ResultSet 테입행들= st.executeQuery(sql);
				
				while(테입행들.next()) {
					
					int 번호 = 테입행들.getInt("영화번호");
					String 제목 = 테입행들.getString("영화명");
					int 테입번호 = 테입행들.getInt("테입번호");
				

					테입 테입_ = new 테입();
					테입_.set번호(번호);
					테입_.set영화(제목);;
					테입_.set감독(테입번호);
				
					
					
					테입들.add(테입_);
					
				}
				테입행들.close();
				
				
				
				//연결x
				con.close();
	      }catch (Exception e) {
			// TODO: handle exception
		}
	      
	      return 테입들;
	
	}
	
	

}
