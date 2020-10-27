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
        $('.summernote').summernote({
	        width : 500,
			height: 300,
	        lang: "ko-KR"
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
			<h2>게시글 작성</h2>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form id="frm" class="form-horizontal" role="form" enctype="multipart/form-data" method="POST" action="${cp}/boardDelete">
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
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default" >게시글삭제</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>


					

					