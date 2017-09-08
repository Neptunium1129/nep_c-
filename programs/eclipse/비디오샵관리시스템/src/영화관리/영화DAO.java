package 영화관리;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import 설정.데이터설정;
import 회원관리.회원;

public class 영화DAO {
	   장르DAO 한장르DAO = new 장르DAO();

	public 영화DAO() {

	}

	public void 저장하다(영화 새영화) {
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		String sql = String.format("insert into 영화 (제목,부제,감독,주연,개봉일,장르_번호) values('%s', %s, '%s', '%s', '%s', %d)",
				새영화.get제목(), (새영화.get부제() != null) ? "'" + 새영화.get부제() + "'" : null, 새영화.get감독(), 새영화.get주연(),
				 df.format(새영화.get개봉일()),
				//새영화.get개봉(),
				새영화.get장르_번호());// 새영화.get장르().get이름();
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
	
	public List<영화> 영화를수집하다By제목(String 유사영화명) {
	      ArrayList<영화> 영화들 = new ArrayList<영화>();

	    	String sql = "select * from 영화 where 제목 like '%"+유사영화명+"%'";

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
					String 감독 = 영화행들.getString("감독");
					String 주연 = 영화행들.getString("주연");
					Date 개봉일 = 영화행들.getDate("개봉일");
					int 장르번호 = 영화행들.getInt("장르_번호");
					장르 찾은장르 = 한장르DAO.찾다By번호(장르번호);
					
					
					
					//회원 객체로 변환
					영화 영화_ = new 영화();
					영화_.set번호(번호);
					영화_.set제목(제목);
					
					영화_.set감독(감독);
					영화_.set주연(주연);
					영화_.set개봉일(개봉일);
					영화_.set장르(찾은장르);
					
					
					
					영화들.add(영화_);
					
				}
				영화행들.close();
				
				
				
				//연결x
				con.close();
	      }catch (Exception e) {
			// TODO: handle exception
		}
	      
	      return 영화들;
	
	}
	
	public 영화 찾다By번호(int 영화_번호) {
		영화 찾은영화=null;
    	String sql = "SELECT * FROM 영화 where 영화.번호='"+영화_번호+"'";
    		//SELECT 제목 FROM videoshopdb.영화 where 번호=3;
	      System.out.println(sql);
	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");

				// 연결
				Connection con = DriverManager.getConnection(데이터설정.연결문자열, 데이터설정.ID, 데이터설정.Password);
				Statement st = con.createStatement();
				
				ResultSet rs = st.executeQuery(sql);
				
			/*	System.out.println("!!!!"+rs);
				
				if (rs.next()) {
					System.out.println("!!!!"+rs.getString("제목"));
					String 제목 = rs.getString("제목");
					영화 한영화 = new 영화();
					한영화.set제목(제목);
				}*/
				
			
				while(rs.next()) {
					//각 행 읽기
					int 번호=rs.getInt("번호");
					String 제목=rs.getString("제목");
					String 부제=rs.getString("부제");
					String 감독=rs.getString("감독");
					String 주연=rs.getString("주연");
					Date 개봉일=rs.getDate("개봉일");
					int 장르번호=rs.getInt("장르_번호");
					장르 찾은장르=한장르DAO.찾다By번호(장르번호);
					
					//영화 객체로 변환
					찾은영화=new 영화();
					찾은영화.set번호(번호);
					찾은영화.set제목(제목);
					찾은영화.set부제(부제);
					찾은영화.set감독(감독);
					찾은영화.set주연(주연);
					찾은영화.set개봉일(개봉일);
					찾은영화.set장르(찾은장르);
					
					System.out.println("@@@@@"+찾은영화.get제목());

				}
				rs.close();				
				//3.연결X
				con.close();			
				 
	      }catch (Exception e) {
			// TODO: handle exception
	    	  e.printStackTrace();
		}
	    	return 찾은영화;
	}

}
