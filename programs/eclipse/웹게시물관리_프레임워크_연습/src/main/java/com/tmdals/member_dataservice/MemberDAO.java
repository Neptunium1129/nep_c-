package com.tmdals.member_dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.tmdals.address_common.ZipAddress;
import com.tmdals.common.Datasetting;
import com.tmdals.member_common.Member;

@Repository
public class MemberDAO {

	public static Boolean Login_process(String ID, String Password) {
		boolean check = false;
		
		String sql = String.format("Select count(no) as cnt from board_member where id='%s' and password='%s'",ID,Password);
		try {
			//연결준비
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//연결
			Connection con = DriverManager.getConnection(Datasetting.path,Datasetting.ID,Datasetting.Password);
			
			Statement st = con.createStatement();
		
			ResultSet rs= st.executeQuery(sql);
			
			while(rs.next()) {
				
				int cnt = rs.getInt("cnt");
				if(cnt>0) {
					check= true;
				}
				
				
			}
		
			rs.close();
			//연결x
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		
		
		return check;
	}

	public static int Register_process(Member member) {
		
		
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
				,member.getName()
				,member.getTelephone()
				,member.getAddress().getZipcode()
				,member.getAddress().getAddress()
				,member.getDetailAddress()
				,member.getId()
				,member.getPassword()
				,member.getHobby()
				,member.getEmail()
				);
				System.out.println(sql);
				try {
					//연결준비
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					//연결
					Connection con = DriverManager.getConnection(Datasetting.path,Datasetting.ID,Datasetting.Password);
					
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

	public static boolean Id_check(String id) {
		boolean check = false;

		//select * from article where no=#{게시물번호}
		String sql = String.format("select count(id) as cnt from board_member where id='%s'",id);
		try {
			//연결준비
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//연결
			Connection con = DriverManager.getConnection(Datasetting.path,Datasetting.ID,Datasetting.Password);
			
			Statement st = con.createStatement();
		
			ResultSet 게시물행= st.executeQuery(sql);
			
			while(게시물행.next()) {
				
				int cnt = 게시물행.getInt("cnt");
				if(cnt>0) {
					check= true;
				}
				
				
			}
		
			게시물행.close();
			//연결x
			con.close();
		}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
		
		return check;
	}

	public Member select_member_info(int 작성자번호) {
		Member 기존회원 = null;

		String sql = String.format("Select *  from board_member where no=%d",작성자번호);
		try {
			//연결준비
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//연결
			Connection con = DriverManager.getConnection(Datasetting.path,Datasetting.ID,Datasetting.Password);
			
			Statement st = con.createStatement();
		
			ResultSet rs= st.executeQuery(sql);
			
			while(rs.next()) {
				

				int no = rs.getInt("no");
				String name = rs.getString("name");
				String telephone = rs.getString("telephone");
				String zipcode = rs.getString("zipcode");
				String zipaddress = rs.getString("zipaddress");
				String detailaddress = rs.getString("detailaddress");
				String sid = rs.getString("id");
				String password = rs.getString("password");
				String hobby = rs.getString("hobby");
				String email = rs.getString("email");
				
				ZipAddress zipAddress = new ZipAddress();
				zipAddress.setZipcode(zipcode);
				zipAddress.setAddress(zipaddress);
				
				기존회원= new Member();
				기존회원.setNo(no);
				기존회원.setName(name);
				기존회원.setTelephone(telephone);
				기존회원.setAddress(zipAddress);
				기존회원.setDetailAddress(detailaddress);
				기존회원.setId(sid);
				기존회원.setPassword(password);
				기존회원.setHobby(hobby);
				기존회원.setEmail(email);
				
			}
		
			rs.close();
			//연결x
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		
		
		
		return 기존회원;
	}

}
