<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="callMem.do" method="post" class="members">
	<input type="hidden" name="mIdx" value="${mIdx}"><br>
	<input type="hidden" name="tIdx" value="${tIdx}"><br>
	<input type="text" name="mId" placeholder="팀원 아이디를 입력하세요"><br>
	<input type="submit" value="추가하기"> 
</form>
</body>
</html>