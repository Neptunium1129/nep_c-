<%@page import="com.tmdals.article_common.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	int 게시물번호 = (Integer) request.getAttribute("게시물번호");
	Article 게시물 = (Article) request.getAttribute("anarticle");
	int 페이지번호 =Integer.valueOf(request.getParameter("pno"));
	boolean 삭제가능 = (Boolean)request.getAttribute("deletable");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/board_view.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>


	</style>
</head>
<body>

	<div class="whole_box" style="background-color: #e1e4e6;">

	<div class="vertical_container cf">


		<!-- table_container에서 양쪽 흰색 여백을 좀 가지고 있음-->
		<div class="table_container_1">
<div class="table_container_2">



			<div class="ui warning message">

					<div>게시물ID :<%=게시물.getNo() %></div>
					<div>작성자 : <%=게시물.getMember().getName() %> </div>		
					<div>조회수 : <%=게시물.getReadedCount() %></div>
					<div>댓글 : <span id="cn">0</span>개</div>
					<div><%=게시물.getDate() %></div>
					</div>


					<div class="ui info message">
			<div class="bsubject"><%=게시물.getTitle() %></div>
			</div><!--viewSubjectDiv-->

					<div class="viewcontent">
					<%=게시물.getContents()%>
					</div>
				
			
			</div>


			
		<div class="view_menu">
	<a class="btn btn-primary" href="list?pno=<%=페이지번호 %>">목록으로</a>
	<% if(삭제가능){ %>
	
	<input class="btn btn-danger" type="button" onclick="location.href='delete?no=<%=게시물.getNo() %>'" value="삭제" />
	
	<% } %>
	</div>
				
						

		</div>


	
					
					

</div>

</body>
</html>