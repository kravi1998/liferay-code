package com.liferay.rk.common.scheduler;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Date;
import java.util.Map;
 
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

@Component(
		immediate=true,
				property = {
						"cron.expression= 0 0/30 1/1 1/1 * ?"   // scheduler runs every 30 min.
					},
		service=SchedulerExample.class
		)
public class SchedulerExample extends BaseMessageListener{
	private static final Log log = LogFactoryUtil.getLog(SchedulerExample.class);
	private volatile boolean _initialized;

	@Override
	protected void doReceive(Message message) throws Exception {
		System.out.println("Scheduler method excuted");
		//logic will go here 
		
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) throws SchedulerException {

		try {
			String cronExpression = GetterUtil.getString(properties.get("cron.expression"), "cronExpression");
			log.info(" cronExpression: " + cronExpression);

			String listenerClass = getClass().getName();
			Trigger jobTrigger = TriggerFactoryUtil.createTrigger(listenerClass, listenerClass, new Date(), null, cronExpression);

			SchedulerEntryImpl schedulerEntryImpl = new SchedulerEntryImpl(getClass().getName(), jobTrigger);
			if(_initialized) {
				deactive();
			}


			SchedulerEngineHelperUtil.register(this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
			_initialized=true;

		} catch (Exception e) {
			log.error(e);
		}
	}
	@Deactivate
	protected void deactive() {
		if(_initialized)
		{
		SchedulerEngineHelperUtil.unregister(this);
		}
		_initialized=false;
	}
	
}
