package com.keduit.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduit.dao.EmployeeDAO;
import com.keduit.dto.EmployeeVO;

public class EmployeeUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeVO eVO=new EmployeeVO();
		eVO.setId((request.getParameter("id")));
		eVO.setPass(request.getParameter("pass"));
		eVO.setName(request.getParameter("name"));
		eVO.setLev(request.getParameter("lev"));
		eVO.setGender(request.getParameter("gender"));
		eVO.setPhone(request.getParameter("phone"));
		
		EmployeeDAO eDAO=EmployeeDAO.getInstance();
		eDAO.updateEmployee(eVO);
		
		new EmployeeViewAction().execute(request, response);

	}

}
