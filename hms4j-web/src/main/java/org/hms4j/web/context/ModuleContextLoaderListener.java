package org.hms4j.web.context;

import java.io.File;
import java.lang.invoke.MethodHandles;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hms4j.context.ModuleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleContextLoaderListener implements ServletContextListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static final String PARAM_PREFIX = "hms4j.";

	public static final String MODULE_CONTEXT_ATTRIBUTE_PARAM = PARAM_PREFIX + "moduleContext.servletContext.attribute";

	public static final String MODULE_DIRECTORY_PARAM = PARAM_PREFIX + "module.directory";
	public static final String DEFAULT_MODULE_DIRECTORY = "WEB-INF/lib/modules";

	private ModuleContext moduleContext;
	protected File rootDir = new File(DEFAULT_MODULE_DIRECTORY);
	private String servletContextAttribute;

	@Override
	public final void contextInitialized(ServletContextEvent sce) {

		LOGGER.debug("contextInitialized(ServletContextEvent)");

		ServletContext servletContext = sce.getServletContext();

		init(servletContext);

		moduleContext = createModuleContext(servletContext);

		moduleContext.init();

		if (servletContextAttribute != null) {
			servletContext.setAttribute(servletContextAttribute, moduleContext);
		}
	}

	protected final void init(ServletContext servletContext) {

		String moduleDirPath = servletContext.getInitParameter(MODULE_DIRECTORY_PARAM);
		if (moduleDirPath == null) {
			moduleDirPath = servletContext.getRealPath(DEFAULT_MODULE_DIRECTORY);
		}
		rootDir = new File(moduleDirPath);

		servletContextAttribute = servletContext.getInitParameter(MODULE_CONTEXT_ATTRIBUTE_PARAM);

		LOGGER.debug("init(ServletContext), rootDir = [{}], servletContextAttribute = [{}]", rootDir, servletContextAttribute);
	}

	protected ModuleContext createModuleContext(ServletContext servletContext) {

		LOGGER.debug("createModuleContext(servletContext: {})", servletContext);

		return new ModuleContext(rootDir);
	}

	@Override
	public final void contextDestroyed(ServletContextEvent sce) {

		LOGGER.debug("contextDestroyed(ServletContextEvent)");

		if (moduleContext != null) {
			moduleContext.close();
		}
	}

}
