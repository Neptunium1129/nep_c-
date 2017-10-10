package tostring오버라이드;

import javax.net.ssl.SSLEngineResult.Status;

class A {
	
	int v = 7;
	String vv="asdasd";
	public String toString() {
		return vv;
	}
}

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss="ggg";
		//;
		System.out.println(ss.toString());
		Integer aa = new Integer(1);
		//.toString();
		System.out.println(aa.toString());

		System.out.println(new A().toString());
	}

}
