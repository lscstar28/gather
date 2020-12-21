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
기획<br>
----------------------------<br /><br />
<input type="button" value="기획내용 추가하기" onclick="location.href='designConInsert.do?dIdx=${dIdx}'"><br>
	
	<c:if test="${!empty designConList}">
	
		<c:forEach items="${designConList}" var="ob">
			<br>기획 번호: ${ob.d_Idx}<br>
			기획내용번호: ${ob.dc_Idx}<br>
			기획내용: ${ob.d_Con}<br>
			<input type="button" value="삭제하기" onclick="location.href='designConDelete.do?d_Con=${ob.d_Con}&dIdx=${dIdx}'"><br>
			<input type="button" value="수정하기" onclick="location.href='designConModify.do?d_Con=${ob.d_Con}&dc_Idx=${ob.dc_Idx}&dIdx=${dIdx}'"><br>
		</c:forEach>
	</c:if>

</body>
</html>