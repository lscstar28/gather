<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
    
    	<h3 style="text-align: center;">팀 목록</h3>
		<ul style="list-style: none;">
		<c:forEach items="${sessionScope.list}" var="ob">
			<li><a href ="LastTeam.do?tIdx=${ob.tIdx}&mIdx=${mIdx}" style="color: #2E2604; font-weight: bold;">&nbsp;${ob.tName}</a></li>
		</c:forEach>
		</ul>
		<br>
		<ul style="list-style: none;">
			<li><a href='CreTeamPg.do?mIdx=${sessionScope.logOK.m_idx}' style="color: #2E2604; font-weight: bold;">&nbsp;팀 만들기</a></li>
			<c:if test="${!empty confirmList}">
			<h3 style="text-align: center;">응답 대기중</h3>
				<c:forEach items="${confirmList}" var="ob">
					<li>${ob.tIdx} : ${ob.tName}<br>
					<form name="confrim" action="confrim.do" method="POST">
						<input type="hidden" name="tIdx" value="${ob.tIdx}" />
						<input type="hidden" name="mIdx" value="${sessionScope.logOK.m_idx}" />
						<input type="hidden" name="ptIdx" value="${sessionScope.tIdx}" />
						<input type="submit" value="수락">
					</form>
					<form name="confrim" action="noConfrim.do" method="POST">
						<input type="hidden" name="tIdx" value="${ob.tIdx}" />
						<input type="hidden" name="mIdx" value="${sessionScope.logOK.m_idx}" />
						<input type="hidden" name="ptIdx" value="${sessionScope.tIdx}" />
						<input type="submit" value="취소">
					</form>
					</li>
				</c:forEach>
			</c:if>
		</ul>
