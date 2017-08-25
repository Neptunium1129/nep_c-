package 회원관리;


import java.util.*;

/**
 * 
 */
public class 회원관리자 {

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
    	회원DAO 한회원DAO = new 회원DAO();
    	한회원DAO.저장하다(새회원);
    	
    	
    	
    }
    
    public void 변경하다(회원 변경회원) {
        // 업무규칙검사
    	
    	//정상시
    	회원DAO 한회원DAO = new 회원DAO();
    	한회원DAO.변경하다(변경회원);
    	
    	
    	
    }
    
    public List<회원> 회원목록을수집하다(){
    	//업무규칙검사
    	
    	
    	//출력
    	회원DAO 한회원DAO = new 회원DAO();
    	return 한회원DAO.모든회원목록을모으다();
    	
    	
    	
    }
    
    

}