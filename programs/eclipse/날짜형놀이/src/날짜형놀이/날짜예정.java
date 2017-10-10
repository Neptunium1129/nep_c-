package 날짜형놀이;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 날짜예정 {
	public static void main(String[] args) {
	try{

		Date 현재일 = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(현재일);
		cal.add(Calendar.DATE, 2);


		Date 예정일 = cal.getTime();

		System.out.println(현재일);

		System.out.println(예정일);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//Date date = df.parse(현재일);	
		
		
		String 현재일_변환 = df.format(현재일);
		System.out.println(현재일_변환);
		String 예정일_변환 = df.format(예정일);
		System.out.println(예정일_변환);

	}catch(Exception e) {e.printStackTrace();}
	}
}
