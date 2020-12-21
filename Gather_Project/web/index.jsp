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
			<h2>Welcome to Gather</h2>
			<p>Gather에 오신 것을 환영합니다.<br>
			저희 Gather에서는 기획자 여러분들의 다양한 기획을 도와드리기 위해 여러 기능을 제공하고 있습니다.<br>
			기본적인 팀 모집부터 기획 주제와 목적, 내용의 기록과 업무의 기록, 각 업무의 진행도를 확인할 수 있습니다.<br>
			앞으로 계속해서 다양한 기능의 업데이트를 준비중에 있으니 많은 기대와 참여 부탁드립니다. <br>
			감사합니다.</p>
		</div>
	</div>
	<div class="foot">
		<%@ include file="/WEB-INF/view/parts/foot.jsp"%>
	</div>
</div>	
</body>
</html>