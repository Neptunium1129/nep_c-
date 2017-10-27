package com.tmdals.daerim_dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.tmdals.common.Datasetting;
import com.tmdals.daerim_common.daerimDTO;

@Repository
public class 대림DAO {

	public List<daerimDTO> 가져오기() {
		ArrayList<daerimDTO> daerim = new ArrayList<daerimDTO>();
		String sql="select * from daerim";		
		
		try {
			//연결준비
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//연결
			Connection con = DriverManager.getConnection(Datasetting.path,Datasetting.ID,Datasetting.Password);
			
			Statement st = con.createStatement();
		
			ResultSet 게시물행= st.executeQuery(sql);
			
			
			while(게시물행.next()) {
				
				int 번호 = 게시물행.getInt("no");
				String 제목 = 게시물행.getString("title");
				String 내용 = 게시물행.getString("contents");
				String 가격 =게시물행.getString("price");
				String 저자 =게시물행.getString("writer");
				String 발행일 = 게시물행.getString("makeday");
				String 사진  = 게시물행.getString("img");
				
				//회원 객체로 변환
				daerimDTO 한게시물 = new daerimDTO();
				한게시물.setNo(번호);
				한게시물.setTitle(제목);
				한게시물.setContents(내용);
				한게시물.setWriter(저자);
				한게시물.setPrice(가격);
				한게시물.setMakeday(발행일);
				한게시물.setImg(사진);
	
				daerim.add(한게시물);
				
			}
			게시물행.close();
			
			
			
			//연결x
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	
		return daerim;
	}

	public daerimDTO 게시물조회(int no) {
		daerimDTO daerim = null;
		String sql=String.format("select * from daerim where no=%d",no);		
		System.out.println(sql);
		try {
			//연결준비
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//연결
			Connection con = DriverManager.getConnection(Datasetting.path,Datasetting.ID,Datasetting.Password);
			
			Statement st = con.createStatement();
		
			ResultSet 게시물행= st.executeQuery(sql);
			
			
			while(게시물행.next()) {
				
				int 번호 = 게시물행.getInt("no");
				String 제목 = 게시물행.getString("title");
				String 내용 = 게시물행.getString("contents");
				String 가격 =게시물행.getString("price");
				String 저자 =게시물행.getString("writer");
				String 발행일 = 게시물행.getString("makeday");
				String 사진  = 게시물행.getString("img");
				
				//회원 객체로 변환
				daerim = new daerimDTO();
				daerim.setNo(번호);
				daerim.setTitle(제목);
				daerim.setContents(내용);
				daerim.setWriter(저자);
				daerim.setPrice(가격);
				daerim.setMakeday(발행일);
				daerim.setImg(사진);
			}
			게시물행.close();
			
			
			
			//연결x
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	
		return daerim;
	}

}
