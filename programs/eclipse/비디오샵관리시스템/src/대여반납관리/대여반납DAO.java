package 대여반납관리;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import 설정.데이터설정;
import 영화관리.영화;
import 영화관리.장르;

public class 대여반납DAO {

	public void 저장하다(대여반납 새대여반납) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");

		try {

			// 연결준비
			Class.forName("com.mysql.jdbc.Driver");

			// 연결
			Connection con = DriverManager.getConnection(데이터설정.연결문자열, 데이터설정.ID, 데이터설정.Password);
			// 할일
			for(대여반납내역 대여반납내역:새대여반납.get대여반납내역들()) {
				PreparedStatement pst = con.prepareStatement("insert into 대여반납 (반납예정일,회원_번호,테입_번호) values(?,?,?)");
				pst.setString(1, df.format(대여반납내역.get반납예정일()));
				pst.setInt(2, 새대여반납.get회원VO().get번호());
				pst.setInt(3, 대여반납내역.get테입VO().get번호());
				
				pst.executeUpdate();
				
			}
			
			
			con.close();
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
	}
	
	
	

}