<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Gather</h1>
	<input type="button" value="test" onclick="location.href='LastTeam.do?mIdx=3'">
		<input type="button" value="logout">
			<c:if test="${!empty list}">
				<ul style="list-style: none;">
				<c:forEach items="${list}" var="ob">
					<li>${ob.tIdx} : ${ob.tName}</li>
				</c:forEach>
					<li><a href='#'>팀 만들기</a></li>
				</ul>
				<h3>팀 소개</h3>
				팀 번호 : ${tIdx}
				팀 이름 : ${tname} <input type="button" value="수정"><br>
				-----팀원 -----<br>
				<c:forEach items="${mlist}" var="ob">
					${ob}<br>
				</c:forEach>
				<c:if test="${clist[0] != null}">
					-----응답 대기중-----<br>
					<c:forEach items="${clist}" var="ob">
		 				${ob}<br>
					</c:forEach>
					<input type="button" value="추가하기"><br>
				</c:if>
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
					<a href='design.do?tIdx=1'>기획주제 리스트보기</a><br/>
					<a href='designPurp.do?dIdx=1'>기획목적 리스트보기</a><br/>
					<a href='designCon.do?dIdx=1'>기획내용 리스트보기</a>
				</c:if>
				<h3>업무/진행</h3>	
				<c:if test="${!empty wlist}">
					-----업무 -----<br>
					<c:forEach items="${wlist}" var="ob">
						${ob.work} -- ${ob.wMem} <br>
					</c:forEach>
					<input type="button" value="추가하기"><br>
		
					업무 총 기한 :  <input type="button" value="수정하기"><br><br>
					-----진행도-----<br>
					<c:forEach items="${wlist}" var="ob">
						<c:if test="${ob.wProc>=3}">
							${ob.work} / 진행 완료 <br>
						</c:if>
						<c:if test="${ob.wProc==2}">
							${ob.work} / 진행 중  / <input type="button" value="진행 완료"><br>
						</c:if>
						<c:if test="${ob.wProc==1}">
							${ob.work} / 진행 전 / <input type="button" value="진행 시작"><br>
						</c:if>
					</c:forEach>
					-----진행 날짜-----<br>
					<c:forEach items="${wlist}" var="ob">
						${ob.work} / ${ob.wSDate} ~ ${ob.wEDate}<br>
					</c:forEach>
				</c:if>

			</c:if>
		<c:if test="${empty wlist}">
			<a href='#'>업무/진행 만들기</a>
			<a href='work.do?tIdx=1'>업무 리스트보기</a>
		</c:if>
		
		<c:if test="${empty wlist}">
			<a href='conference.do?tIdx=1&pg=1'>회의 리스트보기</a>
		</c:if>
		
		<c:if test="${empty list}">
			<ul style="list-style: none;">
				<li><a href='#'>팀 만들기</a></li>
			</ul>

			현재 참여하고 있는 팀이 없습니다.
		</c:if>
</body>
</html>