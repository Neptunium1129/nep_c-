package 대여반납관리;

import java.util.Date;
import 테입관리.테입;

public class 대여반납내역 {

	Date 대여일자;
	Date 반납예정일;
	Date 반납일자;
	int 번호;
	테입 테입VO;

	public Date get대여일자() {
		return 대여일자;
	}

	public void set대여일자(Date 대여일자) {
		this.대여일자 = 대여일자;
	}

	public Date get반납예정일() {
		return 반납예정일;
	}

	public void set반납예정일(Date 반납예정일) {
		this.반납예정일 = 반납예정일;
	}

	public Date get반납일자() {
		return 반납일자;
	}

	public void set반납일자(Date 반납일자) {
		this.반납일자 = 반납일자;
	}

	public int get번호() {
		return 번호;
	}

	public void set번호(int 번호) {
		this.번호 = 번호;
	}

	public 테입 get테입VO() {
		return 테입VO;
	}

	public void set테입VO(테입 테입vo) {
		테입VO = 테입vo;
	}



}
