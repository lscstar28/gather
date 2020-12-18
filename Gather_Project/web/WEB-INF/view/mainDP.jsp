<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="asset/css/main.css">
</head>
<body>
	<!-- head -->
	<%@ include file="/WEB-INF/view/deco/head.jsp"%>
	<c:if test="${!empty list}">
		<div class="wrap">
			<!-- side -->
			<%@ include file="/WEB-INF/view/deco/side.jsp"%>

			<!-- body(team) -->

			<div class="body">
				<!-- ========== 팀 ========== -->
				<h3>팀 소개</h3>
				<%-- 				팀 번호 : ${tIdx} --%>
				<h4>
					팀 이름 : ${tName} <input type="button" value="수정"
						onclick="location.href='UpTeamPg.do?mIdx=${mIdx}&tName=${tName}&tIdx=${tIdx}'">
				</h4>
				<input type="button" value="탈퇴하기"
					onclick="location.href='escape.do?mIdx=${sessionScope.logOK.m_idx}&tIdx=${tIdx}'"><br>
				-----팀원 -----<br>
				<c:forEach items="${mlist}" var="ob">
					${ob}<br>
				</c:forEach>
				<c:if test="${clist[0] != null}">
					-----응답 대기중-----<br>
					<c:forEach items="${clist}" var="ob">
		 				${ob}<br>
					</c:forEach>
				</c:if>
				<input type="button" value="추가하기"
					onclick="location.href='callMemPg.do?mIdx=${mIdx}&tIdx=${tIdx}'"><br>
			</div>

			<div class="body">
				<!-- ========== 기획 ========== -->
				<h3>기획</h3>
				<c:if test="${!empty des.dName}">
					기획 주제 : ${des.dName}<br>
					-----기획목적 -----<br>
					<c:forEach items="${purp}" var="ob">
						${ob}<br>
					</c:forEach>
					<input type="button" value="추가하기">
					<br>
					-----기획내용-----<br>
					<c:forEach items="${dCon}" var="ob">
						${ob}<br>
					</c:forEach>
					<input type="button" value="추가하기">
					<br>
				</c:if>
				<c:if test="${empty des.dName}">
					<a href='designInsert.do?tIdx=${tIdx}'>기획 만들기</a>
				</c:if>
			</div>

			<div class="body">
				<!-- ========== 업무/진행 ========== -->
				<h3>업무/진행</h3>
				<c:if test="${!empty wlist}">
					-----업무 -----<br>
					<c:forEach items="${wlist}" var="ob">
						${ob.work} -- ${ob.wMem} <br>
					</c:forEach>
					<input type="button" value="추가하기"
						onclick="location.href='workInsert.do?tIdx=${tIdx}'">
					<br>
		
					업무 총 기한 :  <input type="button" value="수정하기">
					<br>
					<br>
					-----진행도-----<br>
					<c:forEach items="${wlist}" var="ob">
						<c:if test="${ob.wProc>=2}">
							${ob.work} / 진행 완료 / <input type="button" value="취소"
								onclick="location.href='workStateChange.do?widx=${ob.wIdx} &wproc=${ob.wProc}'">
							<br>
						</c:if>
						<c:if test="${ob.wProc==1}">
							${ob.work} / 진행 중  / <input type="button" value="진행 완료"
								onclick="location.href='workStateChange.do?widx=${ob.wIdx} &wproc=${ob.wProc}'">
							<br>
						</c:if>
						<c:if test="${ob.wProc==0}">
							${ob.work} / 진행 전 / <input type="button" value="진행 시작"
								onclick="location.href='workStateChange.do?tIdx=${tIdx}&widx=${ob.wIdx}&wproc=${ob.wProc}'">
							<br>
						</c:if>
					</c:forEach>
					-----진행 날짜-----<br>
					<c:forEach items="${wlist}" var="ob">
						${ob.work} / ${ob.wSDate} ~ ${ob.wEDate}<br>
					</c:forEach>
				</c:if>
				<c:if test="${empty wlist}">
					<a href='workInsert.do?tIdx=${tIdx}'>업무/진행 만들기</a>
				</c:if>
			</div>
		</div>
	</c:if>

	<!-- body -->
		
			<c:if test="${empty list}">
			<div class="wrap">
				<div class="side">
					<ul style="list-style: none;">
						<li><a href='CreTeamPg.do?mIdx=${sessionScope.logOK.m_idx}'>팀
								만들기</a></li>
					</ul>
				</div>
				<div class="body">
					현재 참여하고 있는 팀이 없습니다.
				</div>
			</div>
	</c:if>
</body>
</html>