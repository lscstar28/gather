<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="asset/css/Workspace.css">
</head>
<body>
	<!-- head -->
	<div class="head">
	<%@ include file="/WEB-INF/view/parts/head.jsp" %>
	</div>
	<div class="wrap">
		<div class="side">
			<%@ include file="/WEB-INF/view/parts/side.jsp"%>
		</div>
		<div class="body">
			<div class="mainCon">
				<c:if test="${!empty conferenceList}">
					<c:forEach items="${conferenceList}" var="ob">
					<br>
						<table>
							<tr>
								<td style="width: 100px;">회의 제목 </td>
								<td>${ob.c_title}</td>
							</tr>
							<tr>
								<td colspan="2" >회의 내용</td>
							</tr>
							<tr>
								<td colspan="2" style="text-align: left;">${ob.c_content}</td>
							</tr>
							<tr>
								<td colspan="2">회의 작성 날짜 : ${ob.c_date}</td>
							</tr>
						</table>
						<br>
						<input type="button" value="삭제하기" onclick="location.href='conferenceDelete.do?cIdx='+'${ob.c_Idx}'">
						<input type="button" value="수정하기" onclick="location.href='conferenceModify.do?cIdx='+'${ob.c_Idx}'"><br>
					</c:forEach>
				</c:if>
				<br>
				<input type="button" value="회의 추가하기" onclick="location.href='conferenceInsert.do?tIdx=${tIdx}'"><br>
			</div>
		</div>
	</div>
	<div class="foot">
		<%@ include file="/WEB-INF/view/parts/foot.jsp"%>
	</div>
</body>
</html>