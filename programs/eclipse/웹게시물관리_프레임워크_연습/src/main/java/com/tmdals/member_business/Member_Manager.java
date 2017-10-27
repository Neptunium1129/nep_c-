package com.tmdals.member_business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmdals.member_common.Member;
import com.tmdals.member_dataservice.MemberDAO;

@Service
public  class Member_Manager {
@Autowired
MemberDAO memberDAO;
	public  Boolean Login(String ID, String Password) {
		boolean check = false;
		
		check = MemberDAO.Login_process(ID,Password);
		
		return check;
	}
	public static int Register_process(Member member) {
		
		int check = MemberDAO.Register_process(member);
		
		return check;
	}
	public static boolean Id_check(String id) {
		
		boolean check = MemberDAO.Id_check(id);

		return check;
	}
	


	
	
}
