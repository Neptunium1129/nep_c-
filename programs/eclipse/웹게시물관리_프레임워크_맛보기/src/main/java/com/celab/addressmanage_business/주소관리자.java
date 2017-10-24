package com.celab.addressmanage_business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celab.addressmanage_common.ZipAddress;
import com.celab.addressmanage_dataservice.ZipAddressDAO;


@Service
public class 주소관리자 {

	@Autowired
	ZipAddressDAO zipAddressDAO;
	
	public List<ZipAddress> 주소를조회하다(String 동이름){
		List <ZipAddress> 주소들 = zipAddressDAO.주소를수집하다By동이름(동이름);

		
		/*ZipAddress 한주소2 = new ZipAddress();
		한주소2.setZipcode("03113");
		한주소2.setAddress("서울강남구서초동");
		주소들.add(한주소2);*/
		return 주소들;
	}
	
}
