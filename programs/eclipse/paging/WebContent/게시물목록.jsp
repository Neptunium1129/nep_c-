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
    
  int 페이지개수 = 10;
	int 현재페이징 = (((요청페이지번호-1)/페이지개수)*페이지개수)+1;
	int 전체페이징 = ((int)(총게시물수/페이지개수))+((총게시물수%페이지개수==0)?0:1);
	//int 첫페이지 = (현재페이징*페이지당게시물수)-(페이지당게시물수-1);
    
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META HTTP-EQUIV='Cache-Control' ConTENT='no-cache'>
<META HTTP-EQUIV='Pragma' ConTENT='no-cache'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(str페이지번호.equals("0")){ %>
<script>
location.replace("게시물목록.jsp?pno=1");
</script>

<% } %>

현재<%=현재페이징 %>
전체<%=전체페이징 %>

<ul>
<% 
int i = 시작번호;
for (Article article : Articles) { %>
<li><%=i++ %>: <%= article.getTitle() %></li>
<% } %>

<% 
//총게시물수 = 33;
int 마지막페이지번호= ((int)(총게시물수/페이지당게시물수))+((총게시물수%페이지당게시물수==0)?0:1);
int 출력시작페이지번호 = (((요청페이지번호-1)/페이지개수)*페이지개수)+1;
int 출력마지막페이지번호 = (출력시작페이지번호+(페이지개수-1)<=마지막페이지번호)?출력시작페이지번호+(페이지개수-1):마지막페이지번호;

int prevPage = 요청페이지번호-1; //이전 페이지, 11~20일 때 이전을 누르면 10 페이지로 이동.
int nextPage = 요청페이지번호+1;
if(!str페이지번호.equals("1")){
	%>
	<a href="게시물목록.jsp?pno=1">처음</a>
    <a href="게시물목록.jsp?pno=<%=prevPage %>">이전</a>
<%	
}
%>

<%
for (int 페이지번호=출력시작페이지번호;페이지번호<=출력마지막페이지번호;페이지번호++) {
	%>
	
<a href="게시물목록.jsp?pno=<%=페이지번호 %>">
<%
if (요청페이지번호==페이지번호){ 

%>
<b>[<%=페이지번호 %>]</b>
<% }else{ %>
 [<%=페이지번호 %>]
<% } %>
</a>

<% } %>
<%
if(!str페이지번호.equals(String.valueOf(마지막페이지번호))){
%>
  <a href="게시물목록.jsp?pno=<%=nextPage %>">다음</a>
<a href="게시물목록.jsp?pno=<%=마지막페이지번호 %>">마지막</a>
<%	
}
%>
</ul>
</body>
</html>