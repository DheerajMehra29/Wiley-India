<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<html>
	<head>
		<title>MPS Student</title>
		<style>
			table, th, td {
			  border: 1px solid black;
			  border-collapse: collapse;
			}
		</style>
	</head>
	<body>
		<h2>Submitted Student Info:</h2>
		<table>
			<tr>
				<td>ID</td>
				<td>${id}</td>
			</tr>
			<tr>
				<td>NAME</td>
				<td>${name}</td>
			</tr>
			<tr>
				<td>AGE</td>
				<td>${age}</td>
			</tr>
		</table>
	</body>
</html>