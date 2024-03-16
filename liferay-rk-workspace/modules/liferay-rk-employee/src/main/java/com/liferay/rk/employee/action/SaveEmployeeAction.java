package com.liferay.rk.employee.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.rk.employee.constants.EmployeePortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + EmployeePortletKeys.EMPLOYEE,
				"mvc.command.name=saveEmployee"
		},
		service= MVCActionCommand.class
		)
public class SaveEmployeeAction implements MVCActionCommand {
	private static final Log _log = LogFactoryUtil.getLog(SaveEmployeeAction.class);

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		System.out.println("Inside Save Employee Action Method");
		String name = ParamUtil.getString(actionRequest, "name");
		
		System.out.println("Name :::::::::::::"+name);
		long phoneNumber = ParamUtil.getLong(actionRequest, "phoneNumber");
		System.out.println("Phone Number ::::::::::::::::::::"+phoneNumber);
		long salary = ParamUtil.getLong(actionRequest, "salary");
		System.out.println("Salary  :::::::::::::::::::: "+salary);
		String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
		System.out.println("emailAddress :::::::::::::"+emailAddress);
		String joiningDate = ParamUtil.getString(actionRequest, "joiningDate");
		System.out.println("joiningDate :::::::::::::"+joiningDate);
		String leavingDate = ParamUtil.getString(actionRequest, "leavingDate");
		System.out.println("Name :::::::::::::"+leavingDate);
		return false;
	}

}
