package 테입관리;

import java.util.Date;
import 영화관리.영화;

public class 테입 {
	
	private int 번호,영화_번호;
	public int get영화_번호() {
		return 영화_번호;
	}
	public void set영화_번호(int 영화_번호) {
		this.영화_번호 = 영화_번호;
	}
	private String 매입처,상태내용;
	public String get상태내용() {
		return 상태내용;
	}
	public void set상태내용(String 상태내용) {
		this.상태내용 = 상태내용;
	}
	테입상태 상태;
	
	public 테입상태 get상태() {
		return 상태;
	}
	public void set상태(테입상태 상태) {
		this.상태 = 상태;
	}
	boolean 대여여부;

	public boolean is대여여부() {
		return 대여여부;
	}
	public void set대여여부(boolean 대여여부) {
		this.대여여부 = 대여여부;
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
