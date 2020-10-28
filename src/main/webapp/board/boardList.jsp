<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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

<script>
	$(document).ready(function(){
		$("#boardList tr").on("click", function(){
			btitle = $(this).data("board_title");
			if(btitle.indexOf('**삭제된 게시글입니다**') != -1){
				
			}else{
				var board_no = $(this).data("board_no");
	
				document.location="board?board_no=" + board_no;
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
</div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>게시글 번호</th>
					<th>게시글 제목</th>
					<th>작성자</th>
					<th>작성 날짜</th>
				</tr>
				<tbody id="boardList">
					<c:forEach items="${boardList}" var="board">
						<tr data-board_no="${board.board_no}" data-board_title="${board.board_title}">
							<td>${board.board_no}</td>
							<td>${board.board_title}</td>
							<td>${board.user_id }</td>
							<!-- format : yyyy-MM-dd -->
							<td><fmt:formatDate value="${board.board_date }" pattern="yyyy-MM-dd"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<a class="btn btn-default pull-right" href="${pageContext.request.contextPath}/boardInsert?board=${board_type_no}">게시글 등록</a>
		<div class="text-center">
			<ul class="pagination">
				<c:choose>
					<c:when test="${page != 0 && page != 1}">
						  <li><a href="${pageContext.request.contextPath }/boardList?board=${board_type_no}&page=${1}"><<</a></li>
						  <li><a href="${pageContext.request.contextPath }/boardList?board=${board_type_no}&page=${page-1}"><</a></li>
					</c:when>
				</c:choose>
				
				<c:forEach var="i" begin="1" end="${pages}">
					<c:choose>
						<c:when test="${i == page}">
							<li class="active"><span>${i}</span></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath }/boardList?board=${board_type_no}&page=${i}">${i}</a></li>
						</c:otherwise>
					</c:choose>	
				</c:forEach>
				
				<c:choose>
					<c:when test="${page != pages}">
						  <li><a href="${pageContext.request.contextPath }/boardList?board=${board_type_no}&page=${page+1}">></a></li>
						  <li><a href="${pageContext.request.contextPath }/boardList?board=${board_type_no}&page=${pages}">>></a></li>
					</c:when>
				</c:choose> 	
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>
