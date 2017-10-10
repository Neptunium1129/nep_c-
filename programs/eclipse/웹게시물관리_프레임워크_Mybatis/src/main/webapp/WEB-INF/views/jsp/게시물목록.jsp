<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.celab.articlemanage.common.Article" %>     
<%
   List<Article> 게시물들= (List<Article>)request.getAttribute("게시물들");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.페이지{
	cursor:pointer;
}
</style>
</head>
<body>

게시물목록<br>
<ul>
    <%for(Article 게시물:게시물들){
         
    %>
	<li><%= 게시물.getTitle()%></li>
	<%} %>
</ul>

</body>
</html>