<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%

	String test = (String)request.getAttribute("test");
    
    %>
    
    <%=test %>

    
<video width="760" height="430" controls>
  <source src="<%=test %>" type="video/mp4">
  <source src="movie.ogg" type="video/ogg">
  Your browser does not support the video tag.
</video>