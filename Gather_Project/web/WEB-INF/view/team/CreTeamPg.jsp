<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<form action="CreTeam.do" method="post" class="members">
					<h4>팀 만들기</h4>
					<input type="hidden" name="mIdx" value="${mIdx}">
					<input type="text" name="tName" placeholder="팀 이름"> <input type="submit" value="팀 만들기"> 
				</form>
			</div>
		</div>
	</div>
	<div class="foot">
		<%@ include file="/WEB-INF/view/parts/foot.jsp"%>
	</div>


</body>
</html>