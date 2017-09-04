package 테입관리;

import util.Result;

public class 테입관리 {
	
	public Result 테입을등록하다(테입 새테입) {
		
		테입DAO 새테입DAO = new 테입DAO();
		새테입DAO.저장하다(새테입);
		return new Result();
	}

}
