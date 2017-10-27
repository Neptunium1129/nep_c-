package com.celab.membermanage_business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.celab.membermanage_common.Member;
import com.celab.membermanage_dataservice.MemberDAO;

@Service
public class 회원관리자 {
	@Autowired
	MemberDAO 멤버DAO;
	
	public boolean ID존재여부확인하다(String ID) {
		return MemberDAO.ID존재여부(ID);
	
	}
	
	public int 회원등록하다 (Member 회원) {
		int 결과 = 멤버DAO.저장하다(회원);
		System.out.println(결과);
		
		return 결과;
	}

	public boolean 존재하는가(String ID, String password) {
		boolean 확인 = false;
		확인 = MemberDAO.존재하는가(ID,password);
	
		return 확인;
	
		
	}
	
public Member 조회하다회원By아이디(String ID) {
	//업무규칙검사
	
	//
	return 멤버DAO.수집하다회원ByID(ID);
	
}
	
	
	
	
}

/*@Repository
class 회원DAO {
	
	public void 저장하다(Member 회원) {
		
	}
	
}*/
