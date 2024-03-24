package com.liferay.rk.employee.util;

import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.net.MalformedURLException;
import java.net.URL;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.URLDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true ,
		service=EmployeeCommonUtil.class
		
		)
public class EmployeeCommonUtil {
private static final Log LOGGER = LogFactoryUtil.getLog(EmployeeCommonUtil.class);

public void shareArticleMail(String mailSubject , String strToAddress , String content , String contentLink , String ccMailAddress , String fromEmailAddress , String imageUrl) throws AddressException
{
	try {
		InternetAddress cc = new InternetAddress(ccMailAddress);
		InternetAddress from = new InternetAddress(fromEmailAddress);
		String[] toAddresses = strToAddress.split(",");
		InternetAddress[] addressto = new InternetAddress[toAddresses.length];
		Message message = new MimeMessage(MailServiceUtil.getSession());
		MimeMultipart mimeMultiPart = new MimeMultipart();
		String contentMessage = "<p>"+content+"</p>"+"<br/>";
		
		BodyPart messageBodyPart = new MimeBodyPart();
		
		messageBodyPart.setContent(contentMessage , "text/html");
		mimeMultiPart.addBodyPart(messageBodyPart);
		String imageHtml = "<img src=\"cid:content-image\">";
		messageBodyPart = new MimeBodyPart();
		URL url = new URL(imageUrl);
		DataSource fds = new URLDataSource(url);
		messageBodyPart.setDataHandler(new DataHandler(fds));
		messageBodyPart.setHeader("Content-ID", "content-image");
		mimeMultiPart.addBodyPart(messageBodyPart);
		for(int i =0 ; i< toAddresses.length ; i++)
		{
			addressto[i]= new InternetAddress(toAddresses[i]);
			message.setRecipient(Message.RecipientType.TO, addressto[i]);
		}
		message.setFrom(from);
		message.setRecipient(Message.RecipientType.CC, cc);
		message.setSubject(mailSubject);
		message.setContent(mimeMultiPart);
		Transport.send(message);
		LOGGER.info("Mail Send");
		
	} catch (MessagingException | MalformedURLException e) {
		LOGGER.error("Error in Mail sending :::::::::::::::::::::::");
		
	} 
}

}
