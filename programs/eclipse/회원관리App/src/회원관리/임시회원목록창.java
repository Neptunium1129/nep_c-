package 회원관리;

import java.util.List;

public class 임시회원목록창 {
	
	 public void 회원목록을출력하다() {
		 
		 회원관리자 한회원관리자 = new 회원관리자();
		 List<회원> 회원들 = 한회원관리자.회원목록을수집하다();
		 
		for(회원 한회원:회원들) {
			
		System.out.println(한회원.get성명()+"\t"+한회원.get전화());
			
			
		}
		 
	 }
	

}
