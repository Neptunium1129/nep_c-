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
import 영화관리.영화;
import 영화관리.영화관리자;
import 회원관리.회원;
import 회원관리.회원관리자;

public class 영화선택창 extends JDialog {
	영화관리자 한영화관리자 = new 영화관리자();
	영화선택창 영화선택창self;
	JTable 영화목록표;
	List<영화> 영화들;
	대여반납창 부모대여반납창;
	public 영화선택창(대여반납창 부모대여반납창,String 유사영화명) {
		super(부모대여반납창,true);
		영화선택창self=this;
		this.부모대여반납창=부모대여반납창;
		this.setTitle("영화 선택");
		this.setLayout(null);
		//this.setSize(600, 600);
	    this.setBounds(500, 100, 400, 400);	
	    초기화하다();
	    영화들을출력하다(유사영화명);
	}
	
	private void 초기화하다() {
		
		   DefaultTableModel 테이블모델 = new NonEditableTableModel(); 
		   테이블모델.addColumn("영화번호");
		   테이블모델.addColumn("영화명");
		   테이블모델.addColumn("장르");
		   테이블모델.addColumn("감독");
		   테이블모델.addColumn("주연");
		
	   	//
		   영화목록표=new JTable(테이블모델);
		   영화목록표.setFillsViewportHeight(true);
		   영화목록표.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	   	//
	   	JScrollPane 주소목록판=new JScrollPane(영화목록표);
	   	주소목록판.setBounds(10, 10, 360, 340);
	   	this.add(주소목록판);
	 
	   	
	   	영화목록표.addMouseListener(new MouseAdapter() {
	   		
	   		@Override
	   		public void mouseClicked(MouseEvent e) {
				
				int 선택된행 = 영화목록표.getSelectedRow();
				
				if(e.getClickCount()==2) {
					DefaultTableModel 테이블모델 = (DefaultTableModel)영화목록표.getModel();
					부모대여반납창.영화를받다(영화들.get(선택된행));
					영화선택창self.dispose();

					
				}
				
			}
	   		
		});
			
			
		
		
	}
	
	private void 영화들을출력하다(String 유사영화명) {
		영화들=한영화관리자.영화를조회하다By제목(유사영화명);
		DefaultTableModel 테이블모델= (DefaultTableModel) 영화목록표.getModel();
		for(영화 한영화:영화들) {
			Object[] 행 = {한영화.get번호(),한영화.get제목(),한영화.get장르().get이름(),한영화.get감독(),한영화.get주연()};

				테이블모델.addRow(행);
		
		}
		
	}
	

}
