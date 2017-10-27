<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    Boolean ID사용가능여부 = (Boolean)request.getAttribute("ID사용가능여부");
    String ID =  (String)request.getAttribute("ID");
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디중복검사창</title>
</head>
<body>
<h1>아이디중복검사창</h1>
<form action="id_check" method="post" id="frmid">

			
		<div class="form-group">
			<label>아이디</label>
		<div class="form-inline">
			<input type="text" class="form-control" id="check_id" name="ID" value=""/>
			<input type="submit" class="btn btn-primary" value="조회" id="아이디검사"/><br>
		</div>
		
		</div>

</form>
<span id="message">

</span>
<input type="button" class="btn btn-success" value="사용"  id="btnid사용" >
<input type="button" class="btn btn-danger" value="취소" onclick="self.close();" >


<script type="text/javascript">

window.onload = function(){
var x = opener.$("#reg_id").val();
$("#check_id").val(x);
};


$(document).ready(function(){
	$("#frmid").on("submit", function(e) {
		
		if($("#check_id").val().trim().length==0){
			e.preventDefault();
		
			$("#message").text("아이디를 입력하세요");
			return false;
		}
	});
	
	$("#btnid사용").attr("disabled","true");
	<% if(ID사용가능여부!=null) { %>
	var id사용가능 = <%=(ID사용가능여부)?"false":"true"%>;
	if(id사용가능){
		$("#check_id").val("<%= ID %>").on("change",function(){
			$("#message").text("");
			$("#btnid사용").attr("disabled","true");
		});
		$("#message").text("사용가능합니다");
		$("#btnid사용").removeAttr('disabled').click(function() {
			var 아이디 = $("#check_id").val(); 
			opener.아이디를받다(아이디);
		});
	}else{
		$("#check_id").val("<%= ID %>");
		$("#message").text("이미 사용중입니다.");
		$("#btnid사용").attr("disabled","true");
	}
	<% } %>
	
	
});

</script>
</body>
</html>