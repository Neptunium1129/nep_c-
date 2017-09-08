package 대여반납관리;


import java.util.List;

import 회원관리.회원;
public class 대여반납 {

	회원 회원VO;
	List<대여반납내역> 대여반납내역들;

	

	public List<대여반납내역> get대여반납내역들() {
		return 대여반납내역들;
	}

	public void set대여반납내역들(List<대여반납내역> 대여반납내역들) {
		this.대여반납내역들 = 대여반납내역들;
	}

	public 회원 get회원VO() {
		return 회원VO;
	}

	public void set회원VO(회원 회원vo) {
		회원VO = 회원vo;
	}

	
	
}
