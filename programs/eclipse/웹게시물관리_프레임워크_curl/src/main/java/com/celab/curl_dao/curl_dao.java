package com.celab.curl_dao;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Repository;

@Repository
public class curl_dao {

	public static String 불러오기(String id) throws IOException {
		


		// Response로부터 Document 얻어오기
		Connection.Response response = Jsoup.connect("https://docs.google.com/uc?id="+id)
		                                    .method(Connection.Method.POST).ignoreContentType(true).execute();
		                                   
		Document google3 = response.parse();
		
		
		
		String html = google3.text();
		
		
		
		return html;
	}

	
	
	
}
