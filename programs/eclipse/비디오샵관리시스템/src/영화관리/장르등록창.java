package 영화관리;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import util.Result;
import util.텍스트필드제한;

public class 장르등록창 extends JDialog {
	장르등록창 장르등록창self;
	JLabel 장르라벨;
	JTextField 장르필드;
	JButton 등록버튼, 닫기버튼;
	
	public 장르 등록된장르=null;
	public 장르등록창() {
		초기화하다();
	}

	public 장르등록창(JFrame 부모) {
		super(부모, true);
		장르등록창self = this;
		// this.setBounds(100, 150, 500,500);
		초기화하다();

	}

	private void 초기화하다() {
		this.setTitle("장르등록");
		this.setLayout(null);
		// this.setSize(600, 600);
		this.setBounds(600, 100, 600, 300);

		장르라벨 = new JLabel("장르");
		장르라벨.setBounds(30, 30, 100, 30);
		this.add(장르라벨);

		장르필드 = new JTextField();
		장르필드.setDocument(new 텍스트필드제한(10));
		장르필드.setBounds(200, 30, 100, 30);
		this.add(장르필드);

		등록버튼 = new JButton("등록");
		등록버튼.setBounds(200, 150, 100, 30);
		this.add(등록버튼);

		닫기버튼 = new JButton("닫기");
		닫기버튼.setBounds(200, 200, 100, 30);
		this.add(닫기버튼);

		등록버튼.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				등록하다();
			}
		});

		닫기버튼.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				장르등록창self.dispose();

			}
		});
		
	

	}

	private void 등록하다() {
		등록된장르 = null;
		String 장르 = 장르필드.getText();
		
		if(장르.trim().length()==0) {
			JOptionPane.showMessageDialog(장르등록창self, "장르명은 필수 입력입니다.","에러",JOptionPane.OK_OPTION);
			return;
		}
		
		장르 새장르 = new 장르();
		새장르.set이름(장르);

		장르관리 한장르관리 = new 장르관리();
		Result 결과 = 한장르관리.등록하다(새장르);
		if(결과.resultCode!=1) {
			JOptionPane.showMessageDialog(장르등록창self, 결과.message,"에러",JOptionPane.OK_OPTION);
			return;
		}
		등록된장르=새장르;
		JOptionPane.showMessageDialog(장르등록창self,"등록되었습니다.","등록됨",JOptionPane.OK_OPTION);
		
		장르등록창self.dispose();


	}

}
