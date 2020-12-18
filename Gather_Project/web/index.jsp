<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="asset/css/main.css">
</head>
<body>
<c:if test="${!empty sessionScope.logOK}">
	<c:url var="url1" value="mainDP.do?"/>
	<c:redirect url="${url1}"/>
</c:if>
<%@ include file="/WEB-INF/view/deco/head.jsp" %>
<div class="wrap">
	<div class="body">
		<a href="/gather/join.do">회원가입</a><br>
		<a href="/gather/login.do">로그인창으로</a>
	</div>
</div>
</body>
</html>