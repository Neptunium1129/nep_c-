package com.tmdals.daerim_dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;


import com.tmdals.common.Datasetting;
import com.tmdals.daerim_common.commentDTO;
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
				대림DAO 대림dao = new 대림DAO();
				int 댓글갯수 = 대림dao.댓글갯수(번호);
				
				
				//회원 객체로 변환
				daerimDTO 한게시물 = new daerimDTO();
				한게시물.setNo(번호);
				한게시물.setTitle(제목);
				한게시물.setContents(내용);
				한게시물.setWriter(저자);
				한게시물.setPrice(가격);
				한게시물.setMakeday(발행일);
				한게시물.setImg(사진);
				한게시물.setComment_cnt(댓글갯수);
				
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

	public void 책등록하다(daerimDTO drdto) {

		String sql=String.format("insert into daerim (no,title,contents,makeday,writer,price,img) "
				+ "values(sql_daerim.nextval,'%s','%s','%s','%s','%s','%s')",drdto.getTitle(),drdto.getContents(),drdto.getMakeday(),drdto.getWriter(),drdto.getPrice(),drdto.getImg());
		System.out.println(sql);
		try {
			//연결준비
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//연결
			Connection con = DriverManager.getConnection(Datasetting.path,Datasetting.ID,Datasetting.Password);
			
			Statement st = con.createStatement();
		
			st.executeUpdate(sql);

			
			//연결x
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	
		
		
		
	}

	public void 댓글저장하다(commentDTO comment_DTO) {
		String sql=String.format("insert into d_comment (c_id,p_id,c_writer,c_contents)"
				+ "values(sql_daerim.nextval,%d,'%s','%s')",comment_DTO.getP_id(),comment_DTO.getC_writer(),comment_DTO.getC_contents());
		System.out.println(sql);
		try {
			//연결준비
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//연결
			Connection con = DriverManager.getConnection(Datasetting.path,Datasetting.ID,Datasetting.Password);
			
			Statement st = con.createStatement();
		
			st.executeUpdate(sql);

			
			//연결x
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public List<commentDTO> 댓글리스트가져오기(int board_num) {
	
		ArrayList<commentDTO> comment = new ArrayList<commentDTO>();
		String sql=String.format("select * from d_comment where p_id=%d",board_num);		
		System.out.println(sql);
		try {
			//연결준비
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//연결
			Connection con = DriverManager.getConnection(Datasetting.path,Datasetting.ID,Datasetting.Password);
			
			Statement st = con.createStatement();
		
			ResultSet 게시물행= st.executeQuery(sql);
			
			
			while(게시물행.next()) {
				
				int 게시글번호 = 게시물행.getInt("p_id");
				int 댓글번호 = 게시물행.getInt("c_id");
				String 작성자 = 게시물행.getString("c_writer");
				String 내용 = 게시물행.getString("c_contents");
			
				
				//회원 객체로 변환
				commentDTO 한댓글 = new commentDTO();
				한댓글.setP_id(게시글번호);
				한댓글.setC_id(댓글번호);
				한댓글.setC_contents(내용);
				한댓글.setC_writer(작성자);
			
				comment.add(한댓글);
			}
			게시물행.close();
			//연결x
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

		return comment;
	}

	public int 댓글갯수(int no) {
		int 갯수 = 0;
		String sql=String.format("select count(*) as cnt from d_comment where p_id=%d",no);		
		System.out.println(sql);
		try {
			//연결준비
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//연결
			Connection con = DriverManager.getConnection(Datasetting.path,Datasetting.ID,Datasetting.Password);
			
			Statement st = con.createStatement();
		
			ResultSet 게시물행= st.executeQuery(sql);
			
			
			while(게시물행.next()) {
				
				갯수 = 게시물행.getInt("cnt");
			
			}
			게시물행.close();
			//연결x
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

		return 갯수;
	}

}
