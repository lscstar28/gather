<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
업무 수정
 <form id="workModify" method="post" action="workUpdate.do">
 		<input type="hidden" id="wIdx" name="wIdx" value="${entity.w_Idx}"><br>
 		업무 : <input type="text" id="workTitle" name="workTit" value="${entity.work}"><br>
 		담당자 : <input type="text" id="workManager" name="workMg" value="${entity.w_Mem}"><br>
 		<input type="submit" value="수정하기">
 </form>
</body>
</html>