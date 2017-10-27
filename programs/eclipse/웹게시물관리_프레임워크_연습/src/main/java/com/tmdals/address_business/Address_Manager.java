package com.tmdals.address_business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmdals.address_common.ZipAddress;
import com.tmdals.address_dataservice.ZipAddressDAO;


@Service
public class Address_Manager {

	@Autowired
	ZipAddressDAO zipAddressDAO;
	
	public List<ZipAddress> searchaddress(String location){
		List <ZipAddress> addresses = zipAddressDAO.searchaddress(location);

		
		/*ZipAddress 한주소2 = new ZipAddress();
		한주소2.setZipcode("03113");
		한주소2.setAddress("서울강남구서초동");
		주소들.add(한주소2);*/
		return addresses;
	}
	
}
