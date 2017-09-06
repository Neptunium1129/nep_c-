package 테입관리;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import 영화관리.장르;
import 영화관리.장르관리;
import 영화관리.장르등록창;

public class 테입등록창 extends JFrame {
	
	테입등록창 테입등록창self;
	JLabel 제목라벨;
	JLabel 부제라벨;
	JLabel 감독라벨;
	JLabel 주연라벨;
	JLabel 개봉라벨;
	JLabel 장르라벨;
	JLabel 상태라벨;
	
	JLabel 매입처라벨;
	JLabel 매입일자라벨;
	JLabel 영화번호라벨;

	
	JTabbedPane 영화탭팬;
	JPanel 영화등록판넬;
	JPanel 영화조회판넬;

	JTextField 제목필드;
	JTextField 부제필드;
	JTextField 감독필드;
	JTextField 주연필드;
	JTextField 개봉필드;
	
	JTextField 매입처필드;
	JTextField 매입일자필드;
	JTextField 영화번호필드;
	
	JComboBox 장르콤보,상태콤보;

	JButton 영화등록버튼, 장르등록버튼, 닫기버튼;
	JButton 테입등록버튼;

	public 테입등록창() {
		테입등록창self = this;
		this.setTitle("테입 등록");
		this.setLayout(null);
		this.setBounds(100, 100, 800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		초기화하다();
	}
	
	private void 초기화하다() {
		영화탭팬 = new  JTabbedPane();
		영화탭팬.setBounds(5, 5, 400, 400);
		this.add(영화탭팬);

		영화등록판넬초기화();
		영화조회판넬초기화();
		테입그룹판넬초기화();

		
	}
	
	private void 테입그룹판넬초기화() {
		//..groupbox style.........................
		JPanel box = new JPanel();
		box.setLayout(null);
		box.setBounds(410, 0, 360, 410);
		box.setBorder(BorderFactory.createTitledBorder("테입"));
		this.add(box);
		
		상태라벨 = new JLabel("상태");
		상태라벨.setBounds(80, 245, 30, 20);
		box.add(상태라벨);
		
		상태콤보 = new JComboBox();
		상태콤보.setBounds(125, 245, 120, 25);

		상태콤보.addItem("정상");
		상태콤보.addItem("파손");
		상태콤보.addItem("폐기");
		box.add(상태콤보);
		
		매입처라벨 = new JLabel("매입처");
		매입처라벨.setBounds(80, 50, 50, 20);
		box.add(매입처라벨);

		매입처필드 = new JTextField();
		매입처필드.setBounds(125, 50, 100, 25);
		box.add(매입처필드);
		
		매입일자라벨 = new JLabel("매입일자");
		매입일자라벨.setBounds(70, 80, 70, 20);
		box.add(매입일자라벨);
		
		매입일자필드 = new JTextField();
		매입일자필드.setBounds(125, 80, 100, 25);
		box.add(매입일자필드);
		
		영화번호라벨= new JLabel("영화번호");
		영화번호라벨.setBounds(70, 120, 70, 20);
		box.add(영화번호라벨);
		
		영화번호필드 = new JTextField();
		영화번호필드.setBounds(125, 120, 100, 25);
		box.add(영화번호필드);
		
		테입등록버튼 = new JButton("테입등록");
		테입등록버튼.setBounds(125, 350, 100, 30);
		box.add(테입등록버튼);
		
		테입등록버튼.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				테입등록();
				
				
			}
		});
	}
	
	private void 테입등록() {
		테입관리 한테입관리 = new 테입관리();
		테입 새테입 = new 테입();
		String 상태내용 = (String) 상태콤보.getSelectedItem();
	//	System.out.println(상태내용);
		String 매입일자 = 매입일자필드.getText();
		String 매입처 = 매입처필드.getText();
		String 대여여부 = "0";
		Date date=java.sql.Date.valueOf(매입일자);
		새테입.set매입일자(date);
		새테입.set매입처(매입처);
		새테입.set상태(상태내용);
		새테입.set대여여부(대여여부);
	//	System.out.println(date+상태내용+매입처);
		
		
		
		한테입관리.테입을등록하다(새테입);
		
		
	}
	
	private void 영화등록판넬초기화() {
		영화등록판넬 = new JPanel();
		영화등록판넬.setLayout(null);
		영화탭팬.add("영화등록", 영화등록판넬);
		
		제목라벨 = new JLabel("제목");
		제목라벨.setBounds(80, 60, 30, 20);
		영화등록판넬.add(제목라벨);
		부제라벨 = new JLabel("부제");
		부제라벨.setBounds(80, 100, 30, 20);
		영화등록판넬.add(부제라벨);
		감독라벨 = new JLabel("감독");
		감독라벨.setBounds(80, 132, 30, 20);
		영화등록판넬.add(감독라벨);
		주연라벨 = new JLabel("주연");
		주연라벨.setBounds(80, 170, 30, 20);
		영화등록판넬.add(주연라벨);
		개봉라벨 = new JLabel("개봉");
		개봉라벨.setBounds(80, 205, 30, 20);
		영화등록판넬.add(개봉라벨);
		장르라벨 = new JLabel("장르");
		장르라벨.setBounds(80, 245, 30, 20);
		영화등록판넬.add(장르라벨);

		제목필드 = new JTextField();
		제목필드.setBounds(150, 55, 180, 25);
		영화등록판넬.add(제목필드);
		부제필드 = new JTextField();
		부제필드.setBounds(150, 94, 140, 25);
		영화등록판넬.add(부제필드);
		감독필드 = new JTextField();
		감독필드.setBounds(150, 127, 140, 25);
		영화등록판넬.add(감독필드);
		주연필드 = new JTextField();
		주연필드.setBounds(150, 164, 140, 25);
		영화등록판넬.add(주연필드);
		개봉필드 = new JTextField();
		개봉필드.setBounds(150, 200, 140, 25);
		영화등록판넬.add(개봉필드);

		장르콤보 = new JComboBox();
		장르콤보.setBounds(140, 245, 120, 25);

		// 장르콤보.addItem(한장르.get번호());
		영화등록판넬.add(장르콤보);

		영화등록버튼 = new JButton("영화등록");
		영화등록버튼.setBounds(90, 300, 100, 30);
		영화등록판넬.add(영화등록버튼);

		장르등록버튼 = new JButton("장르등록");
		장르등록버튼.setBounds(260, 245, 100, 30);
		영화등록판넬.add(장르등록버튼);

		닫기버튼 = new JButton("닫기");
		닫기버튼.setBounds(210, 300, 100, 30);
		영화등록판넬.add(닫기버튼);
		
		영화등록버튼.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				//등록하기();
			}
		});
		장르등록버튼.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				장르등록창 장르등록창 = new 장르등록창(테입등록창self);
				장르등록창.setVisible(true);
				장르를출력하다(장르등록창.등록된장르);
				
				

			}
		});
		
		닫기버튼.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				테입등록창self.dispose();
				
			}
		});

		장르를출력하다(null);
		
		
	}
	private void 영화조회판넬초기화() {
		영화조회판넬 = new JPanel();
		영화조회판넬.setLayout(null);
		영화탭팬.add("영화조회", 영화조회판넬);
		
	}
	

	private void 장르를출력하다(장르 선택될장르) {
		장르콤보.removeAllItems();
		장르관리 장르관리 = new 장르관리();
		List<장르> 장르들 = 장르관리.모든장르를수집하다();
		for (장르 한장르 : 장르들) {
			장르Item 한장르Item = new 장르Item(한장르);
			장르콤보.addItem(한장르Item);
			if(선택될장르 !=null && 선택될장르.get번호()==한장르.get번호()) {
				장르콤보.setSelectedItem(한장르Item);
			}

		}
	

	}
	
	
}
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
