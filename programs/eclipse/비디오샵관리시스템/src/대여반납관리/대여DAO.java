package 대여반납관리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import 설정.데이터설정;

public class 대여DAO {

	public void 저장하다(대여반납 새대여반납) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");

			// 연결준비
			Class.forName("com.mysql.jdbc.Driver");

			// 연결
			Connection con = DriverManager.getConnection(데이터설정.연결문자열, 데이터설정.ID, 데이터설정.Password);
			// 할일

			PreparedStatement pst = con.prepareStatement("insert into 대여반납 (반납예정일,회원_번호,테입_번호) values(?,?,?)");
			pst.setString(1, df.format(새대여반납.get반납예정일()));
			pst.setInt(2, 새대여반납.회원VO.get번호());
			pst.setInt(3, 새대여반납.테입VO.get번호());
			

			pst.executeUpdate();
			
			System.out.println(pst + "연결");
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			// e.printStackTrace();
		}
		
		
	}
}
