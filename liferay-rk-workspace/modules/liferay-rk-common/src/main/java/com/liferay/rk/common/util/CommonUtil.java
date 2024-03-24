package com.liferay.rk.common.util;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.petra.mail.MailEngine;
import com.liferay.petra.mail.MailEngineException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate=true,
		service=CommonUtil.class
		)
public class CommonUtil {
private static Log Logger = LogFactoryUtil.getLog(CommonUtil.class);

public void sendNotification(String strToAddresses , String message , String userName , String fromEmailAddress) throws AddressException
	{
	  MailMessage mailMessage = new MailMessage();
	  mailMessage.setHTMLFormat(true);
	  String mailBody = "<p>"+message+"</p>"+"br/"+"from"+"br/"+userName;
	  mailMessage.setBody(mailBody);
	  String subject ="Notification mail";
	  InternetAddress fromEmail = new InternetAddress(fromEmailAddress);
	  strToAddresses.replaceAll(",", "/");
	  InternetAddress toEmail = new InternetAddress(strToAddresses);
	  mailMessage.setFrom(fromEmail);
	  mailMessage.setTo(toEmail);
	  try {
		MailEngine.send(mailMessage);
	} catch (MailEngineException e) {
		Logger.error("Error in sending Mail "+e);
	}
	}
}
