package org.hms4j.context;

import static org.hms4j.context.JarFilenameFilter.JAR;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.util.jar.JarFile;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleClassLoader extends ClassLoader {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private final File[] jarFiles;
	private final File moduleDir;

	ModuleClassLoader(ClassLoader parent, File moduleDir) {
		super(parent);
		this.moduleDir = moduleDir;
		this.jarFiles = this.moduleDir.listFiles(JAR);
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {

		LOGGER.debug("loadClass({}), module: {}", name, moduleDir);

		String path = name.replace('.', '/') + ".class";

		synchronized (getClassLoadingLock(name)) {
			// First, check if the class has already been loaded
			Class<?> c = findLoadedClass(name);

			if (c == null) {

				LOGGER.debug("class not loaded yet");

				for (File file : jarFiles) {

					try (JarFile jarFile = new JarFile(file)) {

						if (jarFile.getJarEntry(path) == null) {
							continue;
						}

						ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
						IOUtils.copy(jarFile.getInputStream(jarFile.getJarEntry(path)), byteArrayOutputStream);
						byte[] bytes = byteArrayOutputStream.toByteArray();
						return defineClass(name, bytes, 0, bytes.length);
					} catch (IOException e) {
						throw new ModuleRuntimeException(e);
					}
				}
			}

			if (c == null) {
				c = super.loadClass(name);
			}

			return c;
		}
	}

	@Override
	public URL getResource(String name) {

		LOGGER.debug("getResource({}), module: {}", name, moduleDir);

		URL url = null;

		for (File file : jarFiles) {

			try (JarFile jarFile = new JarFile(file)) {

				if (jarFile.getJarEntry(name) == null) {
					continue;
				}

				url = new URL(String.format("jar:file:%s!/%s", file, name));
			} catch (IOException e) {
				throw new ModuleRuntimeException(e);
			}
		}

		if (url == null) {
			url = super.getResource(name);
		}

		return url;
	}

}
