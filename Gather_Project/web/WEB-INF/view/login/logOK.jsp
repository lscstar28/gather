<%@page import="com.gather.entity.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
logInOk<br>
${sessionScope.logOK.m_idx}<br>
${sessionScope.logOK.name}<br>
<input type="button" value="메인화면으로" onclick="location.href='mainDP.do?mIdx=${sessionScope.logOK.m_idx}'">
</body>
</html>
