package com.liferay.rk.rest.builder.internal.resource.v1_0;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.rk.rest.builder.dto.v1_0.UserObject;
import com.liferay.rk.rest.builder.resource.v1_0.UserResource;

import java.util.Collections;

import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Ravi
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/user.properties",
	scope = ServiceScope.PROTOTYPE, service = UserResource.class
)
public class UserResourceImpl extends BaseUserResourceImpl {

	
	@Override
	public Page<UserObject> getUserById(@NotNull Long userId) throws Exception {
		User user = userLocalService.getUser(userId);
		UserObject userObject =getUserFromModel(user);
		return Page.of(Collections.singleton(userObject));
	}
	private UserObject getUserFromModel(User user) {
		UserObject userObject = new UserObject();
		userObject.setScreenName(user.getScreenName());
		userObject.setFirstName(user.getFirstName());
		userObject.setLastName(user.getLastName());
		userObject.setEmail(user.getEmailAddress());
		return userObject;
	}
	@Reference
	UserLocalService userLocalService;
}