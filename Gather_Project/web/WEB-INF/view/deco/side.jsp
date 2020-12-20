<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
    
<div class="side">
		<ul style="list-style: none;">
		<c:forEach items="${sessionScope.list}" var="ob">
			<li><a href ="LastTeam.do?tIdx=${ob.tIdx}&mIdx=${mIdx}" style="color: #2E2604; font-weight: bold;">${ob.tIdx} : ${ob.tName}</a></li>
		</c:forEach>
			<li><a href='CreTeamPg.do?mIdx=${sessionScope.logOK.m_idx}' style="color: #2E2604; font-weight: bold;">팀 만들기</a></li>
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
