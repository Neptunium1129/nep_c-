package com.tmdals.addresscontrol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tmdals.address_business.Address_Manager;
import com.tmdals.address_common.ZipAddress;

@Controller
public class AddressController {
	@Autowired
	Address_Manager address_manager;	

	
	@RequestMapping("address_search")
	public String address() {
		
		
		
		return "check_address";
		
		
	}
	@RequestMapping("address_check")
	public ModelAndView addresscheck(@RequestParam("location")String location) {
		ModelAndView mv = new ModelAndView();
		List<ZipAddress> addresses = address_manager.searchaddress(location);
		mv.setViewName("check_address");
		mv.addObject("addresses", addresses);
		
		
		return mv;
		
		
	}
}
