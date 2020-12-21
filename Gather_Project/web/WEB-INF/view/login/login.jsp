<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="asset/css/Index.css">
</head>
<body>

<div class="contain">
	<div class="head">
	<%@ include file="/WEB-INF/view/parts/head.jsp" %>
	</div>
	<div class="wrap">
		<div class="body">
 			<form  method="post" action="checklogin.do">
				<table border="0" align="center" width="350">
					<tr>
						<td>아이디</td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="text" name="pw"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<input type="submit" value="로그인">
						<input type="reset" value="취&nbsp;&nbsp;소">
						</td>
					</tr>
				</table>
			</form><br>
		</div>
	</div>
	<div class="foot">
		<%@ include file="/WEB-INF/view/parts/foot.jsp"%>
	</div>
</div>	
</body>
</html>












