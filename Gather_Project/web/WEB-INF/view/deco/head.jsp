<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<div class="head" style="height: 100px; width: 100%; background-color: #225C73; color: white;">
	<h1>Gather</h1>
	<c:if test="${!empty sessionScope.logOK}">
	회원 이름 : ${sessionScope.logOK.name}
	<input type="button" value="logout"><br>
	</c:if>
</div>	