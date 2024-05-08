package com.keduit.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduit.dao.EmployeeDAO;
import com.keduit.dto.EmployeeVO;

public class EmployeeListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="employee/employeeList.jsp";
		
		EmployeeDAO EDAO=EmployeeDAO.getInstance();
		List<EmployeeVO> employeeList=EDAO.selectAllEmployee();
		
		request.setAttribute("employeeList", employeeList);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
