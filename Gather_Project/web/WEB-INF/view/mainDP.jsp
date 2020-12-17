<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body, div, ul, li, h1, h2, h3, input, button {
padding: 0;
margin: 0;
}
a{
text-decoration:none;
color: black;
}
.side{
height: 700px; width: 200px; background-color: #A6958F; float: left;
}
input[type="button"]{
	background-color: #819BA6;
	border: none;
	cursor: pointer;
}
</style>
</head>
<body>
<!-- head -->
<div class="head" style="height: 100px; width: 100%; background-color: #225C73; color: white;">
	<h1>Gather</h1>
	회원 이름 : ${sessionScope.logOK.name}
	<input type="button" value="logout"><br>
</div>	


	<c:if test="${!empty list}">
	<!-- side -->
<div class="side">
		<ul style="list-style: none;">
		<c:forEach items="${list}" var="ob">
			<li><a href ="LastTeam.do?tIdx=${ob.tIdx}&mIdx=${mIdx}" style="color: #eee6c4; font-weight: bold;">${ob.tIdx} : ${ob.tName}</a></li>
		</c:forEach>
			<li><a href='CreTeamPg.do?mIdx=${sessionScope.logOK.m_idx}' style="color: #eee6c4; font-weight: bold;">팀 만들기</a></li>
			<c:if test="${!empty confirmList}">
			----- 응답 대기중인 팀 -----
				<c:forEach items="${confirmList}" var="ob">
			<li>${ob.tIdx} : ${ob.tName}
			<input type="button" value="수락" onclick="location.href='confrim.do?tIdx=${ob.tIdx}&mIdx=${sessionScope.logOK.m_idx}&ptIdx=${tIdx}'">
			<input type="button" value="취소" onclick="location.href='noConfrim.do?tIdx=${ob.tIdx}&mIdx=${sessionScope.logOK.m_idx}&ptIdx=${tIdx}'">
			</li>
				</c:forEach>
			</c:if>
		</ul>
</div>
		
<!-- body(team) -->

				<div class="team" style="background-color: #BFB6AE; border-bottom: 0.5px solid black;border-right: 0.5px solid black;">
			<!-- ========== 팀 ========== -->
				<h3>팀 소개</h3>
				팀 번호 : ${tIdx}
				팀 이름 : ${tName} <input type="button" value="수정" onclick="location.href='UpTeamPg.do?mIdx=${mIdx}&tName=${tName}&tIdx=${tIdx}'"><br>
				<input type="button" value="탈퇴하기" onclick="location.href='escape.do?mIdx=${sessionScope.logOK.m_idx}&tIdx=${tIdx}'"><br>
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
				<input type="button" value="추가하기" onclick="location.href='callMemPg.do?mIdx=${mIdx}&tIdx=${tIdx}'"><br>
				</div>
				
				<div class="design"  style="background-color: #BFB6AE; border-bottom: 0.5px solid black;border-right: 0.5px solid black;">
			<!-- ========== 기획 ========== -->
				<h3>기획</h3>
				<c:if test="${!empty des.dName}">
					기획 주제 : ${des.dName}<br>
					-----기획목적 -----<br>
					<c:forEach items="${purp}" var="ob">
						${ob}<br>
					</c:forEach>
					<input type="button" value="추가하기"><br>
					-----기획내용-----<br>
					<c:forEach items="${dCon}" var="ob">
						${ob}<br>
					</c:forEach>
					<input type="button" value="추가하기"><br>
				</c:if>
				<c:if test="${empty des.dName}">
					<a href='designInsert.do?tIdx=${tIdx}'>기획 만들기</a>
				</c:if>
				</div>
				
				<div  class="work" style="background-color: #BFB6AE;  border-bottom: 0.5px solid black;border-right: 0.5px solid black;">
			<!-- ========== 업무/진행 ========== -->
				<h3>업무/진행</h3>	
				<c:if test="${!empty wlist}">
					-----업무 -----<br>
					<c:forEach items="${wlist}" var="ob">
						${ob.work} -- ${ob.wMem} <br>
					</c:forEach>
					<input type="button" value="추가하기" 
					onclick="location.href='workInsert.do?tIdx=${tIdx}'"><br>
		
					업무 총 기한 :  <input type="button" value="수정하기"><br><br>
					-----진행도-----<br>
					<c:forEach items="${wlist}" var="ob">
						<c:if test="${ob.wProc>=2}">
							${ob.work} / 진행 완료 / <input type="button" value="취소"
							onclick="location.href='workStateChange.do?widx=${ob.wIdx} &wproc=${ob.wProc}'"><br>
						</c:if>
						<c:if test="${ob.wProc==1}">
							${ob.work} / 진행 중  / <input type="button" value="진행 완료"
							onclick="location.href='workStateChange.do?widx=${ob.wIdx} &wproc=${ob.wProc}'"><br>
						</c:if>
						<c:if test="${ob.wProc==0}">
							${ob.work} / 진행 전 / <input type="button" value="진행 시작" 
							onclick="location.href='workStateChange.do?tIdx=${tIdx}&widx=${ob.wIdx}&wproc=${ob.wProc}'"><br>
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
			</c:if>
			
<!-- body -->

	<c:if test="${empty list}">
	<div class="side">
		<ul style="list-style: none;">
			<li><a href='CreTeamPg.do?mIdx=${sessionScope.logOK.m_idx}'>팀 만들기</a></li>
		</ul>
	</div>
	
		현재 참여하고 있는 팀이 없습니다.
	</c:if>
</body>
</html>