<%@page import="article_common.Article"%>
<%@page import="java.util.List"%>
<%@page import="article_business.게시물관리자"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    
    String str페이지번호 = request.getParameter("pno");

    int 요청페이지번호 = (str페이지번호==null)?1:Integer.valueOf(str페이지번호);
    int 페이지당게시물수 = 10;
    int 시작번호=(요청페이지번호-1)*페이지당게시물수+1;  //어떤페이지에서 게시물의 시작번호
      게시물관리자 한게시물관리자 = new 게시물관리자();
    List<Article> Articles = 한게시물관리자.게시물을수집하다(시작번호, 페이지당게시물수);
    int 총게시물수 = 한게시물관리자.총게시물수를주다();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
a {

text-decoration: none;

}
</style>
</head>
<body>

<ul>
<% 
int i = 시작번호;
for (Article article : Articles) { %>
<li><%=i++ %>: <%= article.getTitle() %></li>
<% } %>
===============================================<br>
<% 
//총게시물수 = 33;

int 총페이지개수 = 10;
//int 현재페이징 = (((요청페이지번호-1)/페이지개수)*페이지개수)+1;
//int 전체페이징 = ((int)(총게시물수/페이지개수))+((총게시물수%페이지개수==0)?0:1);
//int 첫페이지 = (현재페이징*페이지당게시물수)-(페이지당게시물수-1);


int 마지막페이지번호= ((int)(총게시물수/페이지당게시물수))+((총게시물수%페이지당게시물수==0)?0:1); //총페이지개수와 같다
int 출력시작페이지번호 = (((요청페이지번호-1)/총페이지개수)*총페이지개수)+1;                      //한 페이지에서 첫번째 번호
int 출력마지막페이지번호 = (출력시작페이지번호+(총페이지개수-1)<=마지막페이지번호)?출력시작페이지번호+(총페이지개수-1):마지막페이지번호; //한 페이지에서 마지막 번호

int prevPage = 요청페이지번호-1; //이전 페이지, 11~20일 때 이전을 누르면 10 페이지로 이동.
int nextPage = 요청페이지번호+1; //다음 페이지, 10일때 누르면 11~20으로

if(요청페이지번호!=1){
%>	
<a href="게시물목록2.jsp?pno=1">처음|</a>
	<a href="게시물목록2.jsp?pno=<%=출력시작페이지번호-총페이지개수%>">
		<<|
	</a> 
	
 <a href="게시물목록2.jsp?pno=<%=prevPage %>"><|</a>
<%	
}
%>

<%
for (int 페이지번호=출력시작페이지번호;페이지번호<=출력마지막페이지번호;페이지번호++) {
	%>
	
<a href="게시물목록2.jsp?pno=<%=페이지번호 %>">
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
if(요청페이지번호!=마지막페이지번호){
%>
 <a href="게시물목록2.jsp?pno=<%=nextPage %>">|></a>
  <a href="게시물목록2.jsp?pno=<%=출력마지막페이지번호+1 %>">|>></a>
<a href="게시물목록2.jsp?pno=<%=마지막페이지번호 %>">|마지막</a>
<%	
}
%>
<%
if(출력마지막페이지번호<마지막페이지번호){
%>

<%	
}
%>


</ul>
출력시작페이지번호<%=출력시작페이지번호 %>
출력마지막페이지번호<%=출력마지막페이지번호 %>
<%=시작번호 %>
<% if(요청페이지번호<0){ %>
<script>
location.replace("게시물목록2.jsp?pno=1");
</script>

<% } %>
<% if(요청페이지번호>마지막페이지번호){ %>
<script>
location.replace("게시물목록2.jsp?pno=<%=출력마지막페이지번호%>");
</script>
<% } %>
</body>
</html>