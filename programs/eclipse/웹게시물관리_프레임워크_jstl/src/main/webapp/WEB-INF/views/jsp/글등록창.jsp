<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<form action="write4" method="post">
제목 :<input class="form-control" type='text' id='title' name='title' value='포스트로 보내보자'/><br>
내용:<textarea class="form-control" cols=20 rows=10 id='contents' name='contents'>앙기모리</textarea>
<input class="btn btn-info" type="submit" value="등록" /><a class="btn btn-primary" href="list">목록으로</a>
</form>

</div>
</body>
</html>