package 윈도우메뉴;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class 메인창 extends JFrame {
	
	public 메인창() {
		this.setTitle("메인메뉴창");
	this.setLayout(null);
	this.setSize(500,500);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	메뉴초기화하다();
	}
	
	private void 메뉴초기화하다() {
		
		JMenuBar 메뉴바 = new JMenuBar();
		this.setJMenuBar(메뉴바);
		
		JMenu 메뉴1 = new JMenu("메뉴1");
		메뉴바.add(메뉴1);
		
		JMenuItem 아이템1 = new JMenuItem("아이템1");
		메뉴1.add(아이템1);
		메뉴1.addSeparator();
		
		아이템1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("메뉴아이템1");
			}
		});

		JMenuItem 아이템2 = new JMenuItem("아이템2");
		메뉴1.add(아이템2);
		메뉴1.addSeparator();

		
		JMenu 메뉴2 = new JMenu("메뉴2");
		메뉴1.add(메뉴2);
		JMenuItem 아이템3 = new JMenuItem("아이템3");
		메뉴2.add(아이템3);
		아이템3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("아이템3");
			}
		});
		
	}
	
}
