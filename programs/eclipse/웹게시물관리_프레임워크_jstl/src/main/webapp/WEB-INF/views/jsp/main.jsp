<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    	//String ID =(String) request.getAttribute("ID");
	String ID=(String)request.getSession().getAttribute("ID");

    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<div class="jumbotron text-center">
 <h1>KSM</h1>
 <% if(ID!=null){ %>
 
 	<%=ID %>님 안녕하세요!<br>
 
  <% }else{ %> 
          <form id="loginform" class="form-horizontal" action="로그인하다" method="post" role="form">
                                    
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                        <input id="login-username" type="text" class="form-control" name="ID" value="" placeholder="아이디">                                        
                                    </div>
                                
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                        <input id="login-password" type="password" class="form-control" name="Password" placeholder="비밀번호">
                                    </div>
                                    

                                
                            <div class="input-group">
                      
                                    </div>


                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                      <input type="submit" id="btn-login" href="#" class="btn btn-success" value="로그인"/>

                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-md-12 control">
                                   
                                    </div>
                                </div>    
                            </form>  
 <% } %>
 <br> <br>
 
 
 
 
 <% if(ID!=null){ %>
 <a href="list" class="btn btn-info">게시판목록</a>
  <a href="로그아웃" class="btn btn-danger">로그아웃</a>
   <% }else{ %>
   <a href="list" class="btn btn-info">게시판목록</a>
   <a href="회원등록준비" class="btn btn-info">회원등록</a>
 <a href="로그인준비" class="btn btn-primary">로그인</a>
   <% } %>

 
  
</div>


</body>
</html>