<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
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
<%@ include file="/layout/summer.jsp" %>

<script>
	$(document).ready(function() {
		var count = 0;
		var del_count = 0;
        $('.summernote').summernote({
	        width : 500,
			height: 300,
	        lang: "ko-KR"
        });

        $('#fileAddBtn').on('click', function(){
            var del = $('.del_file').length;
	        if(del + count >= 5){
	       	   alert("첨부파일은 5개까지 등록가능합니다")
	           return;
	        }
	        count++
	        $('#fileup').append("&nbsp;&nbsp;<input type='file' name='realfilename"+count+"'>")
	        $('#count').val(count)
	    })

	    $(".del_file").on("click", function() {
	        a = $(this).val();
	        del_count++
//	         삭제의 시퀀스 값을 주기 위해서 이름을 다다르게 하고 value값도 다 다르게 하기 위함의 append 
	        $('#fileup').append("<input type='hidden' name='del_files"+del_count+"' value='"+a+"'>")
	        
//	         countdel을 통해서 내가 updateServlet을 갈때 for문의 개수를 정해주기 위한 역할
			
	        $('#del_count').val(del_count)
	        $(this).parent().remove();

// 	        $(this).parent().siblings('label').remove();
	     })
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
			<h2>게시글 작성</h2>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form id="frm" class="form-horizontal" role="form" enctype="multipart/form-data" method="POST" action="${cp}/boardUpdate">
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">게시글 제목</label>
						<div class="col-sm-10">
							<input type=text name="board_title" style="width:500px;" value="${bv.board_title}">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">게시글 내용</label>
						<div class="col-sm-10">
							<textarea class="summernote" name="board_content" >${bv.board_content}</textarea>
						</div>
					</div>
					
					<label class="col-sm-2 control-label">첨부파일</label>
					<br><br><br>
					<c:forEach items="${fv}" var="fv">
					<div class="form-group">
						<div id="${fv.files_no}">
						&emsp;&emsp;&emsp;&emsp;${fv.real_files_name}
                        <button class="del_file" type="button" class="btn btn-default" value="${fv.files_no}">삭제</button>
                     	</div>
					</div>
					</c:forEach>
					<input type="hidden" name="board_no" value="${bv.board_no}">
					
					<div class="form-group">
						<button type="button" id="fileAddBtn">파일추가</button>
						<br>
						<div class="col-sm-10" id="fileup" class="col-sm-10">
						</div>
						<input id="count" name="count" type="hidden" value="0">
						<input id="del_count" name="del_count" type="hidden" value="0">
						<br>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default" >게시글수정</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>


					

					