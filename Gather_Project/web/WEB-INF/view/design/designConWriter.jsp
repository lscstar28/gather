<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	function checkBoardWrite() {
		if (document.designWriteForm.d_con.value == "") {
			alert("기획내용을 입력하세요");
			designWriteForm.d_con.focus();
		} else {
			document.designWriteForm.submit();
		}
	}
</script>

<form name="designWriteForm" method="post" action="designConWriter.do">
	<input type="hidden" id="dIdx" name="dIdx" value="${dIdx}" /> 

	<h3>기획</h3>
	<table border="1">
		<tr>
			<td>기획내용</td>
			<td>
				<input type="text" id="d_con" name="d_con" size="50" />
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