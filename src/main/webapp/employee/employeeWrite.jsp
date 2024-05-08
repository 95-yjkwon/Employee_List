<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<link rel="stylesheet" href="css/employee.css">
<script type="text/javascript" src="script/employee.js"></script>
</head>
<body>
	<div id="wrap">
<h1>게시글 등록</h1>

<form name="frm" method="post" action="EmployeeServlet">
<input type="hidden" name="command" value="employee_write">
<table>
	<tr>
		<th>작성자</th>
		<td><input type="text" name="id" required></td>
	</tr>

	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="pass"  required></td>
	</tr>
	
	
	<tr>
		<th>이름</th>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<th>권한</th>
		<td>
		<select name='lev'>
		<option value="A">운영자</option>
		<option value="B">일반</option>
		</select>
		</td>
	</tr>
	
	<tr>
		<th>성별</th>
		<td>
		<select name='gender'>
		<option value="1">남자</option>
		<option value="2">여자</option>
		</select>
		</td>
	</tr>
	
	<tr>
		<th>전화번호</th>
		<td><input type="tel" name="phone"></td>
	</tr>
	
</table>
<br><br>
<input type="submit" value="확인" onclick="return boardCheck()">
<input type="reset" value="취소">
<input type="button" value="목록"
onclick="location.href='EmployeeServlet?command=employee_list'">
</form>
</div>
</body>
</html>