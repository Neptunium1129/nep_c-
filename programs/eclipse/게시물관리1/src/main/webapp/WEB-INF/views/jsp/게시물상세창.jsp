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
<input type="hidden" value=" <%=한게시물.get번호() %>" id="게시물번호" >


제목 :  <%=한게시물.get제목() %> <br>

내용 : <%=한게시물.get내용() %>

<br>
<input type="button" value="목록" onclick="location.href='게시물목록출력'" />
<br>
<input type="button" value="수정" onclick="" />
<br>
<input type="button" value="삭제" onclick="" />

</body>
</html>