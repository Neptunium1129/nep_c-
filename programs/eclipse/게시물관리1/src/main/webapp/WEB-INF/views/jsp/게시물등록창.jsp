<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물등록창</title>
</head>
<body>
<h1>게시물등록창</h1>
<form name="my" action="게시물등록" method="post">
작성자 <input type='text' name="작성자" id="writer" value="나야"/><br>
작성비번 <input type='text' name="작성비번" id="writer_pass" value=""/><br>
제목 <input type='text' name="제목" id="subject" value=""/><br>
내용 <textarea rows="5" name="내용" id="txa" cols="10" ></textarea><br>
<input type="button" onclick="등록하기();" value="등록"/>
</form>


</body>
<script type="text/javascript">


function 등록하기() {
	var 작성자 = document.getElementById("writer");
	var 제목 = document.getElementById("subject");
	var 내용 = document.getElementById("txa");
	var 작성비번 = document.getElementById("writer_pass");
	
	if(작성자.value=="" || 제목.value==""||내용.value==""||작성비번.value==""){
		alert("빈칸 ㄴㄴ함");
		
	}else{
		my.action = "게시물등록";
		my.submit();
		//location.replace("게시물목록출력");
	}
	
}

</script>
</html>