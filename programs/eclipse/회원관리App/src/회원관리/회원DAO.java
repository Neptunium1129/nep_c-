package 회원관리;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;

/**
 * 
 */
public class 회원DAO {

    /**
     * Default constructor
     */
    public 회원DAO() {
    }

    /**
     * @param 새회원
     */
    public void 저장하다(회원 새회원) {
        // TODO implement here
		String sql = String.format("insert into 회원 (성명,전화) values('%s', '%s')", 새회원.get성명(), 새회원.get전화());
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