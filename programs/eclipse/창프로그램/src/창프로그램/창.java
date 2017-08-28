package 창프로그램;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class 창 extends JFrame{
	JLabel 성명라벨;
	JTextField 성명필드;	
	
	//예시 컴포넌트들  
	JButton 등록버튼;
	JTextField 메일필드;
	JLabel 골라벨;
	JComboBox 메일회사콤보;
	JRadioButton 남라디오버튼;
	JRadioButton 여라디오버튼;
	JCheckBox 취미_잠체크박스;
	JCheckBox 취미_수면체크박스;
	JCheckBox 취미_취침체크박스;
	JTextArea 비고사항텍스트애리어;

	public 창() {
		this.setTitle("회원등록");
		this.setLayout(null);
		this.setSize(500, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		초기화하다();
	}
	
	private void 초기화하다() {
		성명필드=new JTextField();
		성명필드.setBounds(100,20,80,30);
		this.add(성명필드);
		
		//JTextField======================================
		메일필드=new JTextField();
		메일필드.setBounds(100,120,80,30);
		this.add(메일필드);
		
		//JLabel=========================================
		골라벨=new JLabel("@");
		골라벨.setBounds(180,120,20,30);
		this.add(골라벨);
		
		//JComboBox======================================
		메일회사콤보=new JComboBox();
		메일회사콤보.setBounds(195,120,100,30);		
		메일회사콤보.addItem("daum.net");
		메일회사콤보.addItem("naver.com");
		메일회사콤보.addItem("aaa.com");
		메일회사콤보.addItem("bbb.com");
		메일회사콤보.setSelectedIndex(1);
		this.add(메일회사콤보);		
		
		//JRadioButton======================================
		//..groupbox style.........................
		JPanel box = new JPanel();
		box.setLayout(null);
		box.setBounds(100, 180, 140, 70);
		box.setBorder(BorderFactory.createTitledBorder("성별"));
		this.add(box);
		//JRadioButton
		ButtonGroup  성별버튼그룹 = new ButtonGroup(); 
		남라디오버튼=new JRadioButton("남");
		남라디오버튼.setBounds(10, 25, 60,30);
		성별버튼그룹.add(남라디오버튼);
		box.add(남라디오버튼);
		남라디오버튼.setSelected(true);
		//
		여라디오버튼=new JRadioButton("여");
		여라디오버튼.setBounds(70, 25, 60,30);
		성별버튼그룹.add(여라디오버튼);		
		box.add(여라디오버튼);			
		
		//JCheckBox======================================
		취미_잠체크박스=new JCheckBox("잠");
		취미_잠체크박스.setBounds(100, 270, 60,30);
		this.add(취미_잠체크박스);
		
		취미_수면체크박스=new JCheckBox("수면");
		취미_수면체크박스.setBounds(170, 270, 60,30);
		this.add(취미_수면체크박스);
		
		취미_취침체크박스=new JCheckBox("취침");
		취미_취침체크박스.setBounds(240, 270, 60,30);
		취미_취침체크박스.setSelected(true);
		this.add(취미_취침체크박스);
		
		//JTexArea======================================
		비고사항텍스트애리어=new JTextArea();
		비고사항텍스트애리어.setBounds(100, 320, 200, 150);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		비고사항텍스트애리어.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		this.add(비고사항텍스트애리어);
		
		//JButton======================================= 
		등록버튼=new JButton("등록");
		등록버튼.setBounds(300, 20, 80, 30);
		this.add(등록버튼);
		등록버튼.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}