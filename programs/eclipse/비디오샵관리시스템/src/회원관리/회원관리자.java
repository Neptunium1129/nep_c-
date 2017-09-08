package 회원관리;


import java.util.*;

/**
 * 
 */
public class 회원관리자 {
	회원DAO 한회원DAO = new 회원DAO();
    /**
     * Default constructor
     */
    public 회원관리자() {
    }

    /**
     * @param 새회원
     */
    public void 등록하다(회원 새회원) {
        // 업무규칙검사
    	if(새회원.get성명().equals("김철수")) {
    		//에러처리
    		return;
    		
    	}
    	if(새회원.get성명().equals("")||새회원.get전화().equals("")) {
    		return;
    	}
    	//정상시
    	
    	한회원DAO.저장하다(새회원);
    	
    	
    	
    }
    
    public List<회원> 회원을조회하다By성명_전화번호(String 회원이름, String 전화번호) {
   
    	return 한회원DAO.회원을수집하다By성명_전화번호(회원이름,전화번호);
    }
   

    
    

}