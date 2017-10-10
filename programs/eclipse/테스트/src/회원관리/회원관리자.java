package 회원관리;

public class 회원관리자 {
	
	public 회원관리자() {
		
		
	}
	
	public void 등록하다(회원 새회원) {
		
		회원DAO 한회원DAO = new 회원DAO();
		한회원DAO.데이터베이스에등록하다(새회원);
		
		
	}

}
