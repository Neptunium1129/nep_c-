<%@page import="com.celab.게시물관리.공통.게시물"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
  
    게시물 한게시물 =(게시물)request.getAttribute("게시물");
 
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<input type="text" value="<%=한게시물.get번호() %>" name="번호" id="txt번호" ><br>
작성일자 : <br> <input readonly  type="text" value="<%=한게시물.get날짜() %>" name="날짜" id="txt작성일" ><br>
작성자 : <br><input readonly  type="text" value="<%=한게시물.get작성자() %>" name="작성자" id="txt작성자" ><br>
제목  :<br><input readonly  type="text" value="<%=한게시물.get제목() %>" name="제목" id="txt제목" ><br>
내용 : <br><textarea readonly rows="10" name="내용" cols="100" id="txa내용"><%=한게시물.get내용() %></textarea><br>


<input type="button" value="목록" onclick="location.href='게시물목록출력'" />
<br>
<input type="button" value="변경" onclick="변경준비하다2();" id="btn변경" />
<br>
<input type="button" value="삭제" onclick="삭제하다();" />

<form id="frm게시물" action="게시물변경" method="post">
<input type="hidden" id="hid번호" name="번호">
<input type="hidden" id="hid제목" name="제목">
<input type="hidden" id="hid내용" name="내용">
변경비번<input type="text" id="hid비번" name="작성비번">

</form>

<script type="text/javascript">

function 삭제하다() {
	
	var 게시물번호 = document.getElementById("txt번호").value;

	location.href="게시물삭제?no="+게시물번호;
}


function 변경준비하다2() {
	   var btn변경 = document.querySelector("#btn변경");
	   var txt번호 = document.getElementById("txt번호");
	   var txt제목 = document.getElementById("txt제목");
	   var txt내용 = document.getElementById("txa내용");
	   if(btn변경.value == "변경"){
	      
	      txt제목.readOnly = false;
	      txa내용.readOnly = false;
	      btn변경.value="수정";
	      
	   }
	   else {
	      //location.href="게시물변경?제목=" + txt제목 .value + "&내용=" + txa내용.value;
	      document.querySelector('#hid번호').value=  txt번호.value;
	      document.querySelector("#hid제목").value = txt제목.value;
	      document.querySelector("#hid내용").value = txa내용.value;
	      document.querySelector("#frm게시물").submit();
	   }
}

</script>
</body>
</html>