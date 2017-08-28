package 회원관리;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class 회원정보변경창 extends JFrame {
		회원정보변경창 회원정보변경창self;
		JButton 조회버튼;
		JButton 등록버튼;
		JButton 변경버튼;
		
		JLabel 번호라벨;
		JLabel 성명라벨;
		JLabel 전화라벨;
		
		JTextField 번호필드;
		JTextField 성명필드;
		JTextField 전화필드;
		
	
	   public 회원정보변경창() {
		   회원정보변경창self=this;
			//프레임 초기화
			this.setTitle("회원 정보 변경");
			this.setLayout(null);
			this.setSize(500, 500);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			초기화하다();
	   }
	   
	   public void 초기화하다() {
		   
		   조회버튼 = new JButton("조회");
		   조회버튼.setBounds(200, 50, 80, 30);
		   this.add(조회버튼);
		   
		   변경버튼 = new JButton("전화변경");
		   변경버튼.setBounds(300, 250, 150, 30);
		   this.add(변경버튼);
		   
		   등록버튼 = new JButton("등록");
		   등록버튼.setBounds(200, 120, 80, 30);
		   this.add(등록버튼);
		   
		   번호라벨 = new JLabel("번호");
		   번호라벨.setBounds(30, 150, 100, 30);
		   this.add(번호라벨);
		   
		   번호필드 = new JTextField();
		   번호필드.setBounds(100, 150,100, 30);
		  
		   번호필드.setEditable(false);
		   this.add(번호필드);
		   
		   성명라벨 = new JLabel("성명");
		   성명라벨.setBounds(30, 180, 100, 30);
		   this.add(성명라벨);
		   
		   성명필드 = new JTextField();
		   성명필드.setBounds(100, 180,100, 30);
		 //  성명필드.setEditable(false);
		   this.add(성명필드);
	   
		   전화라벨 = new JLabel("전화");
		   전화라벨.setBounds(30, 210, 100, 30);
		   this.add(전화라벨);
		   
		   전화필드 = new JTextField();
		   전화필드.setBounds(100, 210,100, 30);
		   this.add(전화필드);
	   
		   
		   등록버튼.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					회원등록창 한회원등록창 = new 회원등록창();
					한회원등록창.setVisible(true);
					
					
				}
			});
		   
		   조회버튼.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				회원목록창 한회원목록창 = new 회원목록창(회원정보변경창self);
				한회원목록창.setVisible(true);
				
				
			}
		});
		   
		   변경버튼.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			if(전화필드.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "비어있습니다.");
				return;
				
			}else if(전화필드.getText().length()>12) {
				
				JOptionPane.showMessageDialog(null, "12자가 넘습니다.");
				return;
			}
			
			else {
				변경하다();
				JOptionPane.showMessageDialog(null, "변경됬습니다.");
				return;
			}
				
				
				
			}
		});
	   }

	public void 받는다회원정보(int 번호, String 성명, String 전화) {
		// TODO Auto-generated method stub
		번호필드.setText(String.valueOf(번호));
		성명필드.setText(성명);
		전화필드.setText(전화);
		
	}
	
	   private void 변경하다() {
		   int 번호 =Integer.valueOf(번호필드.getText());
		  // String 대상번호 = String.valueOf(번호필드.getText());
		   String 성명 = 성명필드.getText();
		   String 전화 = 전화필드.getText();
		   
		   회원 변경회원 = new 회원();
		   
		   변경회원.set번호(번호);
		  // 변경회원.set대상번호(대상번호);
		   변경회원.set성명(성명);
		   변경회원.set전화(전화);
		   
		   회원관리자 한회원관리자 = new 회원관리자();
		   한회원관리자.변경하다(변경회원);
		   
	   }
	   

}
