package 영화관리;

import java.util.List;

public class 장르관리 {
	public void 등록하다(장르 새장르) {
		if (새장르.get이름().equals("")) {

			return;

		} else {
			장르DAO 한영화DAO = new 장르DAO();
			한영화DAO.저장하다(새장르);
		}
	}

	public List<장르> 모든장르를수집하다() {

		장르DAO 한장르DAO = new 장르DAO();
		return 한장르DAO.모든장르를모으다();

	}
}
