package com.celab.addressmanage_dataservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.celab.addressmanage_common.ZipAddress;

@Repository
public class ZipAddressDAO {

	public List<ZipAddress> 주소를수집하다By동이름(String 동이름) {
		
		//test
		List <ZipAddress> 주소들 = new ArrayList<ZipAddress>();
		ZipAddress 한주소1 = new ZipAddress();
		한주소1.setZipcode("03114");
		한주소1.setAddress("서울강남구무슨동");
		주소들.add(한주소1);
		
		ZipAddress 한주소2 = new ZipAddress();
		한주소2.setZipcode("03100");
		한주소2.setAddress("서울강남구서초동");
		주소들.add(한주소2);
		
		return 주소들;
	}

}
