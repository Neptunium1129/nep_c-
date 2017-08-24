package 회원관리;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class 회원목록창 extends JFrame {
	
	JTable 회원목록표;
	JButton 목록출력버튼,목록초기화버튼;

   public 회원목록창() {
		//프레임 초기화
		this.setTitle("회원 목록");
		this.setLayout(null);
		//this.setSize(600, 600);
	    this.setBounds(200, 200, 650, 650);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		초기화하다();
   }
   
   
   private void 초기화하다() {
	   
	   목록출력버튼 = new JButton("목록출력");
	   목록출력버튼.setBounds(300, 300, 120, 45);
	   add(목록출력버튼);
	   
	   목록초기화버튼 = new JButton("초기화");
	   목록초기화버튼.setBounds(300, 350, 120, 45);
	   add(목록초기화버튼);
	   
	   
	   목록초기화버튼.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			초기화하다();
		}
	});
	   
	   목록출력버튼.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			회원관리자 한회원관리자 = new 회원관리자();
			List<회원> 회원들 = 한회원관리자.회원목록을수집하다();
			int total = 회원들.size();
			System.out.println(total);
			// TODO Auto-generated method stub
			//테이블로 부터 테이블모델 얻기
			DefaultTableModel 테이블모델 = (DefaultTableModel) 회원목록표.getModel();
			
			for(회원 한회원:회원들) {
				Object[] 행 = {한회원.get번호(),한회원.get성명(),한회원.get전화()};

					테이블모델.addRow(행);
			
			}
			System.out.println(회원들.size());

			
			
			//Object[] 행 = {1,"가길동", "111"};
			
			//테이블모델에 행 데이터 추가
			//테이블모델.addRow(행);
					
		
		}
	});
	   
	   DefaultTableModel 테이블모델 = new DefaultTableModel(); 
	   테이블모델.addColumn("번호");
	   테이블모델.addColumn("성명");
	   테이블모델.addColumn("전화");
   	//
	   회원목록표=new JTable(테이블모델);
	   회원목록표.setFillsViewportHeight(true);
	   회원목록표.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   	//
   	JScrollPane 주소목록판=new JScrollPane(회원목록표);
   	주소목록판.setBounds(10, 50, 380, 240);
   	add(주소목록판);
	   
	   //테이블과 모델의 설계는 나누어져있다.
   	// 제작자가 어떤 상황에 대비하여 미리 나누고 구조와 뷰를 나누었을것으로 추측된다.
   }
   

	
	
}