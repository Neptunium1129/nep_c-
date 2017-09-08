package 영화관리;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class 장르Item {
	public 장르 장르;

	public 장르Item(장르 장르) {
		this.장르 = 장르;

	}

	@Override
	public String toString() {
		return 장르.get이름();
	}

}

public class 영화등록창 extends JFrame {
	영화등록창 영화등록창self;
	JLabel 제목라벨;
	JLabel 부제라벨;
	JLabel 감독라벨;
	JLabel 주연라벨;
	JLabel 개봉라벨;
	JLabel 장르라벨;

	JTextField 제목필드;
	JTextField 부제필드;
	JTextField 감독필드;
	JTextField 주연필드;
	JTextField 개봉필드;
	JComboBox 장르콤보;

	JButton 영화등록버튼, 장르등록버튼, 닫기버튼;

	public 영화등록창() {
		영화등록창self = this;
		this.setTitle("영화 등록");
		this.setLayout(null);
		this.setBounds(100, 100, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		초기화하다();

	}

	private void 초기화하다() {

		제목라벨 = new JLabel("제목");
		제목라벨.setBounds(80, 60, 30, 20);
		this.add(제목라벨);
		부제라벨 = new JLabel("부제");
		부제라벨.setBounds(80, 100, 30, 20);
		this.add(부제라벨);
		감독라벨 = new JLabel("감독");
		감독라벨.setBounds(80, 132, 30, 20);
		this.add(감독라벨);
		주연라벨 = new JLabel("주연");
		주연라벨.setBounds(80, 170, 30, 20);
		this.add(주연라벨);
		개봉라벨 = new JLabel("개봉");
		개봉라벨.setBounds(80, 205, 30, 20);
		this.add(개봉라벨);
		장르라벨 = new JLabel("장르");
		장르라벨.setBounds(80, 245, 30, 20);
		this.add(장르라벨);

		제목필드 = new JTextField();
		제목필드.setBounds(150, 55, 180, 25);
		this.add(제목필드);
		부제필드 = new JTextField();
		부제필드.setBounds(150, 94, 140, 25);
		this.add(부제필드);
		감독필드 = new JTextField();
		감독필드.setBounds(150, 127, 140, 25);
		this.add(감독필드);
		주연필드 = new JTextField();
		주연필드.setBounds(150, 164, 140, 25);
		this.add(주연필드);
		개봉필드 = new JTextField();
		개봉필드.setBounds(150, 200, 140, 25);
		this.add(개봉필드);

		장르콤보 = new JComboBox();
		장르콤보.setBounds(140, 245, 120, 25);

		// 장르콤보.addItem(한장르.get번호());
		this.add(장르콤보);

		영화등록버튼 = new JButton("영화등록");
		영화등록버튼.setBounds(90, 300, 100, 30);
		this.add(영화등록버튼);

		장르등록버튼 = new JButton("장르등록");
		장르등록버튼.setBounds(260, 245, 100, 30);
		this.add(장르등록버튼);

		닫기버튼 = new JButton("닫기");
		닫기버튼.setBounds(210, 300, 100, 30);
		this.add(닫기버튼);

		영화등록버튼.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				등록하기();
			}
		});
		장르등록버튼.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				장르등록창 장르등록창 = new 장르등록창(영화등록창self);
				장르등록창.setVisible(true);
				장르를출력하다(장르등록창.등록된장르);

			}
		});

		닫기버튼.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				영화등록창self.dispose();

			}
		});

		장르를출력하다(null);
	}

	private void 등록하기() {

		String 제목 = 제목필드.getText();
		String 부제 = 부제필드.getText();
		String 감독 = 감독필드.getText();
		String 개봉 = 개봉필드.getText();
		String 주연 = 주연필드.getText();
		장르Item 선택된장르Item = (장르Item) 장르콤보.getSelectedItem();
		장르 선택된장르 = 선택된장르Item.장르;
		int 장르 = 선택된장르.get번호();

		System.out.println(장르);

		영화 새영화 = new 영화();
		새영화.set제목(제목);
		새영화.set부제(부제);
		새영화.set감독(감독);
		새영화.set주연(주연);

		Date date = java.sql.Date.valueOf(개봉);
		새영화.set개봉일((java.sql.Date) date);

		새영화.set장르_번호(장르);

		영화관리자 한영화관리자 = new 영화관리자();
		한영화관리자.등록하다(새영화);

	}

	private void 장르를출력하다(장르 선택될장르) {
		장르콤보.removeAllItems();
		장르관리 장르관리 = new 장르관리();
		List<장르> 장르들 = 장르관리.모든장르를수집하다();
		for (장르 한장르 : 장르들) {
			장르Item 한장르Item = new 장르Item(한장르);
			장르콤보.addItem(한장르Item);
			if (선택될장르 != null && 선택될장르.get번호() == 한장르.get번호()) {
				장르콤보.setSelectedItem(한장르Item);
			}

		}

	}
	// 데이터바인딩

}
