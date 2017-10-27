<%@page import="com.celab.addressmanage_common.ZipAddress"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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
<form action="주소조회" method="post">

			
		<div class="form-group">
			<label>동이름</label>
		<div class="form-inline">
			<input type="text" class="form-control" name="동이름" value=""/>
			<input type="submit" class="btn btn-primary" value="조회" id="btn동이름서치"/><br>
		</div>
		
		</div>

</form>

<input class="btn btn-warning" id="주소조회창취소버튼" onclick="self.close();" type="button" value="취소">
                
          
                <c:if test="${addresses ne null}">
                <ul>
                <c:forEach var="address" items="${addresses}">
                
                 <li><a href="javascript:주소보내다('${address.zipcode}','${address.address}')">${address.zipcode}</a>/ ${address.address}</li>
                
                </c:forEach>
                </ul>
                </c:if>
				
			
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