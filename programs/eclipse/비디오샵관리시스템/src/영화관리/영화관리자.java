package 영화관리;

import java.util.List;

public class 영화관리자 {
	
	영화DAO 한영화DAO = new 영화DAO();

	/**
	 * Default constructor
	 */
	public 영화관리자() {
	}

	public void 등록하다(영화 새영화) {
		//영화DAO 한영화DAO = new 영화DAO();
		한영화DAO.저장하다(새영화);

	}
	public List<영화> 영화를조회하다By제목(String 유사영화명){
		
		return 한영화DAO.영화를수집하다By제목(유사영화명);
	}

}
