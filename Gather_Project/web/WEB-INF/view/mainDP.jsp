<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Gather</h1>
<input type="button" value="logout">
<c:if test="${!empty list}">
	<ul style="list-style: none;">
	<c:forEach items="${list}" var="ob">
		
			<li>${ob.tIdx} : ${ob.tName}</li>
		
	</c:forEach>
		<li><a href=''>팀 만들기</a></li>
	</ul>
	
	<h3>팀 소개</h3>
	<h3>기획</h3>
	<h3>진행</h3>	
</c:if>
<c:if test="${empty list}">
	<ul style="list-style: none;">
		<li><a href=''>팀 만들기</a></li>
	</ul>
	
현재 참여하고 있는 팀이 없습니다.
</c:if>
</body>
</html>