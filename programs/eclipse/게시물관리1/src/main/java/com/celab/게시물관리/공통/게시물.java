package com.celab.게시물관리.공통;

public class 게시물 {
	int 번호;
	String 제목;
	String 내용,작성자,날짜,작성비번;
	public String get작성비번() {
		return 작성비번;
	}
	public void set작성비번(String 작성비번) {
		this.작성비번 = 작성비번;
	}
	public String get날짜() {
		return 날짜;
	}
	public void set날짜(String 날짜) {
		this.날짜 = 날짜;
	}
	public int get번호() {
		return 번호;
	}
	public void set번호(int 번호) {
		this.번호 = 번호;
	}
	public String get제목() {
		return 제목;
	}
	public void set제목(String 제목) {
		this.제목 = 제목;
	}
	public String get내용() {
		return 내용;
	}
	public void set내용(String 내용) {
		this.내용 = 내용;
	}
	public String get작성자() {
		return 작성자;
	}
	public void set작성자(String 작성자) {
		this.작성자 = 작성자;
	}

}
