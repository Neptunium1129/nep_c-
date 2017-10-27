<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#전체상자 {
}
#상단상자 {
  width:1200px;
  background-color: lightblue;
  
}
#웹프로그래밍상자 {
 width:100%;
 padding:5px;
 overflow:auto;

 border-top:1px solid gray;
 
}
.수직책상자 {
 width:185px;
 float:left;
 padding:15px;
 border-right:1px solid gray;
}
.책제목 {
 font-size: 15px;
 color:green;
 font-weight: bold;
}
.책소개 {
 font-size: 14px;
}
.날짜 {
 font-size: 13px;
 color:gray;
}
.수평책상자 {
 width:303px;
 float:right;
 padding:6px;
 border-top:1px solid gray;
 
}
div#left_box {
    float: left;
}
div#수직3단상자 {
    width: 124%;
}
</style>
</head>
<body>
<a href="prepare"><jsp:include page="top.jsp"></jsp:include></a>
<br>

<div id="전체상자">
<div id="left_box">
<jsp:include page="left.jsp"></jsp:include>
</div>

 <div id="상단상자">
  <div id="수평2단상자">
  
  <c:forEach var="books" items="${Books}">
    <a href="daerim_view?no=${books.no}"> <div class="수직책상자">
 <table>
  <tr>
   <td>
    <img src="img/${books.img}" width="185" height="185">
   </td>
  </tr>
  
  <tr>
   <td class="책제목">
  ${books.title} [${books.comment_cnt}]
   </td>
  </tr>
  
  <tr>
   <td class="책소개">
       ${books.writer}/${books.contents}
   </td>
  </tr>
  <tr>
   <td class="날짜">
    ${books.makeday}/${books.price}
   </td>
  </tr>
 </table>
 

</div>
</a>
  </c:forEach>
  

  
  </div>
  
 
 
 </div>
 
 


</div>

</body>
</html>