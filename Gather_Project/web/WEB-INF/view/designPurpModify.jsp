<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	function checkBoardWrite() {
		if (document.designWriteForm.d_purp.value == "") {
			alert("기획목적을 입력하세요");
			designWriteForm.d_purp.focus();
		}else {
			document.designWriteForm.submit();
		}
	}
</script>
<body>
<form name="designWriteForm" method="post" action="designPurpUpdate.do">
	<input type="hidden" id="dIdx" name="dIdx" value="${entity.d_Idx}"><br>
	<input type="hidden" id="dp_Idx" name="dp_Idx" value="${entity.dp_Idx}"><br>

	<h3>기획</h3>
	<table border="1">
		<tr>
			<td>기획목적</td>
			<td>
				<input type="text" id="d_purp" name="d_purp" size="50" value="${entity.d_Purp}" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="저장하기" onclick="checkBoardWrite();" />
				<input type="reset" value="다시작성" />
			</td>
		</tr>
	</table>

</form>

</body>
</html>