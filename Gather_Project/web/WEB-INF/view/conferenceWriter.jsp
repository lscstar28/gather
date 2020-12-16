<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	회의추가
	<form id="CFWriter" method="post" action="CFWriter.do">
	 		<input type="hidden" id="tIdx" name="tIdx" value="${tIdx}"><br>
	 		회의 제목: <input type="text" id="CFTitle" name="CFTitle"><br>
	 		회의 내용 : <input type="text" id="CFContent" name="CFContent"><br>
	 		<input type="submit" value="추가하기">
	 </form>	
</body>
</html>