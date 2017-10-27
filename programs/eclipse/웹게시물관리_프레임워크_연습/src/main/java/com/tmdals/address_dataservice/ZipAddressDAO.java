package com.tmdals.address_dataservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tmdals.address_common.ZipAddress;

@Repository
public class ZipAddressDAO {



	public List<ZipAddress> searchaddress(String location) {
		List <ZipAddress> 주소들 = new ArrayList<ZipAddress>();
		ZipAddress 한주소1 = new ZipAddress();
		한주소1.setZipcode("03114");
		한주소1.setAddress("서울강남구무슨동");
		주소들.add(한주소1);
		
		
		return 주소들;
	}

}
