<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
OK
<c:url var="url1" value="LastTeam.do?mIdx=${mIdx}&tIdx=${tIdx}">
</c:url>
<c:redirect url="${url1}"/>
</body>
</html>