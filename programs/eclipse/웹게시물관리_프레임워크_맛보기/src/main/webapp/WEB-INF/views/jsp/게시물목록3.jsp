<%@page import="java.util.List"%>
<%@page import="com.celab.article_common.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

//String log_check = (String)request.getAttribute("log_check");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

    #ulTable {margin-top:10px;}
    

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
    <%
	List<Article> Articles = (List<Article>) request.getAttribute("Articles");
	int 총게시물수 = (Integer) request.getAttribute("총게시물수");
	int 요청페이지번호 = (Integer) request.getAttribute("요청페이지번호");
%>
        <ul>
            <!-- 게시판 제목 -->
            <li>게시판 Title </li>

            <!-- 게시판 목록  -->
            <li>
                MVC 게시판 
                <%
			int 페이지당게시물수 = 10;
			int 시작번호 = (요청페이지번호 - 1) * 페이지당게시물수 + 1;
			int i = 시작번호;


		%>
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
                  <%
                   for (Article article : Articles) {
				%>
				
				     <li>
                        <ul>
                            <li><%=i++%></li>
                            <li class="left"><a href="view?vno=<%=article.getNo()%>&pno=<%=요청페이지번호 %>"><%=article.getTitle()%></a></li>
                            <li>미구현</li>
                            <li>미구현</li>
                            <li>미구현</li>
                        </ul>
                    </li> 
				
				
			    <%
					}
                  %>
                    			
                                      
                </ul>
            </li>
            

            <!-- 게시판 페이징 영역 -->
           <%
			int 총페이지개수 = 10;

			int 마지막페이지번호 = ((int) (총게시물수 / 페이지당게시물수)) + ((총게시물수 % 페이지당게시물수 == 0) ? 0 : 1); //총페이지개수와 같다
			int 출력시작페이지번호 = (((요청페이지번호 - 1) / 총페이지개수) * 총페이지개수) + 1; //한 페이지에서 첫번째 번호
			int 출력마지막페이지번호 = (출력시작페이지번호 + (총페이지개수 - 1) <= 마지막페이지번호) ? 출력시작페이지번호 + (총페이지개수 - 1) : 마지막페이지번호; //한 페이지에서 마지막 번호

			int prevPage = 요청페이지번호 - 1; //이전 페이지, 11~20일 때 이전을 누르면 10 페이지로 이동.
			int nextPage = 요청페이지번호 + 1; //다음 페이지, 10일때 누르면 11~20으로
   %>
   		
		  
		  
             <li>
                <div id="divPaging">  
           
             <%
			if (요청페이지번호 != 1) {
		   %>
		    <a href="list?pno=1">F</a>
		<a href="list?pno=<%=출력시작페이지번호 - 총페이지개수%>"> ◀◀ </a> 
			 <a href="list?pno=<%=prevPage%>">◀</a>
		   
			<%
			//페이지이동 
			}
			%>
			
			
                <%
			for (int 페이지번호 = 출력시작페이지번호; 페이지번호 <= 출력마지막페이지번호; 페이지번호++) {
			
				%>
				 
				 
	
	    <%	if (요청페이지번호 == 페이지번호) { %>
	      <div><b><a href="list?pno=<%=페이지번호%>"> 	<%=페이지번호%></b>   </a></div>
	     <% }else { %>
	       <div><a href="list?pno=<%=페이지번호%>"><%=페이지번호 %></a></div>
	     <% } %>	

                    
               <%
		    	}
				%>
				
					<%
			if (요청페이지번호 != 마지막페이지번호) {
		%>

			<a href="list?pno=<%=nextPage%>">▶</a>
			 <a href="list?pno=<%=출력마지막페이지번호 + 1%>">▶▶</a>
			<a href="list?pno=<%=마지막페이지번호%>">E</a>
		<%
			}
		%>
                </div>
                	
		
            </li>
            
            
            
            <input type="button" value="새글쓰기" onclick="location.href='preparewrite'"/>
            

            <!-- 검색 폼 영역 -->
            <li id='liSearchOption'>
                <div>
                    <select id='selSearchOption' >
                        <option value='A'>제목+내용</option>
                        <option value='T'>제목</option>
                        <option value='C'>내용</option>
                    </select>
                    <input id='txtKeyWord' />
                    <input type='button' value='검색'/>
                </div>
                </li>

        </ul>
    </div>
    <script type="text/javascript">

    
    </script>
</body>
</html>