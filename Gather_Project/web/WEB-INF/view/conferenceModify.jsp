<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	회의수정
	<form id="CFModifyWrite" method="post" action="CFModify.do">
	 		<input type="hidden" id="cIdx" name="cIdx" value="${entity.c_Idx}"><br>
	 		<input type="hidden" id="pgnum" name="pg" value="${pg}"><br>
	 		회의 제목: <input type="text" id="CFTitle" name="CFTitle" value="${entity.c_title}"><br>
	 		회의 내용 : <input type="text" id="CFContent" name="CFContent" value="${entity.c_content}"><br>
	 		<input type="submit" value="수정하기">
	 </form>	
</body>
</html>