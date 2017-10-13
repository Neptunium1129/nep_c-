<%@page import="article_common.Article"%>
<%@page import="java.util.List"%>
<%@page import="article_business.게시물관리자"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	List<Article> Articles = (List<Article>) request.getAttribute("Articles");
	int 총게시물수 = (Integer) request.getAttribute("총게시물수");
	int 요청페이지번호 = (Integer) request.getAttribute("요청페이지번호");
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
			int 페이지당게시물수 = 10;
			int 시작번호 = (요청페이지번호 - 1) * 페이지당게시물수 + 1;
			int i = 시작번호;

			for (Article article : Articles) {
		%>
		<li><%=i++%>: <a href="view?vno=<%=article.getNo()%>&pno=<%=요청페이지번호 %>"><%=article.getTitle()%></a></li>
		<%
			}
		%>
		===============================================
		<br>
		<input type="button" value="새글쓰기" onclick="location.href='preparewrite'"/>
		<%
			int 총페이지개수 = 10;

			int 마지막페이지번호 = ((int) (총게시물수 / 페이지당게시물수)) + ((총게시물수 % 페이지당게시물수 == 0) ? 0 : 1); //총페이지개수와 같다
			int 출력시작페이지번호 = (((요청페이지번호 - 1) / 총페이지개수) * 총페이지개수) + 1; //한 페이지에서 첫번째 번호
			int 출력마지막페이지번호 = (출력시작페이지번호 + (총페이지개수 - 1) <= 마지막페이지번호) ? 출력시작페이지번호 + (총페이지개수 - 1) : 마지막페이지번호; //한 페이지에서 마지막 번호

			int prevPage = 요청페이지번호 - 1; //이전 페이지, 11~20일 때 이전을 누르면 10 페이지로 이동.
			int nextPage = 요청페이지번호 + 1; //다음 페이지, 10일때 누르면 11~20으로

			if (요청페이지번호 != 1) {
		%>
		<a href="list?pno=1">처음|</a>
		<a href="list?pno=<%=출력시작페이지번호 - 총페이지개수%>"> <<| </a>

		<a href="list?pno=<%=prevPage%>"><|</a>
		<%
			}
		%>

		<%
			for (int 페이지번호 = 출력시작페이지번호; 페이지번호 <= 출력마지막페이지번호; 페이지번호++) {
		%>

		<a href="list?pno=<%=페이지번호%>"> <%
 	if (요청페이지번호 == 페이지번호) {
 %> <b>[<%=페이지번호%>]
		</b> <%
 	} else {
 %> [<%=페이지번호%>] <%
 	}
 %>
		</a>

		<%
			}
		%>
		<%
			if (요청페이지번호 != 마지막페이지번호) {
		%>
		<a href="list?pno=<%=nextPage%>">|></a>
		<a href="list?pno=<%=출력마지막페이지번호 + 1%>">|>></a>
		<a href="list?pno=<%=마지막페이지번호%>">|마지막</a>
		<%
			}
		%>


	</ul>
	출력시작페이지번호<%=출력시작페이지번호%>
	출력마지막페이지번호<%=출력마지막페이지번호%>
	<%=시작번호%>
	<%
		if (요청페이지번호 < 0) {
	%>
	<script>
location.replace("list?pno=1");
</script>

	<%
		}
	%>
	<%
		if (요청페이지번호 > 마지막페이지번호) {
	%>
	<script>
location.replace("list?pno=<%=출력마지막페이지번호%>");
	</script>
	<%
		}
	%>
</body>
</html>