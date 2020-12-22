<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="asset/css/Workspace.css">
</head>
<body>
	<!-- head -->
	<div class="head">
	<%@ include file="/WEB-INF/view/parts/head.jsp" %>
	</div>
	
	<!-- ${!empty list} start -->
	<c:if test="${!empty list}">
	<div class="wrap">
	
		<!-- side -->
		<div class="side">
			<%@ include file="/WEB-INF/view/parts/side.jsp"%>
		</div>
		
		<!-- body -->
		<div class="body">
		
			<!-- mainCon -->
			<div class="mainCon">
					<!-- ========== 팀 소개 ========== -->
					
					<div class="tab">
					<h3>팀 이름 : ${tName} <input type="button" value="수정" onclick="location.href='UpTeamPg.do?mIdx=${mIdx}&tName=${tName}&tIdx=${tIdx}'"> <input type="button" value="팀 탈퇴하기" onclick="location.href='escape.do?mIdx=${sessionScope.logOK.m_idx}&tIdx=${tIdx}'"></h3>
					<!-- 팀원 테이블 -->
					<table>
						<tr>
						<td class="thead">-----팀원 -----</td>
						</tr>
						<c:forEach items="${mlist}" var="ob">
						<tr>
						<td>${ob}</td>
						</tr>
						</c:forEach>
						<c:if test="${clist[0] != null}">
						<tr>
						<td class="thead">-----응답 대기중 -----</td>
						</tr>
						<c:forEach items="${clist}" var="ob">
						<tr>
						<td>${ob}</td>
						</tr>
						</c:forEach>
						</c:if>
						<tr>
						<td><input type="button" value="추가하기" onclick="location.href='callMemPg.do?mIdx=${mIdx}&tIdx=${tIdx}'"></td>
						</tr>
					</table>
					</div>
					<!-- 팀원 테이블  end -->
					<br>
					<h3><a href="conference.do?tIdx=${tIdx}"> - 회의록 -</a></h3>
					<br>
					<!-- ========== 기획 ========== -->
					<div class="tab">
					<h3>기획</h3>
					<c:if test="${!empty des.dName}">
					<table>
						<tr>
						<td class="thead">기획 주제 </td>
						</tr>
						<tr>
						<td><a href="designModify.do?dIdx=${des.dIdx}&dName=${des.dName}">${des.dName}</a></td>
						</tr>
					</table>
					<div class="listBox">
						<div class="parts">
						<table>
							<tr>
							<td class="thead" colspan="2">-----기획목적 -----</td>
							</tr>
							<c:if test="${!empty purp}">
								<c:forEach items="${purp}" var="ob">
								<tr>
								<td><a href="designPurpModify.do?d_Purp=${ob.d_Purp}&dp_Idx=${ob.dp_Idx}&dIdx=${des.dIdx}">${ob.d_Purp}</a></td>
								<td width="30px"><input type="button" value="삭제" onclick="location.href='designPurpDelete.do?dp_Idx=${ob.dp_Idx}'"></td>
								</tr>
								</c:forEach>
							</c:if>
							<tr>
							<td colspan="2"><input type="button" value="추가하기" onclick="location.href='designPurpInsert.do?dIdx=${des.dIdx}'"></td>
							</tr>
						</table>
						</div>
						<div class="parts">
						<table>
							<tr>
							<td class="thead" colspan="2">-----기획내용-----</td>
							</tr>
							<c:if test="${!empty purp}">
								<c:forEach items="${dCon}" var="ob">
								<tr>
								<td><a href="designConModify.do?d_Con=${ob.d_Con}&dc_Idx=${ob.dc_Idx}&dIdx=${des.dIdx}">${ob.d_Con}</a></td>
								<td width="30px"><input type="button" value="삭제" onclick="location.href='designConDelete.do?dc_Idx=${ob.dc_Idx}'"></td>
								</tr>
								</c:forEach>
							</c:if>
							<tr>
							<td colspan="2"><input type="button" value="추가하기" onclick="location.href='designConInsert.do?dIdx=${des.dIdx}'"></td>
							</tr>
						</table>
						</div>
					</div>
					</c:if>
					<c:if test="${empty des.dName}">
						<a href='designInsert.do?tIdx=${tIdx}'>기획 만들기</a>
					</c:if>
					</div>
					
					
					<!-- ========== 업무/진행 ========== -->
					<div class="tab">
					<h3>업무/진행</h3>
					<c:if test="${!empty wlist}">
					<table>
						<tr>
						<td colspan="3" class="thead">-----업무 -----</td>
						</tr>
						<tr>
						<td>업무 이름</td>
						<td>담당자</td>
						<td>삭제</td>
						</tr>
						<c:forEach items="${wlist}" var="ob">
						<tr>
						<td><a href="workModify.do?wIdx=${ob.wIdx}">${ob.work}</a></td>
						<td>${ob.wMem}</td>
						<td width="30px"><input type="button" value="삭제" onclick="location.href='workDelete.do?wIdx=${ob.wIdx}'"></td>
						</tr>
						</c:forEach>
						<tr>
						<td colspan="3"><input type="button" value="추가하기" onclick="location.href='workInsert.do?tIdx=${tIdx}'"></td>
						</tr>
					</table>
					<div class="listBox">
						<div class="parts">
							<table>
								<tr>
								<td colspan="3" class="thead">-----진행도 -----</td>
								</tr>
								<tr>
								<td>업무 이름</td>
								<td>진행 상황</td>
								<td>진행 상황 변경</td>
								</tr>
								<c:forEach items="${wlist}" var="ob">
									<c:if test="${ob.wProc>=2}">
									<tr>
									<td>${ob.work}</td>
									<td>진행 완료</td>
									<td><input type="button" value="취소"onclick="location.href='workStateChange.do?widx=${ob.wIdx} &wproc=${ob.wProc}'"></td>
									</tr>
									</c:if>
									<c:if test="${ob.wProc==1}">
									<tr>
									<td>${ob.work}</td>
									<td>진행 중</td>
									<td><input type="button" value="진행 완료" onclick="location.href='workStateChange.do?widx=${ob.wIdx} &wproc=${ob.wProc}'"></td>
									</tr>
									</c:if>
									<c:if test="${ob.wProc==0}">
									<tr>
									<td>${ob.work}</td>
									<td>진행 전</td>
									<td><input type="button" value="진행 시작" onclick="location.href='workStateChange.do?tIdx=${tIdx}&widx=${ob.wIdx}&wproc=${ob.wProc}'"></td>
									</tr>
									</c:if>
								</c:forEach>
							</table>
						</div>
						<div class="parts">

							<table>
								<tr>
								<td colspan="3" class="thead">-----진행 날짜 -----</td>
								</tr>
								<tr>
								<td>업무 이름</td>
								<td>진행 시작 날짜</td>
								<td>진행 종료 날짜</td>
								</tr>
								<c:forEach items="${wlist}" var="ob">
								<tr>
								<td>${ob.work}</td>
								<td>${ob.wSDate}</td>
								<td>${ob.wEDate}</td>
								</tr>
								</c:forEach>
							</table>
						</div>
					</div>
					</c:if>
					<c:if test="${empty wlist}">
						<a href='workInsert.do?tIdx=${tIdx}'>업무 추가</a>
					</c:if>
					</div>
					
					<br>
			</div>
		</div>
	</div>
	</c:if><!-- ${!empty list}  end -->
	
	<!-- ${empty list} start -->
	<c:if test="${empty list}">
		<div class="wrap">
			<div class="side">
				<%@ include file="/WEB-INF/view/parts/side.jsp"%>
			</div>
			<div class="body">
				<div class="mainCon">
					<br>
					현재 참여하고 있는 팀이 없습니다.
					<br>
				</div>
			</div>
		</div>
	</c:if><!-- ${empty list}  end -->
	
	<div class="foot">
	
		<%@ include file="/WEB-INF/view/parts/foot.jsp"%>

	</div>
</body>
</html>