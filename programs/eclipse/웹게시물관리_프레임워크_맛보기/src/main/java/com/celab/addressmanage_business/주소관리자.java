package com.celab.addressmanage_business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.celab.addressmanage_common.ZipAddress;


@Service
public class 주소관리자 {

	
	public List<ZipAddress> 주소를조회하다(String 동이름){
		List <ZipAddress> 주소들 = new ArrayList<ZipAddress>();
		ZipAddress 한주소1 = new ZipAddress();
		한주소1.setZipcode("03112");
		한주소1.setAddress("서울은평구서초동");
		주소들.add(한주소1);
		
		ZipAddress 한주소2 = new ZipAddress();
		한주소2.setZipcode("03113");
		한주소2.setAddress("서울강남구서초동");
		주소들.add(한주소2);
		return 주소들;
	}
	
}
