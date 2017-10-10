package 윈도우탭;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class 메인창 extends JFrame {
	
	JTabbedPane 탭팬;
	JPanel 주제1판넬;
	JPanel 주제2판넬;
	
	public 메인창() {
		this.setLayout(null);
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		탭팬 = new  JTabbedPane();
		탭팬.setBounds(50, 50, 200, 200);
		this.add(탭팬);
		초기화하다();
		
	}
	
	private void  초기화하다() {
		판넬1초기화하다();
		판넬2초기화하다();
		
	}
	private void 판넬1초기화하다() {
		주제1판넬 = new JPanel();
		주제1판넬.setLayout(null);
		탭팬.add("제1목", 주제1판넬);
		JButton 버튼1 = new JButton("버튼1");
		버튼1.setBounds(200,350,80,30);
		주제1판넬.add(버튼1);
		
		
	버튼1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("버튼1클릭");
		}
	});
		
	}
	private void 판넬2초기화하다() {
		주제2판넬 = new JPanel();
		주제2판넬.setLayout(null);
		탭팬.add("제2목", 주제2판넬);
		
	}
	
	
	

}
