package 영화관리;

public class 영화관리자 {

	/**
	 * Default constructor
	 */
	public 영화관리자() {
	}

	public void 등록하다(영화 새영화) {
		영화DAO 한영화DAO = new 영화DAO();
		한영화DAO.저장하다(새영화);

	}

}
