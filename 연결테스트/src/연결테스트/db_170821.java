package 연결테스트;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



public class db_170821 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	회원등록하다("라길동","444");
	//	회원등록하다("마길동","544");
	//	회원등록하다("바길동","644");
		
	

	}

	static void 회원등록하다(String 성명, String 전화) {
		
		String sql = String.format("insert into 회원 (성명,전화) values('%s', '%s')", 성명, 전화);
		System.out.println(sql);
		try {
			//연결준비
			Class.forName("com.mysql.jdbc.Driver");
			
			//연결
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userdb","root","");
			
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
	
	
}

