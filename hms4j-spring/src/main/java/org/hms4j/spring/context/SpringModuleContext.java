package org.hms4j.spring.context;

import java.io.File;
import java.lang.invoke.MethodHandles;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.hms4j.context.ModuleContext;
import org.hms4j.context.ModuleRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringModuleContext extends ModuleContext {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private static final String SPRING_CONFIG_PATH = "META-INF/spring";
	protected final ApplicationContext parentApplicationContext;
	private final Collection<ConfigurableApplicationContext> moduleApplicationContexts = new HashSet<>();

	public SpringModuleContext(File rootDir, ApplicationContext parentApplicationContext) {
		super(rootDir);
		this.parentApplicationContext = parentApplicationContext;
	}

	@Override
	protected void loadModule(File moduleDir, File[] jarFiles, ClassLoader classLoader) {

		for (File file : jarFiles) {

			LOGGER.debug("jarFile: {}", file);

			try (JarFile jarFile = new JarFile(file)) {

				if (LOGGER.isTraceEnabled()) {
					Enumeration<JarEntry> jarEntries = jarFile.entries();
					while (jarEntries.hasMoreElements()) {
						LOGGER.trace("jarEntry: {}", jarEntries.nextElement());
					}
				}

				AbstractApplicationContext applicationContext;

				if (jarFile.getJarEntry(SPRING_CONFIG_PATH) != null) {

					LOGGER.debug("{} found: using ClassPathXmlApplicationContext", SPRING_CONFIG_PATH);
					applicationContext = new ClassPathXmlApplicationContext(new String[] {"classpath:" + SPRING_CONFIG_PATH + "/*.xml"}, false, parentApplicationContext);
				} else {

					SpringContextManifestAttribute springContextAttribute = new SpringContextManifestAttribute(jarFile.getManifest());

					if (springContextAttribute.isXmlConfig()) {

						applicationContext = new ClassPathXmlApplicationContext(springContextAttribute.getConfigLocations(), false, parentApplicationContext);
					} else {

						Class<?> applicationContextClass = Class.forName("org.springframework.context.annotation.AnnotationConfigApplicationContext");
						applicationContext = (AbstractApplicationContext) applicationContextClass.newInstance();
						applicationContextClass.getMethod("register", Class[].class).invoke(applicationContext, (Object[]) springContextAttribute.getConfigClasses());
						applicationContextClass.getMethod("setParent", ApplicationContext.class).invoke(applicationContext, parentApplicationContext);
					}
				}

				applicationContext.setClassLoader(classLoader);
				applicationContext.refresh();
				moduleApplicationContexts.add(applicationContext);

			} catch (Exception e) {
				throw new ModuleRuntimeException(e);
			}
		}
	}

	@Override
	public void close() {

		for (ConfigurableApplicationContext moduleApplicationContext : moduleApplicationContexts) {
			moduleApplicationContext.close();
		}

		super.close();
	}

}
