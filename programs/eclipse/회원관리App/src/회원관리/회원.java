package 회원관리;


import java.util.*;

/**
 * 
 */
public class 회원 {

    /**
     * Default constructor
     */
    public 회원() {
    }

    /**
     * 
     */
    private int 번호;

    public int get번호() {
		return 번호;
	}

	public void set번호(int 번호) {
		this.번호 = 번호;
	}

	public String get성명() {
		return 성명;
	}

	public void set성명(String 성명) {
		this.성명 = 성명;
	}

	public String get전화() {
		return 전화;
	}

	public void set전화(String 전화) {
		this.전화 = 전화;
	}

	/**
     * 
     */
    private String 성명;

    /**
     * 
     */
    private String 전화;

}