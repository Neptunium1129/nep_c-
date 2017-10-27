<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원등록</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<div class="jumbotron text-center">
 <h1>회원등록</h1>
  
</div>
  
<div class="container">
  <div class="row">
    <div class="col-sm-4">

			<form action="register_process" method="POST" id="form_register">
				<div class="form-group">
			<label>성명</label>
			<input type="text" class="form-control" name="name" id="name" value=""/>
			</div>
			
			
				<div class="form-group">
			<label>전화</label>
			<input type="text" class="form-control"  name="telephone" value=""/>
			</div>
			<div class="form-group">
			<label>우편번호</label>
			<div class="form-inline">
			<input type="text" class="form-control" id="zipcode" name="address.zipcode" value="" readonly="readonly"/>
			<input type="button" class="btn btn-primary" value="조회" id="btnSearchAddress"/>
		    </div>
			</div>
			
			
			<div class="form-group">
			<label>우편주소</label>
			<input type="text" class="form-control" id="zipaddress"  name="address.address" value="" readonly="readonly"/>
			</div>
			<div class="form-group">
			<label>상세주소</label>
			<input type="text" class="form-control" id="detailAddress"  name="detailAddress" value=""/>
			</div>
			
			<div class="form-group">
			<label>취미</label>
			<select name="hobby">
			<option value="잠" selected="selected">잠</option>
			<option value="자전거" >자전거</option>
			
			</select>
			</div>
			
			<div class="form-group">
			<label>이메일</label>
			<input type="email" class="form-control" id="myemail" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" value=""/>
			</div>
			
			<div class="form-group">
			<label>아이디</label>
			<div class="form-inline">
			<input type="text" class="form-control"  name="id" id="reg_id" value=""/>
			<input type="button" class="btn btn-primary" value="중복검사" id="btnCheckid"/><br>
			</div>
			</div>
			<div class="form-group">
			<label>비번1</label>
			<input type="password" class="form-control"  name="password" value=""/>
			</div>
			<div class="form-group">
			<label>비번2</label>
			<input type="password" class="form-control"  name="password2" value=""/>
			</div>
			

				<input type="submit" class="btn btn-primary" value="등록하기" id="btnRegister"/>
			</form>
    </div>

  </div>
</div>

<script type="text/javascript">
var 주소조회창;
var 아이디중복검사창;
$(document).ready(function(){
    $("#btnSearchAddress").click(function(){
        
    	주소조회창= window.open("address_search" ,'popupNo01', 'width=300, height=400,left=500,top=200, scrollbars= 0, toolbar=0, menubar=no');

    	
    	
    });
    
    $("#btnCheckid").click(function(){      
    	아이디중복검사창 =  window.open("id_search" ,'popupNo01', 'width=300, height=400,left=500,top=200, scrollbars= 0, toolbar=0, menubar=no');
    });
    
    $("#form_register").on("submit", function(e) {
    	
		var 에러메세지 = null;
		if($("#name").val().trim().length==0){
			
			에러메세지="성명은 필수입니다.";
			alert(에러메세지);
		
			
		}else if($("#myemail").val().trim().length==0){
			
			에러메세지="이메일은 필수입니다.";
			alert(에러메세지);
		}
		if(에러메세지!=null){
			//alert(에러메세지);
			e.preventDefault();
			return false;
		
		}

		
	})
});

function 주소를받다(우편번호,우편주소) {
	//zipcode, zipaddress , detailAddress
	$("#zipcode").val(우편번호);
	$("#zipaddress").val(우편주소);
	주소조회창.close();
	detailAddress.focus();
}


function 아이디를받다(아이디) {
	$("#reg_id").val(아이디);
	아이디중복검사창.close();
	$("#reg_id").attr("readonly","true");
}



</script>
</body>
</html>