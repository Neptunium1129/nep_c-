<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

System.out.println("request.getRequestURI():"+request.getRequestURI());
System.out.println("request.getRequestURL():"+request.getRequestURL());
System.out.println("request.getContext():"+request.getContextPath());
int len = request.getContextPath().length();

System.out.println("requestString:"+request.getRequestURI().substring(len+1));


%>