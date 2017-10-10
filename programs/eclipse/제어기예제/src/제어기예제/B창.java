package 제어기예제;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class B창 extends JFrame {
	JButton B창버튼;
	public B창() {
		this.setTitle("B창");
		this.setLayout(null);
		this.setBounds(300, 150, 500, 500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		B창버튼 = new JButton("b창버튼");
		B창버튼.setBounds(70, 50, 100, 30);
		this.add(B창버튼);
		
		B창버튼.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				프로그램.한제어기.처리하다("B등록");
			}
		});
	
	}
	

}
