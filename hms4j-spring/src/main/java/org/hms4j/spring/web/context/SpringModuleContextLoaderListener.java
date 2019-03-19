package org.hms4j.spring.web.context;

import java.lang.invoke.MethodHandles;

import javax.servlet.ServletContext;

import org.hms4j.context.ModuleContext;
import org.hms4j.spring.context.SpringModuleContext;
import org.hms4j.web.context.ModuleContextLoaderListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringModuleContextLoaderListener extends ModuleContextLoaderListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Override
	protected ModuleContext createModuleContext(ServletContext servletContext) {

		LOGGER.debug("createModuleContext(servletContext: {})", servletContext);

		return new SpringModuleContext(rootDir, WebApplicationContextUtils.getWebApplicationContext(servletContext));
	}

}
