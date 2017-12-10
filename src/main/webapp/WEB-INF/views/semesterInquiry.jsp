<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
	<table class="formtable" border="1">
		<tr>
			<td>년도</td>
			<td>학기</td>
			<td>이수 학점</td>
			<td>상세보기</td>
		</tr>
	<c:forEach var="offer" items="${offers}">
		<tr>
			<td>
				<c:out value="${offer.year}"></c:out>
			</td>
			<td>
				<c:out value="${offer.semester}"></c:out>
			</td>
			<td>
				<c:out value="${offer.credit}"></c:out>	
			</td>
			<td>
				<a href="${pageContext.request.contextPath}/linkDetail?year=${offer.year}&semester=${offer.semester}">링크</a>
			</td>
		</tr>
	</c:forEach>
	</table>

</body>
</html>