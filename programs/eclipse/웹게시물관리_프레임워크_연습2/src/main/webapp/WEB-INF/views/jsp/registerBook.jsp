<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="register" method="post" enctype="multipart/form-data">
제목<input type="text" name="title">
내용<input type="text" name="contents">
저자<input type="text" name="writer">
발행일<input type="text" name="makeday">
가격<input type="text" name="price">
<input type="file" id="myfile" name="cimg"  />
<img id="img" src="img/noimage.jpg" width="100" height="100"/>
<input type="submit" value="등록">

</form>

<script>
function 그림파일읽어출력하기(이벤트) {
    var 그림파일 = 이벤트.target.files[0]; 

      if (!그림파일.type.match('image.*')) {
        alert("욱! 그림이 아니예요!");
      }

      var 파일리더 = new FileReader();
       파일리더.onload = function(한그림파일) {
    	  var myimg=document.getElementById("img");
          myimg.src=한그림파일.currentTarget.result;
      };      
        파일리더.readAsDataURL(그림파일);
    
  }
  document.getElementById('myfile').addEventListener('change', 그림파일읽어출력하기, false);
</script>
</body>
</html>