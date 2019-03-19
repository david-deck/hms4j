package org.hms4j.spring.web.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Proxy servlet that delegates to a Spring-wired bean.
 *
 * @author Ulrik Sandberg
 * @see https://github.com/jayway/forest/blob/master/core/src/main/java/com/jayway/forest/di/spring/DelegatingServletProxy.java
 */
public class DelegatingServletProxy implements Servlet {

	private Servlet delegate;

	protected ApplicationContext getContext(ServletContext servletContext) {
		return WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
	}

	public void init(final ServletConfig servletConfig) throws ServletException {
		final String targetBean = servletConfig.getInitParameter("targetBean");
		final ApplicationContext ctx = getContext(servletConfig.getServletContext());

		if (targetBean == null || !ctx.containsBean(targetBean)) {
			throw new ServletException("targetBean '" + targetBean + "' not found in context.");
		}

		this.delegate = (Servlet) ctx.getBean(targetBean, Servlet.class);
		this.delegate.init(servletConfig);
	}

	public ServletConfig getServletConfig() {
		return this.delegate.getServletConfig();
	}

	public void service(final ServletRequest servletRequest,
						final ServletResponse servletResponse) throws ServletException,
			IOException {
		this.delegate.service(servletRequest, servletResponse);
	}

	public String getServletInfo() {
		return this.delegate.getServletInfo();
	}

	public void destroy() {
		if (this.delegate != null) {
			this.delegate.destroy();
			this.delegate = null;
		}
	}
}
