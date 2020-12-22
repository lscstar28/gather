<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="asset/css/Workspace.css">
</head>
<body>
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
<!-- head -->
	<div class="head">
	<%@ include file="/WEB-INF/view/parts/head.jsp" %>
	</div>
	<div class="wrap">
		<div class="side">
			<%@ include file="/WEB-INF/view/parts/side.jsp"%>
		</div>
		<div class="body">
			<div class="mainCon">
				<form name="designWriteForm" method="post" action="designConWriter.do">
					<input type="hidden" id="dIdx" name="dIdx" value="${dIdx}" /> 
				
					<h4>기획 내용 작성</h4>
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
			</div>
		</div>
	</div>
	<div class="foot">
		<%@ include file="/WEB-INF/view/parts/foot.jsp"%>
	</div>
</body>
</html>