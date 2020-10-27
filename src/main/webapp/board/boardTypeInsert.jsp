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
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	
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


				<form id="insert" class="form-horizontal" role="form" action="${cp}/boardTypeInsert" method="post">
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">게시판 이름</label>
						<div class="col-sm-10">
							<input type="text" id="board_name" name="board_name" >
							
							<select name="board_use_check">
								<option value="0">사용</option>
								<option value="1">미사용</option>
							</select>
							<button id="insertBtn" type="submit" class="btn btn-default">생성</button>
						</div>
					</div>
				</form>
				
					<div class="form-group">
						<c:forEach items="${btvList}" var="btvList" >
							<form id="update" class="form-horizontal" role="form" action="${cp}/boardTypeUpdate" method="post">
							<label for="boardNm" class="col-sm-2 control-label">게시판 이름</label>
							<div class="col-sm-10">
							<input type="text"  name="board_name" value="${btvList.board_name}"> 
							<input type="hidden" name="board_type_no" value="${btvList.board_type_no}">
							
							<select name="board_use_check">
								<c:if test="${btvList.board_use_check == 0}">
									<option value="0" selected>사용</option>
									<option value="1">미사용</option>
								</c:if>
								<c:if test="${btvList.board_use_check == 1}">
									<option value="0">사용</option>
									<option value="1"selected>미사용</option>
								</c:if>	
							</select>
							<button id="updateBtn" type="submit" class="btn btn-default">수정</button><br>
							</div>
							</form>
						</c:forEach>
					</div>
						
			</div>
		</div>
	</div>
</body>
</html>
