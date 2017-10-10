<%@page import="article_common.Article"%>
<%@page import="java.util.List"%>
<%@page import="article_business.게시물관리자"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    
    String str페이지번호 = request.getParameter("pno");
    int 요청페이지번호 = (str페이지번호==null)?1:Integer.valueOf(str페이지번호);
    int 페이지당게시물수 = 10;
    int 시작번호=(요청페이지번호-1)*페이지당게시물수+1;
    int 최대갯수=10;
    
    게시물관리자 한게시물관리자 = new 게시물관리자();
    List<Article> Articles = 한게시물관리자.게시물을수집하다(시작번호, 최대갯수);
    int 총게시물수 = 한게시물관리자.총게시물수를주다();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
<% 
int i = 시작번호;
for (Article article : Articles) { %>
<li><%=i++ %>: <%= article.getTitle() %></li>
<% } %>

<% 
//총게시물수 = 33;
int 마지막페이지번호= ((int)(총게시물수/페이지당게시물수))+((총게시물수%페이지당게시물수==0)?0:1);
for (int 페이지번호=1;페이지번호<=마지막페이지번호;페이지번호++) {
	%>
	
<a href="게시물목록.jsp?pno=<%=페이지번호 %>">
<%if (요청페이지번호==페이지번호){ %>
<b>[<%=페이지번호 %>]</b>
<% }else{ %>
[<%=페이지번호 %>]
<% } %>
</a>

<% } %>
</ul>
</body>
</html>