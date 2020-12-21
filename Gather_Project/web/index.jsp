<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="asset/css/Index.css">
</head>
<body>

<c:if test="${!empty sessionScope.logOK}">
	<c:url var="url1" value="mainDP.do?"/>
	<c:redirect url="${url1}"/>
</c:if>

<div class="contain">
	<div class="head">
	<%@ include file="/WEB-INF/view/parts/head.jsp" %>
	</div>
	<div class="wrap">
		<div class="body">
			설명서가 들어갈 자리입니다.
			이미지로 들어갈 예정입니다.
		</div>
	</div>
	<div class="foot">
		<%@ include file="/WEB-INF/view/parts/foot.jsp"%>
	</div>
</div>	
</body>
</html>