package 영화관리;

import java.util.List;

import util.Result;

public class 장르관리 {
	public Result 등록하다(장르 새장르) {
		장르DAO 한장르DAO = new 장르DAO();
		//	장르DAO 한영화DAO = new 장르DAO();
		//	한영화DAO.저장하다(새장르);
		if(한장르DAO.찾다By장르명(새장르.get이름())==true) {
			return new Result(0,"이미 등록된 장르입니다.");
			
		}
		한장르DAO.저장하다(새장르);
		return new Result();
	}

	public List<장르> 모든장르를수집하다() {

		장르DAO 한장르DAO = new 장르DAO();
		return 한장르DAO.모든장르를모으다();

	}
}
