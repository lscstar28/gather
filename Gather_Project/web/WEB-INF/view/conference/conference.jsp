<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="asset/css/main.css">
</head>
<body>
<%@ include file="/WEB-INF/view/deco/head.jsp"%>

	<div class="wrap">
			<!-- side -->
			<%@ include file="/WEB-INF/view/deco/side.jsp"%>

	<div class="body">
	<c:if test="${!empty conferenceList}">
		<c:forEach items="${conferenceList}" var="ob">
			<br>팀 번호: ${ob.t_idx}<br>
			회의 번호: ${ob.c_Idx}<br>
			회의 제목: ${ob.c_title}<br>
			회의 내용: ${ob.c_content}<br>
			회의 작성날짜: ${ob.c_date}<br>
			<input type="button" value="삭제하기" onclick="location.href='conferenceDelete.do?cIdx='+'${ob.c_Idx}'">
			<input type="button" value="수정하기" onclick="location.href='conferenceModify.do?cIdx='+'${ob.c_Idx}'"><br>
		</c:forEach>
	</c:if>
	<input type="button" value="회의 추가하기" onclick="location.href='conferenceInsert.do?tIdx=1'"><br>
	</div>
	</div>
</body>
</html>