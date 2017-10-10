package 제어기예제;

import javax.swing.JFrame;

public class 제어기 {
업무관리자 한업무관리자 = new 업무관리자();
public void 처리하다(String 작업) {
	
	if(작업.equals("A작업준비")) {
		
		A창 새창 = new A창();
		새창.setVisible(true);
		
	}else if(작업.equals("B작업준비")) {
		
		B창 새창 = new B창();
		새창.setVisible(true);
	}else if(작업.equals("A작업완료")) {
		

		
	}else if(작업.equals("B등록")) {
		
		한업무관리자.등록하다();

	}
	
	
}

}
