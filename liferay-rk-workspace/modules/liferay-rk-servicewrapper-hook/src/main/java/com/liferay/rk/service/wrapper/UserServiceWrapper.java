package com.liferay.rk.service.wrapper;

import com.liferay.portal.kernel.service.UserLocalServiceWrapper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author Ravi
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class UserServiceWrapper extends UserLocalServiceWrapper {

	public UserServiceWrapper() {
		super(null);
	}

	@Override
	public User deleteUser(long userId) throws PortalException {
		 System.out.println("Custom logic before Deleting User");
		return super.deleteUser(userId);
	}

}