package 대여반납관리;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import util.NonEditableTableModel;
import 영화관리.영화;
import 테입관리.테입;
import 테입관리.테입관리;
import 회원관리.회원;

public class 테입선택창 extends JDialog {
	테입관리 한테입관리자 = new 테입관리();
	테입선택창 테입선택창self;
	JTable 테입목록표;
	List<테입> 테입들;
	대여반납창 부모대여반납창;
	public 테입선택창(대여반납창 부모대여반납창,int 영화번호,String 영화명) {
		super(부모대여반납창,true);

		테입선택창self=this;
		this.부모대여반납창=부모대여반납창;
		this.setTitle("테입 선택");
		this.setLayout(null);
		//this.setSize(600, 600);
	    this.setBounds(500, 100, 400, 400);	
	    초기화하다();
	 	테입들을출력하다(영화번호,영화명);
	 	System.out.println("#"+영화번호);
	}
	
	private void 초기화하다() {
		
		   DefaultTableModel 테이블모델 = new NonEditableTableModel(); 
		   테이블모델.addColumn("영화번호");
		   테이블모델.addColumn("영화명");
		   테이블모델.addColumn("테입번호");
		   테이블모델.addColumn("테입상태");
		  
		
	   	//
		   테입목록표=new JTable(테이블모델);
		   테입목록표.setFillsViewportHeight(true);
		   테입목록표.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	   	//
	   	JScrollPane 주소목록판=new JScrollPane(테입목록표);
	   	주소목록판.setBounds(10, 10, 360, 340);
	   	this.add(주소목록판);
	   	
	  
	   	테입목록표.addMouseListener(new MouseAdapter() {
	   		
	   		@Override
	   		public void mouseClicked(MouseEvent e) {
				
				int 선택된행2 = 테입목록표.getSelectedRow();
				
				if(e.getClickCount()==2) {
					DefaultTableModel 테이블모델 = (DefaultTableModel)테입목록표.getModel();
					//부모대여반납창.테입을받다(테입들.get(선택된행2));
					System.out.println(테입들.get(선택된행2).get번호());
					부모대여반납창.테입을받다(테입들.get(선택된행2));
					테입선택창self.dispose();

				}
				
			}
	   		
		});
			
		
		
	}
	private void 테입들을출력하다(int 영화번호 ,String 영화명) {
		System.out.println("테입출력"+영화번호+영화명);
		테입들=한테입관리자.테입을조회하다By영화번호(영화번호);
		DefaultTableModel 테이블모델= (DefaultTableModel) 테입목록표.getModel();
		for(테입 한테입:테입들) {
			Object[] 행 = {한테입.get영화().get번호(),한테입.get영화().get제목(),한테입.get번호(),한테입.get상태().toString()};
			
				테이블모델.addRow(행);
		
		}
		
	}
	
	

}
