package 대여반납관리;

import java.util.List;

public class 대여관리자 {
	대여반납DAO 한대여반납DAO = new 대여반납DAO();
	public void 대여하다(대여반납 새대여반납) {
		//업무
		
		//데이터저장
		
		한대여반납DAO.저장하다(새대여반납);
		
	}
	


}
