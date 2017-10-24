package com.celab.membermanage_dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.celab.addressmanage_common.ZipAddress;
import com.celab.article_common.Article;
import com.celab.article_dataservice.데이터설정;
import com.celab.membermanage_common.Member;

@Repository
public class MemberDAO {

	
	public int 저장하다(Member 회원) {
	int 결과 = 0 ;
/*
 *   no int,
  name varchar2(20),
  telephone varchar2(20),
  zipcode char(5),
  zipaddress varchar2(20),
  detailaddress varchar2(20),
  id varchar2(20),
  password varchar2(20),
  hobby varchar2(20),
  email  varchar2(20)
 */
		//select * from article where no=#{게시물번호}
		String sql = String.format("insert into board_member(no,name,telephone,zipcode,zipaddress,detailaddress,id,password,hobby,email)"
				+ "values(sql_member.nextval,'%s','%s','%s','%s','%s','%s','%s','%s','%s')"
		,회원.getName()
		,회원.getTelephone()
		,회원.getAddress().getZipcode()
		,회원.getAddress().getAddress()
		,회원.getDetailAddress()
		,회원.getId()
		,회원.getPassword()
		,회원.getHobby()
		,회원.getEmail()
		);
		System.out.println(sql);
		try {
			//연결준비
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//연결
			Connection con = DriverManager.getConnection(데이터설정.연결문자열,데이터설정.ID,데이터설정.Password);
			
			Statement st = con.createStatement();
		
			int result= st.executeUpdate(sql);
			
			if(result==1) {
				결과 = 1;
			}else {
				결과 = 2;
			}
				
			//연결x
			con.close();
		}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				결과 = 3;
			}

		return 결과;
	}

	
	public static boolean 존재하는가(String ID, String password) {
		boolean 존재 = false;
		//select * from article where no=#{게시물번호}
		String sql = String.format("select count(no) as cnt from board_member where id='%s' and password='%s'",ID,password);
		try {
			//연결준비
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//연결
			Connection con = DriverManager.getConnection(데이터설정.연결문자열,데이터설정.ID,데이터설정.Password);
			
			Statement st = con.createStatement();
		
			ResultSet 게시물행= st.executeQuery(sql);
			
			while(게시물행.next()) {
				
				int cnt = 게시물행.getInt("cnt");
				if(cnt>0) {
					존재= true;
				}
				
				
			}
		
			게시물행.close();
			//연결x
			con.close();
		}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
		
		
		
		return 존재;
	}

	public static boolean ID존재여부(String ID) { //id중복검사때 
		boolean 존재 = false;

		//select * from article where no=#{게시물번호}
		String sql = String.format("select count(id) as cnt from board_member where id='%s'",ID);
		try {
			//연결준비
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//연결
			Connection con = DriverManager.getConnection(데이터설정.연결문자열,데이터설정.ID,데이터설정.Password);
			
			Statement st = con.createStatement();
		
			ResultSet 게시물행= st.executeQuery(sql);
			
			while(게시물행.next()) {
				
				int cnt = 게시물행.getInt("cnt");
				if(cnt>0) {
					존재= true;
				}
				
				
			}
		
			게시물행.close();
			//연결x
			con.close();
		}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
		
		return 존재;
	}
	
	public Member 수집하다회원ByID(String id) {
		Member 새회원 = null;
		String sql = String.format("select * from board_member where id='%s'", id);
		try {
			//연결준비
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//연결
			Connection con = DriverManager.getConnection(데이터설정.연결문자열,데이터설정.ID,데이터설정.Password);
			
			Statement st = con.createStatement();
		
			ResultSet 게시물행= st.executeQuery(sql);
			
			while(게시물행.next()) {
				
			
				int no = 게시물행.getInt("no");
				String name = 게시물행.getString("name");
				String telephone = 게시물행.getString("telephone");
				String zipcode = 게시물행.getString("zipcode");
				String zipaddress = 게시물행.getString("zipaddress");
				String detailaddress = 게시물행.getString("detailaddress");
				String sid = 게시물행.getString("id");
				String password = 게시물행.getString("password");
				String hobby = 게시물행.getString("hobby");
				String email = 게시물행.getString("email");
				
				ZipAddress zipAddress = new ZipAddress();
				zipAddress.setZipcode(zipcode);
				zipAddress.setAddress(zipaddress);
				
				새회원= new Member();
				새회원.setNo(no);
				새회원.setName(name);
				새회원.setTelephone(telephone);
				새회원.setAddress(zipAddress);
				새회원.setDetailAddress(detailaddress);
				새회원.setId(sid);
				새회원.setPassword(password);
				새회원.setHobby(hobby);
				새회원.setEmail(email);
				
				
				
			}
		
			게시물행.close();
			//연결x
			con.close();
		}catch (Exception e) {
				e.printStackTrace();
			}
		
	return 새회원;	
	}


	public Member 수집하다회원By회원번호(int 작성자번호) {
		Member 새회원 = null;
		String sql = String.format("select * from board_member where no=%d", 작성자번호);
		try {
			//연결준비
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//연결
			Connection con = DriverManager.getConnection(데이터설정.연결문자열,데이터설정.ID,데이터설정.Password);
			
			Statement st = con.createStatement();
		
			ResultSet 게시물행= st.executeQuery(sql);
			
			while(게시물행.next()) {
				
			
				String name = 게시물행.getString("name");
				String telephone = 게시물행.getString("telephone");
				String zipcode = 게시물행.getString("zipcode");
				String zipaddress = 게시물행.getString("zipaddress");
				String detailaddress = 게시물행.getString("detailaddress");
				String sid = 게시물행.getString("id");
				String password = 게시물행.getString("password");
				String hobby = 게시물행.getString("hobby");
				String email = 게시물행.getString("email");
				
				ZipAddress zipAddress = new ZipAddress();
				zipAddress.setZipcode(zipcode);
				zipAddress.setAddress(zipaddress);
				
				새회원= new Member();
				새회원.setName(name);
				새회원.setTelephone(telephone);
				새회원.setAddress(zipAddress);
				새회원.setDetailAddress(detailaddress);
				새회원.setId(sid);
				새회원.setPassword(password);
				새회원.setHobby(hobby);
				새회원.setEmail(email);
				
				
				
			}
		
			게시물행.close();
			//연결x
			con.close();
		}catch (Exception e) {
				e.printStackTrace();
			}
		
	return 새회원;	
	}

}
