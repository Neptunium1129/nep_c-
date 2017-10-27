<%@page import="com.tmdals.address_common.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    	List<ZipAddress> addresses =(List<ZipAddress>)request.getAttribute("addresses");
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소조회</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>주소조회</h1>
<form action="address_check" method="post">

			
		<div class="form-group">
			<label>동이름</label>
		<div class="form-inline">
			<input type="text" class="form-control" name="location"/>
			<input type="submit" class="btn btn-primary" value="조회" id="btn동이름서치"/><br>
		</div>
		
		</div>

</form>

<input class="btn btn-warning" id="주소조회창취소버튼" onclick="self.close();" type="button" value="취소">

<%if(addresses != null){ %>
<ul>
<% for(ZipAddress address : addresses){ %>

 	<li><a href="javascript:주소보내다('<%=address.getZipcode() %>','<%=address.getAddress() %>')"><%=address.getZipcode() %> </a>/ <%=address.getAddress() %></li>

<% } %>
</ul>

<% } %>
<script type="text/javascript">
$(document).ready(function(){
    $("#btn동이름서치").click(function(){
        

    	
    });
    
 

});

function 주소보내다(우편번호, 우편주소) {
	
	opener.주소를받다(우편번호,우편주소);
	
}


</script>
</body>
</html>