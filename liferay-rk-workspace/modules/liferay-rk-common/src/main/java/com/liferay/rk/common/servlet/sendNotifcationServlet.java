package com.liferay.rk.common.servlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.rk.common.util.CommonUtil;

import java.io.IOException;

import javax.mail.internet.AddressException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "osgi.http.whiteboard.context.path=/",
	        "osgi.http.whiteboard.servlet.pattern=/send-notification/servlet/*"
	    },
	    service = Servlet.class
	)
public class sendNotifcationServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final Log LOGGER = LogFactoryUtil.getLog(sendNotifcationServlet.class);
	

	@Override
	public void init() throws ServletException {
		LOGGER.info("Send Notification Servlet :::::::");
		super.init();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOGGER.info("Inside dopost Method");
		
		String strToAddresses = req.getParameter("toAddress").toString();
		String message = req.getParameter("message");
		String userName = req.getParameter("userName");
		String fromEmailAddress = req.getParameter("fromAddress");
		
		LOGGER.info("TO Adddresses = "+strToAddresses +":::Message ="+message+":::User Name ="+userName+":::From Email Addresses="+fromEmailAddress );
		try {
			commonUtil.sendNotification(strToAddresses, message, userName, fromEmailAddress);
		} catch (AddressException e) {
			LOGGER.error("Error in sending mail ");
		}
		
		
		

	}
	@Reference
	CommonUtil commonUtil;
}
	

