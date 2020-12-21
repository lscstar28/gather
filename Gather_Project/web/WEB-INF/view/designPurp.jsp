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
<input type="button" value="기획목적 추가하기" onclick="location.href='designPurpInsert.do?dIdx=${dIdx}'"><br>
	<c:if test="${!empty designPurpList}">
		<c:forEach items="${designPurpList}" var="ob">
			<br>기획 번호: ${ob.d_Idx}<br>
			기획내용번호: ${ob.dp_Idx}<br>
			기획목적: ${ob.d_Purp}<br>
			<input type="button" value="삭제하기" onclick="location.href='designPurpDelete.do?d_Purp=${ob.d_Purp}&dIdx=${dIdx}'"><br>
			<input type="button" value="수정하기" onclick="location.href='designPurpModify.do?d_Purp=${ob.d_Purp}&dp_Idx=${ob.dp_Idx}&dIdx=${dIdx}'"><br>
		</c:forEach>
	</c:if>

</body>
</html>