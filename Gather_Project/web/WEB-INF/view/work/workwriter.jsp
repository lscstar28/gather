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
			<h4>업무 추가</h4>
				 <form id="workWriter" method="psot" action="workWriter.do">
				 		<input type="hidden" id="teamIdx" name="tIdx" value="${tIdx}">
				 		업무 : <input type="text" id="workTitle" name="workTit"><br>
				 		담당자 : <input type="text" id="workManager" name="workMg"><br>
				 		<input type="submit" value="추가하기">
				 </form>
			</div>
		</div>
	</div>
	<div class="foot">
		<%@ include file="/WEB-INF/view/parts/foot.jsp"%>
	</div>
</body>
</html>