package org.hms4j.spring.context;

import java.lang.invoke.MethodHandles;
import java.util.jar.Manifest;

import org.hms4j.context.ModuleRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SpringContextManifestAttribute {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private static final String CREATE_ASYNCHRONOUSLY_DIRECTIVE_PREFIX = "create-asynchronously:=";
	private static final String SPRING_CONTEXT_ATTRIBUTE_NAME = "Spring-Context";

	private boolean createAsynchronously = true;
	private Class<?>[] configClasses;
	private String[] configLocations;
	private boolean xmlConfig = true;

	SpringContextManifestAttribute(Manifest manifest) {

		super();
		if (manifest == null) {
			LOGGER.info("No Manifest");
			return;
		}

		String valueAsString = manifest.getMainAttributes().getValue(SPRING_CONTEXT_ATTRIBUTE_NAME);
		if (valueAsString == null) {
			LOGGER.info("No {} attribute in Manifest", SPRING_CONTEXT_ATTRIBUTE_NAME);
			return;
		}

		for (String directive : valueAsString.replaceAll(" ", "").split(";")) {

			if (directive.startsWith(CREATE_ASYNCHRONOUSLY_DIRECTIVE_PREFIX)) {

				createAsynchronously = Boolean.parseBoolean(directive.replace(CREATE_ASYNCHRONOUSLY_DIRECTIVE_PREFIX, ""));
				continue;
			}

			String[] configs = directive.split(",");

			if (configs[0].endsWith(".xml")) {

				configLocations = configs;
				LOGGER.debug("config locations: [{}]", (Object[]) configLocations);
			} else {

				xmlConfig = false;
				configClasses = new Class[configs.length];
				for (int i = 0; i < configs.length; i++) {
					try {
						configClasses[i] = Class.forName(configs[i]);
					} catch (ClassNotFoundException e) {
						throw new ModuleRuntimeException(e);
					}
				}
				LOGGER.debug("config classes: [{}]", (Object[]) configClasses);
			}
		}
	
		LOGGER.debug("createAsynchronously: {}", createAsynchronously);
	}

	public boolean isCreateAsynchronously() {
		return createAsynchronously;
	}

	public Class<?>[] getConfigClasses() {
		return configClasses;
	}

	public String[] getConfigLocations() {
		return configLocations;
	}

	public boolean isXmlConfig() {
		return xmlConfig;
	}


}
