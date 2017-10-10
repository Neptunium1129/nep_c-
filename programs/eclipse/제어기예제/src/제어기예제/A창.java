package 제어기예제;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A창 extends JFrame {

	JButton A창버튼;
	public A창() {
		this.setTitle("A창");
		this.setLayout(null);
		this.setBounds(100, 100, 500, 500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		A창버튼 = new JButton("A창버튼");
		A창버튼.setBounds(50, 50, 100, 30);
		this.add(A창버튼);
		
		A창버튼.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				프로그램.한제어기.처리하다("B작업준비");
			}
		});
	
	}

}
