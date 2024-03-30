/**
 * Create a class 
 * add @component anotation
 * url-pattern is used to excute the filter 
 * implements Filter class
 * 
 * if we want user object than extends BaseFilter class of the liferay
 * 
 * 
 */

package com.liferay.rk.common.servletfilter;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true , 
		property = {
				"servlet-context-name=",
				"servlet-filter-name=Custome Filter",
				"url-pattern=/web/employee/home"
		},service=Filter.class
		)
public class FilterHookClass implements Filter {

	@Override
	public void destroy() {
		System.out.println("Called SampleFilter.destroy()");
	}

	@Override
	public void doFilter(
			ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain)
		throws IOException, ServletException {
		String uri = (String)servletRequest.getAttribute(
			WebKeys.INVOKER_FILTER_URI);

		System.out.println(
			"Called SampleFilter.doFilter(" + servletRequest + ", " +
				servletResponse + ", " + filterChain + ") for URI " + uri);
		String ip = servletRequest.getRemoteAddr();
		System.out.println("Your Ip Address"+ip);

		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println(
				"Called SampleFilter.init(" + filterConfig + ") where hello=" +
					filterConfig.getInitParameter("hello"));
		
	}



}
