<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@page import="com.tmdals.article_common.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Canvas</title>
<style type="text/css">
    body{
        line-height:2em;        
        font-family:"맑은 고딕";
}
    ul, li{ 
        list-style:none;
        text-align:center;
        padding:0;
        margin:0;
}

    #mainWrapper{
        width: 800px;
        margin: 0 auto; /*가운데 정렬*/
    }

    #mainWrapper > ul > li:first-child {
        text-align: center;
        font-size:14pt;
        height:40px;
        vertical-align:middle;
        line-height:30px;
}

    #ulTable {margin-top:10px; width:100%;}
    

    #ulTable > li:first-child > ul > li {
        background-color:#c9c9c9;
        font-weight:bold;
        text-align:center;
}

    #ulTable > li > ul {
        clear:both;
        padding:0px auto;
        position:relative;
        min-width:40px;
}
    #ulTable > li > ul > li { 
        float:left;
        font-size:10pt;
        border-bottom:1px solid silver;
        vertical-align:baseline;
}    

    #ulTable > li > ul > li:first-child               {width:10%;} /*No 열 크기*/
    #ulTable > li > ul > li:first-child +li           {width:45%;} /*제목 열 크기*/
    #ulTable > li > ul > li:first-child +li+li        {width:20%;} /*작성일 열 크기*/
    #ulTable > li > ul > li:first-child +li+li+li     {width:15%;} /*작성자 열 크기*/
    #ulTable > li > ul > li:first-child +li+li+li+li{width:10%;} /*조회수 열 크기*/

    #divPaging {
          clear:both; 
        margin:0 auto; 
          width: 60%;
        height:50px;
}

    #divPaging > div {
        float:left;
        width: 30px;
        margin:0 auto;
        text-align:center;
}

    #liSearchOption {clear:both;}
    #liSearchOption > div {
        margin:0 auto; 
        margin-top: 30px; 
        width:auto; 
        height:100px; 

}

    .left {
        text-align : left;
}


</style>

</head>
<body>
    <div id="mainWrapper">
    <a class="btn btn-warning" href="로그아웃">로그아웃</a>
    <a class="btn btn-info" href="main">main</a>

<c:set var="article_per_count" value="10"></c:set>
<!--시작번호-->
<c:set var="startArticleSerialNo" value="${(pno-1)*articleCountPerPage+1}"/>
<c:set var="articl_page_count" value="10"></c:set>
        <ul>
            <!-- 게시판 제목 -->
            <li>게시판 Title </li>

            <!-- 게시판 목록  -->
            <li>
                MVC 게시판 
  
                <ul id ="ulTable">
                    <li>
                        <ul>
                            <li>No</li>
                            <li>제목</li>
                            <li>작성일</li>
                            <li>작성자</li>
                            <li>조회수</li>
                        </ul>
                    </li>
                    <!-- 게시물이 출력될 영역 -->
                <c:forEach var="article" items="${Articles}">
                
                     <li>
                        <ul>
                            <li>${article.no}</li>
                            <li class="left"><a href="view?vno=${article.no}&pno=${pno}">${article.title}</a></li>
                            <li>${article.date}</li>
                            <li>${article.member.id}</li>
                            <li>0</li>
                        </ul>
                    </li> 
                
                
                </c:forEach>
				
				
				
				
			   
                    			
                                      
                </ul>
            </li>
            

            <!-- 게시판 페이징 영역 -->
   <c:set var="lastPageNo" value="${((totalArticleCount-(totalArticleCount%article_per_count))/article_per_count)+((totalArticleCount%article_per_count==0)?0:1)}" />
                              <!-- 총게시물((22) -(22%10=2))/10=2+((22%10==0)?0:1) == 3  -->
  
  
   <c:set var="temp" value="${pno-1}"/>
   <!--출력시작페이지번호-->
   <c:set var="startPageNoForDisplay" value="${((temp-(temp%articl_page_count))/articl_page_count)*articl_page_count+1}"/>
   <!--출력마지막페이지번호-->
   <c:set var="endPageNoForDisplay" value="${(startPageNoForDisplay+(articl_page_count-1)<=lastPageNo)?startPageNoForDisplay+(articl_page_count-1):lastPageNo}"/>
		  
		
		<c:if test="${startPageNoForDisplay!=1}">
			<a class="btn btn-default" href="list?pno=${startPageNoForDisplay-articl_page_count}">
				<<
			</a> 
		</c:if>


		<!--페이지번호== pageNoForDisplay-->
		<c:forEach var="pageNoForDisplay" begin="${startPageNoForDisplay}" end="${endPageNoForDisplay}" step="1">
		    <a class="btn btn-default" href="list?pno=${pageNoForDisplay}">
			<c:choose>
				<c:when test="${pno==pageNoForDisplay}">
					<b>${pageNoForDisplay}</b>
				</c:when>
				
				<c:otherwise>
					${pageNoForDisplay}
				</c:otherwise>
			</c:choose>
			</a> 
		</c:forEach>


		<c:if test="${endPageNoForDisplay<lastPageNo}">
			<a class="btn btn-default" href="list?pno=${endPageNoForDisplay+1}">
				>>
			</a> 
		</c:if>
        
            
            
           <br> <input class="btn btn-success" type="button" value="새글쓰기" onclick="location.href='preparewrite'"/>
     

            <!-- 검색 폼 영역 -->
            <li id='liSearchOption'>
                <div>
                    <select id='selSearchOption' >
                        <option value='A'>제목+내용</option>
                        <option value='T'>제목</option>
                        <option value='C'>내용</option>
                    </select>
                    <input id='txtKeyWord' />
                    <input type='button' value=''/>
                </div>
                </li>

        </ul>
    </div>
 

   
</body>
</html>