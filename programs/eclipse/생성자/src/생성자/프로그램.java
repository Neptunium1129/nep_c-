package 생성자;
class A{
	int x;
	//생성자
	public A(int v) {
		
	}
	public A() {
		
	}
	//생성자가 없으면 자바가 디폴트생성자를 만들어준다.
	
	
}
class C {
	
}
class B extends A{
	
	//디폴트
	public B() {
		super(7);
	}
	
}
public class 프로그램 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A a1 = new A();
		//new B;
		
	}

}
