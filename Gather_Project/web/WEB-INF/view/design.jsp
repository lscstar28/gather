<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script>
		
		$(document).ready(function(){
			
		});	
	</script>
	-->
</head>
<body>
기획<br>
<!-- 업무 총기한<br> -->
<!-- 진행도,진행날짜<br> -->
----------------------------<br /><br />
	<input type="button" value="기획 추가하기" onclick="location.href='designInsert.do?tIdx=1'"><br>
	
	
	<c:if test="${!empty designList}">
		<c:forEach items="${designList}" var="ob">
			<br>기획 번호: ${ob.d_Idx}<br>
			주제: ${ob.d_Name}<br>
			기획목적: ${ob.d_Purp}<br>
			기능(내용): ${ob.d_Con}<br>
			<input type="button" value="삭제하기" onclick="location.href='designDelete.do?dIdx='+'${ob.d_Idx}'"><br>
			<input type="button" value="수정하기" onclick="location.href='designModify.do?dIdx='+'${ob.d_Idx}'"><br>
		</c:forEach>
	</c:if>
</body>
</html>