package 대여반납관리;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import 영화관리.영화;
import 테입관리.테입;
import 테입관리.테입관리;
import 회원관리.회원;

public class 테입선택창 extends JDialog {
	테입관리 한테입관리자 = new 테입관리();
	테입선택창 테입선택창self;
	JTable 테입목록표;
	List<테입> 테입들;
	영화선택창 부모영화선택창;
	public 테입선택창(영화선택창 부모영화선택창, int 영화번호) {
		테입선택창self=this;
		this.부모영화선택창=부모영화선택창;
		this.setTitle("테입 선택");
		this.setLayout(null);
		//this.setSize(600, 600);
	    this.setBounds(500, 100, 400, 400);	
	    초기화하다();
	}
	
	private void 초기화하다() {
		
		   DefaultTableModel 테이블모델 = new DefaultTableModel(); 
		   테이블모델.addColumn("영화번호");
		   테이블모델.addColumn("영화명");
		   테이블모델.addColumn("테입번호");
		  
		
	   	//
		   테입목록표=new JTable(테이블모델);
		   테입목록표.setFillsViewportHeight(true);
		   테입목록표.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	   	//
	   	JScrollPane 주소목록판=new JScrollPane(테입목록표);
	   	주소목록판.setBounds(10, 10, 360, 340);
	   	this.add(주소목록판);
		
		
	}
	private void 테입들을출력하다(int 영화번호) {
		테입들=한테입관리자.테입을조회하다By영화번호(영화번호);
		DefaultTableModel 테이블모델= (DefaultTableModel) 테입목록표.getModel();
		for(테입 한테입:테입들) {
			Object[] 행 = {한테입.get영화().get번호(),한테입.get영화().get제목(),한테입.get번호()};

				테이블모델.addRow(행);
		
		}
		
	}
	
	

}
