package 테입관리;

import java.util.Date;
import 영화관리.영화;

public class 테입 {
	
	private int 번호;
	private String 매입처,대여여부;
	String 상태;
	public String get대여여부() {
		return 대여여부;
	}
	public void set대여여부(String 대여여부) {
		this.대여여부 = 대여여부;
	}

	public String get상태() {
		return 상태;
	}
	public void set상태(String 상태내용) {
		this.상태 = 상태내용;
	}
	Date 매입일자;

	public Date get매입일자() {
		return 매입일자;
	}
	public void set매입일자(Date 매입일자) {
		this.매입일자 = 매입일자;
	}
	public int get번호() {
		return 번호;
	}
	public 영화 get영화() {
		return 영화;
	}
	public void set영화(영화 영화) {
		this.영화 = 영화;
	}
	public void set번호(int 번호) {
		this.번호 = 번호;
	}
	public String get매입처() {
		return 매입처;
	}
	public void set매입처(String 매입처) {
		this.매입처 = 매입처;
	}
	영화 영화;
	


}
