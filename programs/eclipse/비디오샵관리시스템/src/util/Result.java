package util;

public class Result {
	

	public String message;
	public int resultCode=1;
	
	public Result() {
		this.message="";
		this.resultCode=1;
	}
	
	public Result(int resultCode, String message){
		this.message=message;
		this.resultCode=resultCode;
		
		
	}

}
