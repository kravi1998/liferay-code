package com.liferay.rk.rest.builder.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Ravi
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/liferay-rk-restbuilder",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=LiferayRkRestbuilder"
	},
	service = Application.class
)
@Generated("")
public class LiferayRkRestbuilderApplication extends Application {
}