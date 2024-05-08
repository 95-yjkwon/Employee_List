package com.keduit.controller;

import com.keduit.controller.action.Action;
import com.keduit.controller.action.EmployeeCheckPassAction;
import com.keduit.controller.action.EmployeeCheckPassFormAction;
import com.keduit.controller.action.EmployeeDeleteAction;
import com.keduit.controller.action.EmployeeListAction;
import com.keduit.controller.action.EmployeeUpdateAction;
import com.keduit.controller.action.EmployeeUpdateFormAction;
import com.keduit.controller.action.EmployeeViewAction;
import com.keduit.controller.action.EmployeeWriteAction;
import com.keduit.controller.action.EmployeeWriteFormAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory instance=new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action=null;
		System.out.println("Actionfactory:"+command);
		
		if(command.equals("employee_list")) {
			action=new EmployeeListAction();
		}else if(command.equals("employee_write_form")) {
			action=new EmployeeWriteFormAction();
		}else if(command.equals("employee_write")) {
			action=new EmployeeWriteAction();
		}else if(command.equals("Employee_view")) {
			action=new EmployeeViewAction();
		}else if(command.equals("employee_check_pass_form")) {
			action=new EmployeeCheckPassFormAction();
		}else if(command.equals("employee_check_pass")) {
			action=new EmployeeCheckPassAction();
		}else if(command.equals("employee_update_form")) {
			action=new EmployeeUpdateFormAction();
		}else if(command.equals("employee_update")) {
			action=new EmployeeUpdateAction();
		}else if(command.equals("employee_delete")) {
			action=new EmployeeDeleteAction();
		}
		return action;
	}

}
