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
			<td>교필</td>
			<td>핵교A</td>
			<td>핵교B</td>
			<td>전지</td>
			<td>전기</td>
			<td>전선</td>
			<td>자율</td>
			<td>총학점</td>
		</tr>
		<tr>
			<td>
				<c:out value="${seperation.s1}"></c:out>
			</td>
			<td>
				<c:out value="${seperation.s2}"></c:out>
			</td>
			<td>
				<c:out value="${seperation.s3}"></c:out>	
			</td>
			<td>
				<c:out value="${seperation.s4}"></c:out>	
			</td>
			<td>
				<c:out value="${seperation.s5}"></c:out>	
			</td>
			<td>
				<c:out value="${seperation.s6}"></c:out>	
			</td>
			<td>
				<c:out value="${seperation.s7}"></c:out>	
			</td>
			<td>
				<c:out value="${seperation.s8}"></c:out>	
			</td>
		</tr>
	</table>

</body>
</html>