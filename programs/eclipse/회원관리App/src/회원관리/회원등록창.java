package 회원관리;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class 회원등록창 extends JFrame {
	회원등록창 self;
	
	JLabel 성명라벨;
	JLabel 전화라벨;
	
	JTextField 성명필드;
	JTextField 전화필드;
	JButton 등록버튼;
	
   public 회원등록창() {
	   self=this;
		//프레임 초기화
		this.setTitle("회원 등록");
		this.setLayout(null);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		초기화하다();
   }
   
   
   private void 초기화하다() {
	   
	   성명라벨 = new JLabel("성명");
	   성명라벨.setBounds(30, 30, 100, 30);
	   this.add(성명라벨);
	   
	   성명필드 = new JTextField();
	   성명필드.setBounds(200, 30,100, 30);
	   this.add(성명필드);
	   
	   전화라벨 = new JLabel("전화");
	   전화라벨.setBounds(30, 70, 100, 30);
	   this.add(전화라벨);
	   
	   전화필드 = new JTextField();
	   전화필드.setBounds(200, 70,100, 30);
	   this.add(전화필드);
	   
	   등록버튼 = new JButton("등록");
	   등록버튼.setBounds(200, 150, 100, 30);
	   this.add(등록버튼);
	   
	   등록버튼.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			등록하다();
			
		}
	});
		
		

	   
   }
   
   private void 등록하다() {
	   
	   String 성명 = 성명필드.getText();
	   String 전화 = 전화필드.getText();
	   
	   회원 새회원 = new 회원();
	   새회원.set성명(성명);
	   새회원.set전화(전화);
	   
	   회원관리자 한회원관리자 = new 회원관리자();
	   한회원관리자.등록하다(새회원);
	   
   }
	
	
}
