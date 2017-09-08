package 대여반납관리;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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
import 영화관리.영화;
import 테입관리.테입;
import 회원관리.회원;

public class 대여반납창 extends JFrame {
	대여관리자 한대여관리 = new 대여관리자();

	대여반납창 대여반납창self;

	JLabel 성명라벨;
	JTextField 성명필드;

	JLabel 전화라벨;
	JTextField 전화필드;

	JLabel 영화명라벨;
	JTextField 영화명필드;

	JButton 회원조회버튼;
	JButton 영화조회버튼;
	JButton 목록삭제;
	JButton 대여등록버튼;

	JTabbedPane 탭팬;
	JPanel 대여판넬;
	JPanel 반납판넬;

	JTable 목록표;
	회원 대상회원;
	영화 대상영화;
	테입 대상테입;
	대여반납 한대여반납;


	public 대여반납창() {
		대여반납창self = this;
		this.setTitle("대여/반납");
		this.setLayout(null);
		this.setSize(700, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		탭팬 = new JTabbedPane();
		탭팬.setBounds(10, 100, 660, 350);
		this.add(탭팬);
		초기화하다();

	}

	private void 초기화하다() {
		// ..groupbox style.........................
		JPanel box = new JPanel();
		box.setLayout(null);
		box.setBounds(10, 10, 650, 80);
		box.setBorder(BorderFactory.createTitledBorder("회원"));
		this.add(box);

		성명라벨 = new JLabel("성  명");
		성명라벨.setBounds(10, 30, 50, 20);
		box.add(성명라벨);

		성명필드 = new JTextField();
		성명필드.setBounds(60, 30, 100, 20);
		box.add(성명필드);

		전화라벨 = new JLabel("전  화");
		전화라벨.setBounds(200, 30, 50, 20);
		box.add(전화라벨);

		전화필드 = new JTextField();
		전화필드.setBounds(260, 30, 100, 20);
		box.add(전화필드);

		회원조회버튼 = new JButton("조회");
		회원조회버튼.setBounds(400, 30, 100, 25);
		box.add(회원조회버튼);

		판넬1초기화하다();
		판넬2초기화하다();

		회원조회버튼.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				회원조회임시();

			}
		});

	}

	private void 회원조회임시() {

		// 회원관리자 한회원관리자 = new 회원관리자();
		// List<회원> 회원들 = 한회원관리자.회원목록을수집하다();
		// System.out.println(회원들.get(0).get성명());

		// 회원 기존회원 = new 회원();
		// 기존회원.set성명(회원이름);
		// 회원관리자 한회원관리자 = new 회원관리자();
		// 한회원관리자.회원출력By성명(기존회원);

		// System.out.println();

		String 회원이름 = 성명필드.getText().trim();
		
		 //if(회원이름.length()==0){

		// return;
		// }
		회원선택창 회창 = new 회원선택창(대여반납창self, 회원이름, null);
		회창.setVisible(true);

	}

	private void 영화조회임시() {
		String 영화이름 = 영화명필드.getText().trim();
		영화선택창 영창 = new 영화선택창(대여반납창self, 영화이름);

		영창.setVisible(true);

	}

	private void 판넬1초기화하다() {
		대여판넬 = new JPanel();
		대여판넬.setLayout(null);
		탭팬.add("대여", 대여판넬);

		// ..groupbox style.........................
		JPanel box = new JPanel();
		box.setLayout(null);
		box.setBounds(10, 10, 640, 60);
		box.setBorder(BorderFactory.createTitledBorder("영화"));
		대여판넬.add(box);

		영화명라벨 = new JLabel("영   화");
		영화명라벨.setBounds(10, 25, 100, 20);
		box.add(영화명라벨);

		영화명필드 = new JTextField();
		영화명필드.setBounds(60, 25, 170, 20);
		box.add(영화명필드);

		영화조회버튼 = new JButton("조회");
		영화조회버튼.setBounds(280, 25, 80, 20);
		box.add(영화조회버튼);

		영화조회버튼.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				영화조회임시();
			}
		});

		DefaultTableModel 테이블모델 = new NonEditableTableModel();
		테이블모델.addColumn("영화번호");
		테이블모델.addColumn("영화명");
		테이블모델.addColumn("테입번호");
		테이블모델.addColumn("반납예정일");
		//
		목록표 = new JTable(테이블모델);
		목록표.setFillsViewportHeight(true);
		목록표.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//
		JScrollPane 주소목록판 = new JScrollPane(목록표);
		주소목록판.setBounds(10, 80, 550, 240);
		대여판넬.add(주소목록판);

		목록삭제 = new JButton("삭제");
		목록삭제.setBounds(570, 100, 80, 20);
		대여판넬.add(목록삭제);
		대여등록버튼 = new JButton("대여");
		대여등록버튼.setBounds(570, 150, 80, 20);
		대여판넬.add(대여등록버튼);

		대여등록버튼.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				한대여관리.대여하다(한대여반납);
				한대여반납=null;
				JOptionPane.showMessageDialog(대여반납창self, "대여가 기록되었습니다.", "대여 기록", JOptionPane.INFORMATION_MESSAGE);


			}
		});

	/*	목록표.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

				if (e.getClickCount() == 2) {
					int 선택된행 = 목록표.getSelectedRow(); // 행번호
					int 선택된열 = 목록표.getSelectedColumn(); // 열번호
					System.out.println(선택된행 + "/" + 선택된열);
					DefaultTableModel 테이블모델 = (DefaultTableModel) 목록표.getModel();
					int 영화번호 = (int) 테이블모델.getValueAt(선택된행, 0);// 그걸 줌
					String 영화명 = (String) 테이블모델.getValueAt(선택된행, 1);
					int 테입번호 = (int) 테이블모델.getValueAt(선택된행, 2);
					String 반납예정일 = (String) 테이블모델.getValueAt(선택된행, 3);
					System.out.println(String.valueOf(영화번호) + "/" + 영화명 + "/" + String.valueOf(테입번호) + "/" + 반납예정일);

				

				}

			}
		});*/

	}

	private void 판넬2초기화하다() {
		반납판넬 = new JPanel();
		반납판넬.setLayout(null);
		탭팬.add("반납", 반납판넬);

	}

	public void 회원을받다(회원 한회원) {
		한대여반납 = new 대여반납();
		한대여반납.set회원VO(한회원);
		성명필드.setText(한회원.get성명());
		전화필드.setText(한회원.get전화());

	}

	public void 영화를받다(영화 한영화) {
		대상영화 = 한영화;
		영화명필드.setText(대상영화.get제목());
		String 영화명 = 대상영화.get제목();
		int 영화번호 = 대상영화.get번호();
		테입선택창 테창 = new 테입선택창(대여반납창self, 영화번호, 영화명);
		테창.setVisible(true);

	}

	public boolean 테입을받다(테입 한테입) {
		/*
		 * 대상테입 = 한테입; DefaultTableModel 테이블모델 = (DefaultTableModel) 목록표.getModel(); try
		 * {
		 * 
		 * Date 현재일 = new Date();
		 * 
		 * Calendar cal = Calendar.getInstance(); cal.setTime(현재일);
		 * cal.add(Calendar.DATE, 2);
		 * 
		 * Date 예정일 = cal.getTime();
		 * 
		 * System.out.println(현재일);
		 * 
		 * System.out.println(예정일);
		 * 
		 * SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // Date date =
		 * df.parse(현재일);
		 * 
		 * String 현재일_변환 = df.format(현재일); System.out.println(현재일_변환); String 예정일_변환 =
		 * df.format(예정일); System.out.println(예정일_변환); Object[] 행 = { 대상영화.get번호(),
		 * 영화명필드.getText(), 대상테입.get번호(), 예정일_변환 };
		 * 
		 * 테이블모델.addRow(행);
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */

		Date 현재일 = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(현재일);
		cal.add(Calendar.DATE, 2);

		Date 반납예정일 = cal.getTime();

		if (한대여반납.get대여반납내역들() == null) {
			한대여반납.set대여반납내역들(new ArrayList());
		}
		대여반납내역 새대여반납내역 = new 대여반납내역();
		새대여반납내역.set반납예정일(반납예정일);
		새대여반납내역.set테입VO(한테입);
		한대여반납.get대여반납내역들().add(새대여반납내역);
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		String 예정일 = df.format(반납예정일);
		Object[] 행 = { 한테입.get영화().get번호(), 한테입.get영화().get제목(), 한테입.get번호(), 예정일 };
		((DefaultTableModel) 목록표.getModel()).addRow(행);
		return true;
	}

}
