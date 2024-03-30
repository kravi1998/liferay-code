/**
 * create a class 
 * add component annotattion
 * inside component annotation difine action path 
 * we can see action path inside tomcat->webapps->root->web-inf->struts-config.xml
 * below is use to perform action after logout 
 * implements StrutsAction
 * override method 
 * inside execute method our bussiness logic will go 
 */

package com.liferay.rk.struts.action.hook;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.struts.StrutsAction;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate=true,
		property= {
				"path=/portal/logout"
		},
		service=StrutsAction.class
		)
public class StrutsActionLogoutHook implements StrutsAction{

	@Override
	public String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		User user = PortalUtil.getUser(httpServletRequest);
		long companyId = PortalUtil.getCompanyId(httpServletRequest);
		String path = PrefsPropsUtil.getString(companyId, PropsKeys.DEFAULT_LOGOUT_PAGE_PATH );
		path = "/web/employee/logout";
		if (Validator.isNotNull(path))
		{
			HttpSession session = httpServletRequest.getSession();
			session.setAttribute(WebKeys.LAST_PATH, new LastPath(StringPool.BLANK, path));
		}
		
		System.out.println("Default Path Value +++++++++++++++"+path);
		System.out.println(user.getFullName()+ " is logout from site ");
		return path;
	}

}
