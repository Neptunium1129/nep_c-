package 대여반납관리;

import java.sql.Date;

public class 대여 {
	
	Date 대여일자,반납일자,반납예정일자;
	int 회원번호,영화번호,테입번호;
	public int get테입번호() {
		return 테입번호;
	}
	public void set테입번호(int 테입번호) {
		this.테입번호 = 테입번호;
	}
	public Date get대여일자() {
		return 대여일자;
	}
	public void set대여일자(Date 대여일자) {
		this.대여일자 = 대여일자;
	}
	public Date get반납일자() {
		return 반납일자;
	}
	public void set반납일자(Date 반납일자) {
		this.반납일자 = 반납일자;
	}
	public Date get반납예정일자() {
		return 반납예정일자;
	}
	public void set반납예정일자(Date 반납예정일자) {
		this.반납예정일자 = 반납예정일자;
	}
	public int get회원번호() {
		return 회원번호;
	}
	public void set회원번호(int 회원번호) {
		this.회원번호 = 회원번호;
	}
	public int get영화번호() {
		return 영화번호;
	}
	public void set영화번호(int 영화번호) {
		this.영화번호 = 영화번호;
	}

}
