<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
	<head>
		<title>MPS Student</title>
	</head>
	<body>
		<h2>Student Info:</h2>
		<form:form method = "POST" action="/modern-public-school/addStudent">
			<table>
				<tr>
					<td><form:label path="id">ID</form:label></td>
					<td><form:input path = "id" /></td>
				</tr>
				<tr>
					<td><form:label path="name">NAME</form:label></td>
					<td><form:input path = "name" /></td>
				</tr>
				<tr>
					<td><form:label path="age">AGE</form:label></td>
					<td><form:input path = "age" /></td>
				</tr>
				<tr>
					<td colspan = "2"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>