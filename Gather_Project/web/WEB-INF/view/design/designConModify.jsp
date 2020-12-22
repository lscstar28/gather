<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="asset/css/Workspace.css">
</head>
<script>
	function checkBoardWrite() {
		if (document.designWriteForm.d_con.value == "") {
			alert("기획내용을 입력하세요");
			designWriteForm.d_con.focus();
		}else {
			document.designWriteForm.submit();
		}
	}
</script>
<body>
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
				<form name="designWriteForm" method="post" action="designConUpdate.do">
					<input type="hidden" id="dIdx" name="dIdx" value="${entity.d_Idx}"><br>
					<input type="hidden" id="dc_Idx" name="dc_Idx" value="${entity.dc_Idx}"><br>
					<h4>기획 내용 수정</h4>
					<table border="1">
						<tr>
							<td>기획내용</td>
							<td>
								<input type="text" id="d_con" name="d_con" size="50" value="${entity.d_Con}" />
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