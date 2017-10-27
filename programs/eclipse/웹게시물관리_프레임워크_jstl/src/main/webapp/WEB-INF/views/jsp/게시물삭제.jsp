<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    Boolean check = (Boolean)request.getAttribute("check");
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
var check= <%=check %>;
if(check){
	console.log("참");
	alert("삭제성공");
	location.replace("list");
}else{
	console.log("거짓");
	alert("삭제실패");
	history.go(-1);
}


</script>


</body>
</html>