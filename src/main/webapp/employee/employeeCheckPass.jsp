<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
</head>
<body>
	<form name="frm" action="EmployeeServlet" method="GET">
	<input type="hidden" name="command" value="employee_check_pass">
	<input type="hidden" name="id" value="${param.id}">
	<table id="pass">
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pass" size="20"></td>
		</tr>
	</table>
	<br>
	<input type="submit" value="확인" onclick="return passCheck()">
	<br><br>
	${message}
	</form>
</body>
</html>