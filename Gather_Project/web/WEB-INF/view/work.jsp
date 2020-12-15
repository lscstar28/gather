<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script>
		
		$(document).ready(function(){
			
			
			
		});	
	</script>
</head>
<body>
업무1<br>
업무 총기한<br>
진행도,진행날짜<br>
----------------------------<br><br>
	<input type="button" value="업무 추가하기" onclick="location.href='workInsert.do?tIdx=1'"><br>
	<c:if test="${!empty workList}">
		<c:forEach items="${workList}" var="ob">
			<br>업무 번호: ${ob.w_Idx}<br>
			업무: ${ob.work}<br>
<%-- 			${ob.w_Proc}<br> --%>
			<c:if test="${ob.w_Proc eq '0'}">
			<input type="button" value="업무 시작" onclick="location.href='workStateChange.do?widx='+'${ob.w_Idx} &wproc='+'${ob.w_Proc}'"> <br>
			</c:if>
			<c:if test="${ob.w_Proc eq '1'}">
			<input type="button" value="업무 진행중" onclick="location.href='workStateChange.do?widx='+'${ob.w_Idx} &wproc='+'${ob.w_Proc}'"> <br>
			</c:if>
			<c:if test="${ob.w_Proc eq '2'}">
			<input type="button" value="업무 완료" onclick="location.href='workStateChange.do?widx='+'${ob.w_Idx} &wproc='+'${ob.w_Proc}'"> <br>
			</c:if>
			업무 시작 날짜: ${ob.w_SDate}<br>
			업무 종료 날짜: ${ob.w_EDate}<br>
			업무 담당자: ${ob.w_Mem}<br>
			업무 팀 번호: ${ob.t_idx}<br>
		</c:forEach>	
	</c:if>
</body>
</html>