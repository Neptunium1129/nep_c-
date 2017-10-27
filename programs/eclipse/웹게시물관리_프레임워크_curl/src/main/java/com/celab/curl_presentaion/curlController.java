package com.celab.curl_presentaion;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.celab.curl_dao.curl_dao;

@Controller
public class curlController {

	
	@RequestMapping("curl")
	public ModelAndView curl(@RequestParam("id") String id) throws MalformedURLException, IOException, ParseException {
		ModelAndView mv = new ModelAndView();
		
		String test = curl_dao.불러오기(id);
		String s2 = test.replace(")]}'", "");
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse( s2 );
		JSONObject jsonObj = (JSONObject) obj;

		String code = (String)jsonObj.get("downloadUrl");
		
		
		mv.setViewName("main");
		mv.addObject("test", code);
		return mv;
	}
	
	
}
