package 영화관리;

import java.sql.Date;

public class 영화 {
	private String 제목,부제,감독,주연;
	private int 장르_번호;
	private int 번호;
	Date 개봉일;
	장르 장르;
	
	public String get제목() {
		return 제목;
	}
	public void set제목(String 제목) {
		this.제목 = 제목;
	}
	public String get부제() {
		return 부제;
	}
	public void set부제(String 부제) {
		this.부제 = 부제;
	}
	public String get감독() {
		return 감독;
	}
	public void set감독(String 감독) {
		this.감독 = 감독;
	}
	public String get주연() {
		return 주연;
	}
	public void set주연(String 주연) {
		this.주연 = 주연;
	}
	public int get장르_번호() {
		return 장르_번호;
	}
	public void set장르_번호(int 장르_번호) {
		this.장르_번호 = 장르_번호;
	}
	public int get번호() {
		return 번호;
	}
	public void set번호(int 번호) {
		this.번호 = 번호;
	}
	public Date get개봉일() {
		return 개봉일;
	}
	public void set개봉일(Date 개봉일) {
		this.개봉일 = 개봉일;
	}
	public 장르 get장르() {
		return 장르;
	}
	public void set장르(장르 장르) {
		this.장르 = 장르;
	}


}
