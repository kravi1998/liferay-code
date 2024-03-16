/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.rk.employee.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.rk.employee.model.Employee;
import com.liferay.rk.employee.model.impl.EmployeeImpl;
import com.liferay.rk.employee.service.base.EmployeeLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.rk.employee.model.Employee",
	service = AopService.class
)
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {
	
	public Employee addEmployee(String name , long phoneNumber , String address , long salary , String emailAddress)
	{
		Employee employee = new EmployeeImpl();
		employee.setName(name);
		employee.setPhoneNumber(phoneNumber);
		employee.setSalary(salary);
		employee.setEmailAddress(emailAddress);
		
		long employeeId = counterLocalService.increment(Employee.class.getName());
		employee.setEmployeeId(employeeId);
		employeeLocalService.addEmployee(employee);
		
		return employee;
		
		
	}
}
