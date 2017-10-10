package 날짜형놀이;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		try {
			String dateString = "2017-08-66";
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date date = df.parse(dateString);	
			
			String Sql날짜포맷String = df.format(date);
			System.out.println(Sql날짜포맷String);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		

	}

}
