package com.liferay.rk.employee.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.rk.employee.constants.EmployeePortletKeys;
import com.liferay.rk.employee.service.EmployeeLocalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + EmployeePortletKeys.EMPLOYEE,
				"mvc.command.name=saveEmployee"
		},
		service= MVCActionCommand.class
		)
public class SaveEmployeeAction extends BaseMVCActionCommand {
	private static final Log _log = LogFactoryUtil.getLog(SaveEmployeeAction.class);
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		System.out.println("Inside Save Employee Action Method");
		String name = ParamUtil.getString(actionRequest, "name");
		
		System.out.println("Name :::::::::::::"+name);
		String address = ParamUtil.getString(actionRequest, "address");
		System.out.println("Address :::::::::::::"+address);
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
		Date joiningdate=null;
		Date leavingdate=null;
		try {
			joiningdate = new SimpleDateFormat("dd/MM/yyyy").parse(joiningDate);
			leavingdate = new SimpleDateFormat("dd/MM/yyyy").parse(leavingDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		employeeLocalService.addEmployee(name, address, phoneNumber, salary, emailAddress, joiningdate, leavingdate);
		System.out.println("add Employee Methoda excuted");		
	}
@Reference
EmployeeLocalService employeeLocalService;
}

