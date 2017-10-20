package com.celab.membermanage_business;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.celab.membermanage_common.Member;

@Service
public class 회원관리자 {
	
	public boolean ID존재여부확인하다(String ID) {
		//retrun 회원DAO.존재하는가(id,pass);
		String test ="tmdals";
		Boolean check=null;
		if(ID.equals(test)) {
			
			check = false;
			
		}else {
			
			check = true;
		}	
		
		return check;
	}
	
	public void 회원등록하다 (Member 회원) {
		//회원DAO.저장하다(회원)
		System.out.println(회원.getName()+"/"+회원.getEmail());
		
		
	}

	public boolean 존재하는가(String ID, String password) {
			//test select count(no) from 회원 where=,
		//retrun 회원DAO.존재하는가(id,pass);
		if(ID.equals("tmdals")) {
			
			return true;
			
			
		}else {
			
			return false;
		}
		
	}
	
	
	
	
}

/*@Repository
class 회원DAO {
	
	public void 저장하다(Member 회원) {
		
	}
	
}*/
