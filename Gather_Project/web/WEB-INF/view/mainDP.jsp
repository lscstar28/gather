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
		팀 이름 : ${tname}<br>
		-----팀원 -----<br>
		<c:forEach items="${mlist}" var="ob">
		 ${ob}<br>
		</c:forEach>
		-----응답 대기중-----<br>
		<c:forEach items="${clist}" var="ob">
		 ${ob}<br>
		</c:forEach>
	<h3>기획</h3>
		기획 주제 : ${des.dName}<br>
		-----기획목적 -----<br>
		<c:forEach items="${purp}" var="ob">
		${ob}<br>
		</c:forEach>
		-----기획내용-----<br>
		<c:forEach items="${dCon}" var="ob">
		${ob}<br>
		</c:forEach>
	<h3>진행</h3>	
		-----업무 -----<br>
		<c:forEach items="${wlist}" var="ob">
		${ob.work} -- ${ob.wMem} <br>
		</c:forEach>
		업무 총 기한 : <br>
		-----진행도-----<br>
		<c:forEach items="${wlist}" var="ob">
		<c:if test=""></c:if>
		${ob.work} / ${ob.wProc} /  <br>
		</c:forEach>
		-----진행 날짜-----<br>
		<c:forEach items="${wlist}" var="ob">
		${ob.work} / ${ob.wSDate} ~ ${ob.wEDate}<br>
		</c:forEach>
</c:if>
<c:if test="${empty list}">
	<ul style="list-style: none;">
		<li><a href='#'>팀 만들기</a></li>
	</ul>
	
현재 참여하고 있는 팀이 없습니다.
</c:if>
</body>
</html>