package 회원관리;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
    
    public void 변경하다(회원 변경회원) {
        // TODO implement here
		String sql = String.format("update 회원 set 성명='%s', 전화='%s' where 번호=%d",변경회원.get성명(), 변경회원.get전화(),변경회원.get번호());
		System.out.println(sql);
		try {
			//연결준비
			Class.forName("com.mysql.jdbc.Driver");
			
			//연결
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userdb","root","");
			
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
    
    public List<회원> 모든회원목록을모으다(){
    	ArrayList<회원> 회원들 = new ArrayList<회원>();
    	//
//    	회원 회원1 = new 회원();
//    	회원1.set성명("홍길동");
//    	회원1.set전화("01055371123");
//    	
//    	회원 회원2 = new 회원();
//    	회원2.set성명("황길동");
//    	회원2.set전화("01055373344");
//    	
//    	회원들.add(회원1);
//    	회원들.add(회원2);
//
//    	return 회원들;
    	String 질의SQL문 = "select * from 회원";
    	
		try {
			//연결준비
			Class.forName("com.mysql.jdbc.Driver");
			
			//연결
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userdb","root","");
			
			Statement st = con.createStatement();
		
			ResultSet 회원행들= st.executeQuery(질의SQL문);
			
			while(회원행들.next()) {
				
				int 번호 = 회원행들.getInt("번호");
				String 성명 = 회원행들.getString("성명");
				String 전화 = 회원행들.getString("전화");
				
				
				//회원 객체로 변환
				회원 한회원 = new 회원();
				한회원.set번호(번호);
				한회원.set성명(성명);
				한회원.set전화(전화);
				
				회원들.add(한회원);
				
			}
			회원행들.close();
			
			
			
			//연결x
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    	
    	return 회원들;
    	
    }

}