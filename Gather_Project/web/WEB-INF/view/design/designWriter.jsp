<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	function checkBoardWrite() {
		if (document.designWriteForm.d_name.value == "") {
			alert("주제를 입력하세요");
			designWriteForm.d_name.focus();
		} else {
			document.designWriteForm.submit();
		}
	}
	
</script>

<form name="designWriteForm" method="post" action="designWriter.do">
	<input type="hidden" id="tIdx" name="tIdx" value="${tIdx}" />

	<h3>기획</h3>
	<table border="1">
		<tr>
			<td>주제</td>
			<td>
				<input type="text" id="d_name" name="d_name" size="50" />
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