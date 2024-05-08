package com.keduit.controller.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduit.dao.EmployeeDAO;
import com.keduit.dto.EmployeeVO;

public class EmployeeWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeVO eVO=new EmployeeVO();
		eVO.setId(request.getParameter("id"));
		eVO.setPass(request.getParameter("pass"));
		eVO.setName(request.getParameter("name"));
		eVO.setLev(request.getParameter("lev"));
		eVO.setPhone(request.getParameter("phone"));
		eVO.setGender(request.getParameter("gender"));
		
		EmployeeDAO eDAO=EmployeeDAO.getInstance();
		eDAO.insertEmployee(eVO);
		
		new EmployeeListAction().execute(request, response);
	}

}
