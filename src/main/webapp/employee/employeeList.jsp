<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원목록</title>
<link rel="stylesheet" type="text/css" href="css/employee.css">
</head>
<body>
	<div id="wrap">
<h1>리스트</h1>
<table class="list">
<tr>
<td colspan="5" class="td1"><a href="EmployeeServlet?command=employee_write_form">정보등록</a></td>
	
</tr>
<tr>
	<th>아이디</th><th>이름</th><th>권한</th><th>성별</th><th>전화번호</th>
</tr>
<c:forEach var="employee" items="${employeeList}">
<tr>
	<td>${employee.id}</td>
	<td><a href="EmployeeServlet?command=Employee_view&id=${employee.id}">
	${employee.name}</a></td>
	<td>${employee.lev eq 'A'?'운영자':'일반회원'}</td>
	<td>${employee.gender eq '1'?'남자':'여자'}</td>
	<td>${employee.phone}</td>

</tr>



</c:forEach>
</table>
</div>
</body>
</html>