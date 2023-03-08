<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
   <%--2023. 2. 22./Kosmo--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title></title>
<style></style>
<script></script>
</head>
<body>
<table>
<c:forEach var="item" items="${list}">
	<tr>
		<td>${item.SANUN}</td>
		<td>${item.SANAME}</td>
		<td>${item.SAPAY}</td>
		<td>${item.DEPTNO}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>