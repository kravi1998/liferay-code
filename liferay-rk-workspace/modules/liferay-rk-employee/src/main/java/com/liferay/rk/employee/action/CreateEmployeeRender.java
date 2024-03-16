package com.liferay.rk.employee.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.rk.employee.constants.EmployeePortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + EmployeePortletKeys.EMPLOYEE,
				"mvc.command.name=/create/edit"
		}
		)

public class CreateEmployeeRender implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		return "/edit.jsp";
	}

}
