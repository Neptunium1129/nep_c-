package 테입관리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import 설정.데이터설정;

public class 테입DAO {
	
	public int 저장하다(테입 새테입) {
		try {
			// 연결준비
			Class.forName("com.mysql.jdbc.Driver");

			// 연결
			Connection con = DriverManager.getConnection(데이터설정.연결문자열, 데이터설정.ID, 데이터설정.Password);
			// 할일
			
			PreparedStatement pst = con.prepareStatement("insert into 테입 (상태,영화_번호) values(?,?)");
			pst.setString(1, 새테입.get상태().toString());
			pst.setInt(2, 새테입.get영화().get번호());
			
			pst.executeUpdate();

		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}
	
	

}
