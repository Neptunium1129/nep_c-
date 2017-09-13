<%@page import="com.celab.게시물관리.공통.게시물"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    List<게시물> 게시물들 = (List<게시물>)request.getAttribute("게시물들");
    
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
.tg  {border-collapse:collapse;border-spacing:0;}
.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
</style>

<table class="tg">
  <tr>
    <th class="tg-031e" colspan="3"></th>
  </tr>
  <tr>
    <td class="tg-031e">번호</td>
    <td class="tg-031e">제목</td>
        <td class="tg-031e">내용</td>
  </tr>
  
  <%
int i = 1;
for(게시물 한게시물:게시물들){
	%>
   <tr>
    <td class="tg-031e"><%=i++ %></td>
    <td class="tg-031e"><a href="게시물상세?no=<%=한게시물.get번호() %>"><%=한게시물.get제목() %></a></td>
    <td class="tg-031e"><%=한게시물.get내용() %></td>
  </tr>
	
	<%
}
%>



 
</table>



</body>
</html>