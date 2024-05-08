<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%response.sendRedirect("http://localhost:8989/web12/EmployeeServlet?command=employee_list"); %>
</body>
</html>
<!-- 데이터는 즉시성이기 때문에 그때 그때 불러와야 한다. -->