<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<form id="CFWriter" method="post" action="CFModify.do">
				 	<input type="hidden" name="cIdx" value="${entity.c_Idx}">
				 	<input type="hidden" name="tIdx" value="${tIdx}">
					<h4>회의수정</h4>
					<table border="1" >
						<tr>
							<td style="width: 100px;">회의 제목</td>
							<td><input type="text" id="CFTitle" name="CFTitle" style="width: 98%;" value="${entity.c_title}"></td>
						</tr>
						<tr>
							<td style="width: 100px;">회의 내용</td>
							<td><textarea id="CFContent" name="CFContent"rows="15" style="resize: none; width: 98%;">${entity.c_content}</textarea></td>
						</tr>
					</table>
						<div style="text-align: center;"><input type="submit" value="수정하기"> <input type="reset" value="다시작성"></div>
				</form>		
			</div>
		</div>
	</div>
	<div class="foot">
		<%@ include file="/WEB-INF/view/parts/foot.jsp"%>
	</div>
</body>
</html>