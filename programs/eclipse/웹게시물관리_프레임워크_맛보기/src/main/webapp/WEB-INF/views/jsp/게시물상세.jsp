<%@page import="com.celab.article_common.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	int 게시물번호 = (Integer) request.getAttribute("게시물번호");
	Article 한게시물 = (Article) request.getAttribute("article");
	int 페이지번호 =Integer.valueOf(request.getParameter("pno"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	제목 :
	<h1><%=한게시물.getTitle()%>
		제목
	</h1>
	<br> 작성자 :
	<%=한게시물.getWriter()%>
	작성자
	<br> 내용 :
	<%=한게시물.getContents()%>
	내용
	
	<a href="list?pno=<%=페이지번호 %>">목록으로</a>
</body>
</html>