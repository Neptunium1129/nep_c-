<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
             <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>

    <link id="bs-css" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
      <link rel="stylesheet" type="text/css" href="http://legacy.semantic-ui.com/stylesheets/semantic.css">
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	

	<style>


body {
    background-color: #e1e4e6;
}

.bsubject {
    margin: 0 0 0 20px;
    padding: 20px;
}

.ui.info.message {
    border-radius: 18px;
    width: 95%;
    padding: 0;
    margin-left: 2%;
    border: 1px dotted;
	}

	.viewcontent {
    padding: 10px;
    background: #fff;
    text-align: center;
    font-size: 12px;
    line-height: 1.8;
    text-align: left;
    margin-bottom: 10px;
    border: 1px dotted #ccc;
    word-wrap: break-word;
    padding-top: 20px;
    padding-bottom: 20px;
}

.memoTextarea {
    width: 94%;
    height: 100px;
    font-size: 12px;
    line-height: 160%;
    letter-spacing: -.5px;
    background-repeat: no-repeat;
    padding: 6px;
}

textarea#memoText {
    margin: 1px 12px;
}

input#memo_insert_submit_image {
    margin: 4px 24px 5px 15px;
}

.view_menu {
    margin-top: 45px;
}

.memoWrapperDiv {
    position: relative;
    border: 1px solid #B6B7CB;
    margin-bottom: 6px;
    background: url(http://www.todayhumor.co.kr/board/images/memo_wrapper_bottom_shadow01.gif) repeat-x; 
	    padding: 12px 12px 4px 0px;
}
.memoDiv {
    padding: 15px 15px 10px 15px;
    font-size: 12px;
    /* padding: 10px 5px 1px 5px; */
    /* background-color: white; */
    position: relative;
    /* padding-bottom: 9px; */
    /* background-color: rgb(249, 249, 249); */
    /* border: 1px solid #EBF6F8; */
    /* border-right: 1px solid #DFE3E4; */
    /* border-left: 1px solid #DFE3E4; */
}

.memoName {
font-weight: bold;
    margin-right: 10px;
    margin-left: 12px;
}
.memoDate {
    margin-right: 3px;
    font-family: tahoma;
    font-size: 11px;
}

.memoContent {
margin: 20px 0 5px 5px;
    word-wrap: break-word;
    padding: 0px 0px 30px 7px;
}

.memoDelBtn {
    width: 20px;
    height: 20px;
    margin-top: 6px;
    background-image: url(http://www.todayhumor.co.kr/board/images/memo_del04.gif);
    background-repeat: no-repeat;
    cursor: pointer;
    float: left;
}
.memoOkNokDelDiv {
    /* display: inline; */
    float: right;
    /* border: 1px solid red; */
    position: relative;
}

div#memoContainerDiv {
    padding: 1px 15px 1px 15px;
}



            @media screen and (max-width: 400px) {
               .vertical_container.cf {
    width: 100%;
    margin: 0 auto;
    background: white;
}
            }
            @media screen and  (min-width: 400px) {
                  .vertical_container.cf {
    width: 70%;
    margin: 0 auto;
    background: white;
}
  
            }
            @media screen and (min-width: 801px) {
               .vertical_container.cf {
    width: 50%;
    margin: 0 auto;
    background: white;
}
			 
            }


.whole_box {
	width:65%
    margin: 45px auto;
    padding: 10px;
    background-color: #e1e4e6;
}

.table_container_1 {
    width: 100%;
    background-color: white;
    padding: 0px 0;
    margin-top: 60px;
}

.table_container_2 {
    width: 100%;
    background-color: white;
    padding:20px 14px;
    margin-top: 60px;
}


.comment_area {
    margin-left: 1%;
}

.deneycomment {
text-align: center;
    font-size: x-large;
    font-weight: bold;
}
.ui.warning.message, .ui.yellow.message {
    background-color: #F6F3D5;
    color: #96904D;
}



	</style>
</head>
<body>

<div class="whole_box" style="background-color:#e1e4e6;">

	<div class="vertical_container cf" >


		<!-- table_container에서 양쪽 흰색 여백을 좀 가지고 있음-->
		<div class="table_container_1">

<div class="table_container_2">
<input type="hidden" id="bidx" value="38">
<input type="hidden" id="bid" value="admin">


			<div class='ui warning message'>

					<div>게시물ID :${views.no}</div>
					<div>작성자 : ${views.writer} </div>		
					<div>가격 : ${views.price}</div>
					<div>댓글 : <span id="cn">0</span>개</div>
					<div>${views.makeday}</div>
					</div>


					<div class="ui info message" >
			<div class="bsubject">${views.title}</div>
			</div><!--viewSubjectDiv-->

					<div class="viewcontent">
					<img width="100%" height=auto src="img/${views.img}"/>
					
					<p>asdasd</p>
</div>
				
			
			</div>

<a class="btn btn-primary" href="comment_list?board_num=${views.no}" >댓글보기</a>
<div class="table_container">

			
			<div id='memoContainerDiv'></div>
				<c:forEach var="cc" items="${d_comment}"> 
					<div class="memoWrapperDiv">
							<div class="memoInfoDiv">
									<div class="memoOkNokDelDiv">
											<div class="memoDelBtn" title="" onclick="c_del('','');">
											</div>
									</div>
							<span class="memoName" title="">${cc.c_writer}</span>
							<span class="memoDate"></span>
							</div>
							<div class="memoContent">
							${cc.c_contents}<br>
							</div>
					</div>
	</c:forEach>
	
	
				<form name="comment_form" id="comment_form" enctype="multipart/form-data" method="post">
				<input type="hidden" name="parent_id" id="parent_id" value="${views.no}">
				<input type="text" name="m_name" id="m_name" value="댓글작성자">

					
										<div class="memoWriteNameFormDiv">
						<b><span style="color:#FF8C00;margin-left: 3%;">*  </span>admin</b> 
				</div>				 

				<div class="comment_area" style="position: relative;">

					<textarea id="memoText" tabindex="1" name="memoText" class="memoTextarea" placeholder=""></textarea>						
				</div>
				<div class="memoImageInputDiv">
				<div style="float:right">
						
						<input width="70%" type="image" id="memo_insert_submit_image" tabindex="2" src="http://www.todayhumor.co.kr/board/images/memo_confirm.gif?1" />

											</div>
				</div><!--memoImageInputDiv-->
				</form>
			
			<div class="view_menu">
		
						   	<a href="" class="btn btn-primary">수   정</a>
				<a href="" id="delete_b" class="btn btn-warning">삭	제</a>
									<a href="daerim" class="btn btn-info">목	록</a>
				</div>
				
						

		</div>


				
						

		</div>


		
					

</div>


<script type="text/javascript">


$(document).ready(function() { 






		$("#memo_insert_submit_image").click(function() {


//.replace(/\n/g, '<br>')

		var formData= $("#comment_form").serialize();
	 //  alert(decodeURIComponent(formData));

		$.ajax({
			type : 'POST',
			url : 'comment_write',
			data : formData,
			success : function(response){
			 alert("작성 완료");

				if(response == 'success'){
				//	alert("success");
				//	getAllList();
				}
			}
		});
    });


			$("#delete_b").click(function() {

				//alert($("input#bidx").val());
				//alert($("input#bid").val());


		if (window.confirm("한번 삭제한 자료는 복구할 방법이 없습니다.\n정말 삭제하시겠습니까?")) {
			$.post('', 
			{ 
			  mode:"delete", 
			  id:$("input#bidx").val(),
				bid:$("input#bid").val()
			}, function(data){

					
			});

			 alert('삭제됬습니다.'); location.replace("board.php#f");
		}else{
			return false;
		}
	
	});

			

  });




		function c_del(aa,bb){
		var aa;
		var bb;
		// var i = $(".memoDelBtn").index(this); 
		//alert($(".memoDelBtn").attr("title"));
		//alert(aa);
		//alert(bb);
			
		//alert($(".memoDelBtn").eq(i).attr("title"));
			
	
		
		
		
		//alert("해당 아이디 : "+$(this).attr("title"));
		if (window.confirm("댓글을 삭제하시겠습니까?")) {
			$.post('', 
			{ 
			  mode:"c_delete", 
			  cid:aa,
			  maker:bb
			 // makeer:
			}, function(data){
				if(data==0){

					alert('삭제됬습니다.');
					self.location.reload();

				}else{

					alert('잘못된 시도입니다.');
				
				}
				
				//self.location.reload();
			});
		}else{
			return false;
		}
	

	}

	
</script>

</body>
</html>