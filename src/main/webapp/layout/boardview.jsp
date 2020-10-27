<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="nav nav-sidebar">
		<li class="active"><a href="${cp}/boardTypeInsert">게시판 생성<span class="sr-only">(current)</span></a></li>
	<c:forEach items="${btvList}" var="btvList">
		<c:if test="${btvList.board_use_check == 0}">
		<li class="active"><a href="${cp}/boardList?board=${btvList.board_type_no}">${btvList.board_name}<span class="sr-only"></span></a></li>
		</c:if>
	</c:forEach>
</ul>