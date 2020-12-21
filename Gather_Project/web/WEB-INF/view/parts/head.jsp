<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
	<h1 style="padding-left: 10px;"><a href="/gather/index.jsp">Gather</a></h1>
		<c:if test="${empty sessionScope.logOK}">
			<div class="member" style="padding-right: 10px;">
				<a href="/gather/login.do">log in</a><br>
				<a href="/gather/join.do">join up</a>
			</div>
		</c:if>
	<c:if test="${!empty sessionScope.logOK}">
		<div class="member" style="padding-right: 10px;">
			회원 이름 : ${sessionScope.logOK.name}
			<input type="button" value="logout" onclick="location.href='logout.do'"><br>
		</div>
	</c:if>
