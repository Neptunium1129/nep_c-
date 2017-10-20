<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="write4" method="post">
제목 :<input type='text' id='title' name='title' value='포스트로 보내보자'/><br>
작성자 :<input type='text' id='writer' name='writer' value='tmdals'/><br>
내용:<textarea col=20 rows=10 id='contents' name='contents'>앙기모리</textarea>
<input type="submit" value="등록" />

</form>
<a href="list">목록으로</a>

</body>
</html>