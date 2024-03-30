package com.liferay.rk.model.listener.hook;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate=true,
		service=ModelListener.class
		)

public class UserDeleteEventListenerHook extends BaseModelListener<User>{
	private static final Log log = LogFactoryUtil.getLog(UserDeleteEventListenerHook.class);

	@Override
	public void onAfterRemove(User model) throws ModelListenerException {
		System.out.println("user with email address "+model.getEmailAddress() +"Is deleted");
		// logic will implement here 
		super.onAfterRemove(model);
	}

}
