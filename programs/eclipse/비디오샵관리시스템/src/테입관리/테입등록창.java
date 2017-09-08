package 테입관리;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import util.NonEditableTableModel;
import util.Result;
import 영화관리.영화;
import 영화관리.영화관리자;
import 영화관리.영화등록창;
import 영화관리.장르;
import 영화관리.장르관리;
import 영화관리.장르등록창;
import 회원관리.회원;

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
	JLabel 영화조회라벨;

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

	JTextField 영화조회필드;

	JComboBox 장르콤보, 상태콤보;

	JButton 영화등록버튼, 장르등록버튼, 닫기버튼;
	JButton 테입등록버튼, 영화조회버튼;

	JTable 영화조회목록표;

	List<영화> 영화들;

	public 테입등록창() {
		테입등록창self = this;
		this.setTitle("테입 등록");
		this.setLayout(null);
		this.setBounds(100, 100, 800, 450);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		초기화하다();
	}

	private void 초기화하다() {
		영화탭팬 = new JTabbedPane();
		영화탭팬.setBounds(5, 5, 400, 400);
		this.add(영화탭팬);

		영화등록판넬초기화();
		영화조회판넬초기화();
		테입그룹판넬초기화();

	}

	private void 테입그룹판넬초기화() {
		// ..groupbox style.........................
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
		매입처필드.setEditable(false);
		box.add(매입처필드);

		매입일자라벨 = new JLabel("매입일자");
		매입일자라벨.setBounds(70, 80, 70, 20);
		box.add(매입일자라벨);

		매입일자필드 = new JTextField();
		매입일자필드.setBounds(125, 80, 100, 25);
		box.add(매입일자필드);

		영화번호라벨 = new JLabel("영화번호");
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
		String 매입일자 = 매입일자필드.getText();
		// String 대여여부 = "0";
		String 영화번호 = 영화번호필드.getText();
		Date date = java.sql.Date.valueOf(매입일자);
		새테입.set매입일자(date);
		새테입.set상태내용(상태내용);
		새테입.set영화_번호(Integer.parseInt(영화번호));

		Result 결과 = 한테입관리.테입을등록하다(새테입);
		if (결과.resultCode != 1) {
			JOptionPane.showMessageDialog(테입등록창self, 결과.message, "에러", JOptionPane.OK_OPTION);
			return;
		}
		JOptionPane.showMessageDialog(테입등록창self, "등록되었습니다.", "등록됨", JOptionPane.INFORMATION_MESSAGE);

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

				등록하기();

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

	private void 영화조회판넬초기화() {
		영화조회판넬 = new JPanel();
		영화조회판넬.setLayout(null);
		영화탭팬.add("영화조회", 영화조회판넬);

		영화조회라벨 = new JLabel("제목");
		영화조회라벨.setBounds(5, 10, 30, 20);
		영화조회판넬.add(영화조회라벨);

		영화조회필드 = new JTextField();
		영화조회필드.setBounds(45, 10, 180, 25);
		영화조회판넬.add(영화조회필드);

		영화조회버튼 = new JButton("영화조회");
		영화조회버튼.setBounds(240, 10, 100, 30);
		영화조회판넬.add(영화조회버튼);

		DefaultTableModel 테이블모델 = new NonEditableTableModel();
		테이블모델.addColumn("영화번호");
		테이블모델.addColumn("영화명");

		//
		영화조회목록표 = new JTable(테이블모델);
		영화조회목록표.setFillsViewportHeight(true);
		영화조회목록표.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//
		JScrollPane 주소목록판 = new JScrollPane(영화조회목록표);
		주소목록판.setBounds(10, 50, 380, 320);
		영화조회판넬.add(주소목록판);

		영화조회버튼.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				영화조회하기();

			}
		});

		영화조회목록표.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				int 선택된행 = 영화조회목록표.getSelectedRow();

				if (e.getClickCount() == 2) {
					DefaultTableModel 테이블모델 = (DefaultTableModel) 영화조회목록표.getModel();
					// 부모대여반납창.테입을받다(테입들.get(선택된행2));
					System.out.println(영화들.get(선택된행).get번호());
					int 영화번호 = 영화들.get(선택된행).get번호();
					영화번호필드.setText(String.valueOf(영화번호));

					Date 현재일 = new Date();

					Calendar cal = Calendar.getInstance();
					cal.setTime(현재일);
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					String 현재일_변환 = df.format(현재일);

					매입일자필드.setText(현재일_변환);

				}

			}

		});

	}

	private void 영화조회하기() {
		String 영화제목 = 영화조회필드.getText();
		영화관리자 테입영화조회 = new 영화관리자();
		영화들 = 테입영화조회.영화를조회하다By제목(영화제목);

		DefaultTableModel 테이블모델 = (DefaultTableModel) 영화조회목록표.getModel();
		테이블모델.setRowCount(0);
		for (영화 한영화 : 영화들) {
			Object[] 행 = { 한영화.get번호(), 한영화.get제목() };

			테이블모델.addRow(행);

		}

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
