<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="CreTeam.do" method="post" class="members">
	<input type="hidden" name="mIdx" value="${mIdx}"><br>
	<input type="text" name="tName" placeholder="팀 이름"><br>
<!-- 	<input type="text" name="tMem" placeholder="초대할 팀원의 아이디를 입력하세요"><br> -->
<!-- 	<input type="text" name="tMem" placeholder="초대할 팀원의 아이디를 입력하세요"><br> -->
<!-- 	<input type="button" class="btnAdd" value="팀원 추가하기">  -->
	<input type="submit" value="팀 만들기"> 
</form>
</body>
</html>