package com.ty.tastManagement.Controller;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.ty.tastManagement.Controller.model.dto.MyConfig;

public class TaskInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{MyConfig.class} ;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
