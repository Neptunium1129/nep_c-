package 영화관리;

public class 장르 extends Object {

	private int 번호;
	private String 이름;

	public int get번호() {
		return 번호;
	}

	public void set번호(int 번호) {
		this.번호 = 번호;
	}

	public String get이름() {
		return 이름;
	}

	public void set이름(String 이름) {
		this.이름 = 이름;
	}

	@Override
	public String toString() {
		return 이름;
	}

}
