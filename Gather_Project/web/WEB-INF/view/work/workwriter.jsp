<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
업무 추가
 <form id="workWriter" method="psot" action="workWriter.do">
 		<input type="hidden" id="teamIdx" name="tIdx" value="${tIdx}"><br>
 		업무 : <input type="text" id="workTitle" name="workTit"><br>
 		담당자 : <input type="text" id="workManager" name="workMg"><br>
 		<input type="submit" value="추가하기">
 </form>
</body>
</html>