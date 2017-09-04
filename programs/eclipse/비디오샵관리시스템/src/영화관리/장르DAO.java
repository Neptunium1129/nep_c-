package 영화관리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import 설정.데이터설정;

public class 장르DAO {
	public int 저장하다(장르 새장르) {
		//String sql = String.format("insert into 장르 (이름) values('%s')", 새장르.get이름());
		try {
			// 연결준비
			Class.forName("com.mysql.jdbc.Driver");

			// 연결
			Connection con = DriverManager.getConnection(데이터설정.연결문자열, 데이터설정.ID, 데이터설정.Password);
			// 할일
			
			PreparedStatement pst = con.prepareStatement("insert into 장르 (이름) values(?)", Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, 새장르.get이름());
			
			pst.executeUpdate();

			ResultSet 발생한번호 = pst.getGeneratedKeys();
			System.out.println(발생한번호);
			
			if(발생한번호.next())
			{
				새장르.set번호(발생한번호.getInt(1));
			}
			System.out.println(con + "연결");
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
		}
		return 새장르.get번호();

	}

	public List<장르> 모든장르를모으다() {
		ArrayList<장르> 장르들 = new ArrayList<장르>();

		String 질의SQL문 = "select * from 장르";

		try {
			// 연결준비
			Class.forName("com.mysql.jdbc.Driver");

			// 연결
			Connection con = DriverManager.getConnection(데이터설정.연결문자열, 데이터설정.ID, 데이터설정.Password);

			Statement st = con.createStatement();

			ResultSet 장르행들 = st.executeQuery(질의SQL문);

			while (장르행들.next()) {

				int 번호 = 장르행들.getInt("번호");
				String 이름 = 장르행들.getString("이름");

				// 회원 객체로 변환
				장르 한장르 = new 장르();
				한장르.set번호(번호);
				한장르.set이름(이름);

				장르들.add(한장르);

			}
			장르행들.close();

			// 연결x
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return 장르들;

	}
	
	public boolean 찾다By장르명(String 장르명) {
		boolean 존재여부 = false;
		String 질의SQL문 = "select * from 장르 where 장르.이름='"+장르명+"'";

		try {
			// 연결준비
			Class.forName("com.mysql.jdbc.Driver");

			// 연결
			Connection con = DriverManager.getConnection(데이터설정.연결문자열, 데이터설정.ID, 데이터설정.Password);

			Statement st = con.createStatement();

			ResultSet 장르행들 = st.executeQuery(질의SQL문);

			if (장르행들.next()) {
				존재여부=true;
		

			}
			장르행들.close();

			// 연결x
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 존재여부;
	}
}
