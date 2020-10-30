<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<%@ include file="/layout/commonLib.jsp" %>
<script>
	$(document).ready(function(){
		$("#upbutton").on("click", function(){
			document.location="boardUpdate?board_no=${bv.board_no}";
		});
		
		$("#delbutton").on("click", function(){
			document.location="boardDelete?board_no=${bv.board_no}";
		});

	
		$("button[id^=fileDownBtn]").on("click", function(){
			files_no = $(this).val();
			document.location="fileDownload?board_no=${bv.board_no}&files_no="+files_no;
		});
		
		$("button[id^=re_del_check]").on("click", function(){
			reply_no = $(this).val();
			document.location="replyDelete?board_no=${bv.board_no}&reply_no="+reply_no;
		});
		
		$("#gbutton").on("click", function(){
			document.location="boardGInsert?board=${bv.board_type_no}&board_no=${bv.board_no}";
		});

	
		 
		$('textarea').keyup(function() {

		    var content = $(this).val();
		    $('#counter').html("("+content.length+" / 최대 500자)");    //글자수 실시간 카운팅

		    if (content.length > 500){
		        alert("최대 500자까지 입력 가능합니다.");
		        $(this).val(content.substring(0, 200));
		        $('#counter').html("(200 / 최대 500자)");
		    }

		});

		

	});
</script>

</head>

<body>
	<%@ include file="/layout/header.jsp" %>
	
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/layout/boardview.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<form class="form-horizontal" role="form" enctype="multipart/form-data" >
<!-- 					<div class="form-group"> -->
<!-- 						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label> -->
<!-- 						<div class="col-sm-10"> -->
<!-- 							<input type="text" class="form-control" id="userId" name="userId" -->
<!-- 								placeholder="사용자 아이디"> -->
<!-- 						</div> -->
<!-- 					</div> -->

					<%-- <div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<img src="${cp}/profile/${mv.filename}"/>
							
							<img src="${cp}/profileImg?userid=${mv.userid}"/><br>
							<button id="profileDownBtn" type="button" class="btn btn-default">다운로드 : ${mv.realfilename}</button>
							
						</div>
					</div> --%>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">게시글 번호</label>
						<div class="col-sm-10">
							<label class="control-label" >${bv.board_no}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">게시글 제목</label>
						<div class="col-sm-10">
							<label class="control-label" >${bv.board_title}</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">게시글 내용</label>
						<div class="col-sm-10">
							<label class="control-label" >${bv.board_content}</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">작성 날짜</label>
						<div class="col-sm-10">
							<label class="control-label" ><fmt:formatDate value="${bv.board_date}" pattern="yyyy-MM-dd"/></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">작성자</label>
						<div class="col-sm-10">
							<label class="control-label" >${bv.user_id}</label>
						</div>
					</div>
					
					<c:forEach items="${fv}" var="fv">
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">첨부파일</label>
						<button id="fileDownBtn" type="button" class="btn btn-default" value="${fv.files_no}">${fv.real_files_name}</button>
					</div>
					</c:forEach>
					
					<c:if test="${S_MEMBER.user_id == bv.user_id }">
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="button" id="upbutton" class="btn btn-default" >게시글수정</button>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="button" id="delbutton" class="btn btn-default" >게시글삭제</button>
							</div>
						</div>
					</c:if>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="gbutton" class="btn btn-default" >답글쓰기</button>
						</div>
					</div>
					
					<hr>
					<h1>댓글</h1>
						<c:forEach items="${rv}" var="rv">
						<div style="width:auto; height:auto;" id="re" class="form-group">
						<hr>
						<input data-reply_no="${rv.reply_no}" type=hidden name="reply_no" value="${rv.reply_no}">
						<input type=hidden name="board_no" value="${bv.board_no}">
						<table>
							<tr>
								<td>
									<label class="control-label" >${rv.reply_content}&emsp;&emsp;&emsp;</label>
								</td>
								
								<td>
									<label class="control-label" ><fmt:formatDate value="${rv.reply_date}" pattern="yyyy-MM-dd"/>&emsp;&emsp;&emsp;</label>
								</td>
								<td>
									<label class="control-label" >${rv.user_id}&emsp;&emsp;</label>
								</td>
								<c:if test="${rv.reply_del_check == '0'}">
								<td>
									<button style="float:right;" type="button" id="re_del_check" value="${rv.reply_no}">댓글삭제</button> 
								</td>
								</c:if>
							</tr>	
						</table>
						</div>
						</c:forEach>
					
				
				
				</form>
				<form method="post" action="${cp}/replyInsert">
					
					
						<div class="form-group">
							<div class="col-sm-10">
								<input type="hidden" name="user_id" value="${S_MEMBER.user_id}"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-10">
								<input type="hidden" name="board_no" value="${bv.board_no}"/>
							</div>
						</div>

<br>
						<div class="form-group">
							<div>
								<textarea name="reply_content" style="width:700px; height:100px; resize:none;" ></textarea>
								<br>
								<span style="color:#aaa;" id="counter">(0 / 최대 500자)</span>
								<button type="submit" id="replybutton" class="btn btn-default" >댓글작성</button>
							</div>
						</div>
						
					
				</form>	
					<div hidden="true" class="form-group">
						<label for="pass" class="col-sm-2 control-label">게시판종류</label>
						<div class="col-sm-10">
							<label class="control-label" >${bv.board_type_no}</label>
						</div>
					</div>
					
					<div hidden="true" class="form-group">
						<label for="pass" class="col-sm-2 control-label">답글번호</label>
						<div class="col-sm-10">
							<label class="control-label" >${bv.board_group_no}</label>
						</div>
					</div>
			</div>
		</div>
	</div>
</body>
</html>
