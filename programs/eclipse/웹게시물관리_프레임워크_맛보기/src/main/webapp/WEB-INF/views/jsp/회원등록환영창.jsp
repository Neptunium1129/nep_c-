<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String name =(String) request.getAttribute("name");
    String email =(String) request.getAttribute("email");
    
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원등록환영</title>
</head>
<body>
<h1>회원등록환영</h1>
<h1><%=name %>님 안녕하세요</h1><br>
등록된 이메일 <%=email %>
</body>
</html>