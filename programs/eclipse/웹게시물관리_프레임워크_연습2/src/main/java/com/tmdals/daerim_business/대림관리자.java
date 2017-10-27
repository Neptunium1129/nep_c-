package com.tmdals.daerim_business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmdals.daerim_common.commentDTO;
import com.tmdals.daerim_common.daerimDTO;
import com.tmdals.daerim_dataservice.*;
@Service
public class 대림관리자 {
@Autowired
대림DAO 대림DAO;

	public List<daerimDTO> 정보가져오기() {
		return 대림DAO.가져오기();
	}

	public daerimDTO 조회하다게시물By번호(int no) {
		return 대림DAO.게시물조회(no);
	}

	public void 책등록(daerimDTO drdto) {
		
		대림DAO.책등록하다(drdto);
		
	}

	public void 댓글저장(commentDTO comment_DTO) {
		// TODO Auto-generated method stub
		대림DAO.댓글저장하다(comment_DTO);
	}

	public List<commentDTO> 댓글리스트(int board_num) {
		// TODO Auto-generated method stub
		return 대림DAO.댓글리스트가져오기(board_num);
	}

	

}
