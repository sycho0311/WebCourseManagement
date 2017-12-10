<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/createClass"
		modelAttribute="offer">
		<table class="formtable">
			<tr>
				<td class="label">수강년도:</td>
				<td><sf:input path="year" class="control" type="text" value="2018"/><br />
					<sf:errors path="year" class="error" /></td>
			</tr>
			<tr>
				<td class="label">학기:</td>
				<td><sf:input path="semester" class="control" type="text" value="1"/><br />
					<sf:errors path="semester" class="error" /></td>
			</tr>
			<tr>
				<td class="label">교과코드:</td>
				<td><sf:input path="code" class="control" type="text" /><br />
					<sf:errors path="code" class="error" /></td>
			</tr>
			<tr>
				<td class="label">교과목명:</td>
				<td><sf:input path="name" class="control" type="text" /><br />
					<sf:errors path="name" class="error" /></td>
			</tr>
			<tr>
				<td class="label">구분:</td>
				<td><sf:input path="seperation" class="control" type="text" /><br />
					<sf:errors path="seperation" class="error" /></td>
			</tr>
			<tr>
				<td class="label">학점:</td>
				<td><sf:input path="credit" class="control" type="text" /><br />
					<sf:errors path="credit" class="error" /></td></tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" type="submit" value="수강 신청"></td>
			</tr>
		</table>
	</sf:form>

</body>
</html>