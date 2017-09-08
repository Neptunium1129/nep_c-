package 테입관리;

import java.util.List;

import util.Result;
import 영화관리.영화;

public class 테입관리 {
	테입DAO 새테입DAO = new 테입DAO();

	public 테입관리() {
	}

	public Result 테입을등록하다(테입 새테입) {

		새테입DAO.저장하다(새테입);
		return new Result();
	}

	public List<테입> 테입을조회하다By영화번호(int 영화번호) {

		return 새테입DAO.테입을수집하다By영화번호(영화번호);
	}

	public List<영화> 영화를조회하다By영화제목(String 영화제목) {

		return 새테입DAO.영화를가져오다By영화제목(영화제목);
	}

}
