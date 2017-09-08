package 대여반납관리;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import util.NonEditableTableModel;
import 회원관리.회원;
import 회원관리.회원관리자;

public class 회원선택창 extends JDialog {
	회원관리자 한회원관리 = new 회원관리자();
	회원선택창 회원선택창self;
	JTable 회원목록표;
	List<회원> 회원들;
	대여반납창 부모대여반납창;
	public 회원선택창(대여반납창 부모대여반납창,String 회원이름,String 전화) {
		super(부모대여반납창,true);
		//왜 굳이 수퍼를 줬을까
		회원선택창self=this;
		this.부모대여반납창=부모대여반납창;
		this.setTitle("회원 선택");
		this.setLayout(null);
		//this.setSize(600, 600);
	    this.setBounds(500, 100, 400, 400);	
	     초기화하다();
	     회원들을출력하다(회원이름,전화);
	}
	
	private void 초기화하다() {
		
		   DefaultTableModel 테이블모델 = new NonEditableTableModel(); 
		   테이블모델.addColumn("성명");
		   테이블모델.addColumn("전화");
		
	   	//
		   회원목록표=new JTable(테이블모델);
		   회원목록표.setFillsViewportHeight(true);
		   회원목록표.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	   	//
	   	JScrollPane 주소목록판=new JScrollPane(회원목록표);
	   	주소목록판.setBounds(10, 10, 360, 340);
	   	this.add(주소목록판);
		
	   	
		회원목록표.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int 선택된행 = 회원목록표.getSelectedRow();
				
				if(e.getClickCount()==2) {
					DefaultTableModel 테이블모델 = (DefaultTableModel)회원목록표.getModel();
					부모대여반납창.회원을받다(회원들.get(선택된행));
					회원선택창self.dispose();
					
				}
				
			}
			
		});
		}
	
	
	private void 회원들을출력하다(String 회원이름, String 전화번호) {
		회원들=한회원관리.회원을조회하다By성명_전화번호(회원이름, 전화번호);
		DefaultTableModel 테이블모델= (DefaultTableModel) 회원목록표.getModel();
		for(회원 한회원:회원들) {
			Object[] 행 = {한회원.get성명(),한회원.get전화()};

				테이블모델.addRow(행);
		
		}
		
	}
	
	
	
	
	

}
