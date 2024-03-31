package com.liferay.rk.rest.builder.internal.resource.v1_0;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.rk.rest.builder.dto.v1_0.UserObject;
import com.liferay.rk.rest.builder.resource.v1_0.UserResource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	public UserObject getUserById(@NotNull Long userId) throws Exception {
		User user = userLocalService.getUser(userId);
		UserObject userObject =getUserFromModel(user);
		return userObject;
	}
	@Override
	public UserObject deleteUserById(@NotNull Long userId) throws Exception {
		UserObject userObject = new UserObject();
		try {
			userLocalService.deleteUser(userId);
			userObject.setStatusCode(200);
			userObject.setStatusMessage("Deleted Successfully");
		} catch (Exception e) {
			userObject.setStatusCode(500);
			userObject.setStatusMessage(e.getMessage());
		}
		return userObject;
	}
	@Override
	public Page<UserObject> getUsers(Pagination pagination) throws Exception {
		List userObjects = new ArrayList<>();
		List<User> users = userLocalService.getUsers(pagination.getStartPosition(), pagination.getEndPosition());
		for (User user : users) {
			UserObject userObject = getUserFromModel(user);
			userObjects.add(userObject);
		}
		return Page.of(userObjects, pagination, userObjects.size());
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