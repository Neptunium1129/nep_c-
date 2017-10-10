package 회원관리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import 설정.데이터설정;

public class 회원DAO {
	
    public 회원DAO() {
    }
    
    
    public void 데이터베이스에등록하다(회원 새회원) {
    	String sql = String.format("insert into 회원 (성명,전화) values ('%s','%s')", 새회원.get성명(),새회원.get전화());
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection(데이터설정.연결문자열,데이터설정.ID,데이터설정.Password);
    		Statement st = con.createStatement();
    		st.executeUpdate(sql);
    		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    }

}
