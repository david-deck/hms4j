package org.hms4j.context;

import static java.lang.Thread.currentThread;
import static org.apache.commons.io.filefilter.FileFilterUtils.directoryFileFilter;
import static org.hms4j.context.JarFilenameFilter.JAR;

import java.io.File;
import java.io.FileFilter;
import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleContext implements AutoCloseable {

  private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
  private final File rootDir;

  public ModuleContext(File rootDir) {

    super();
    this.rootDir = rootDir;

    LOGGER.debug("new ModuleContext({})", rootDir);
  }

  public void init() {

    LOGGER.debug("init()");

    File[] moduleDirs = rootDir.listFiles((FileFilter) directoryFileFilter());
    if (moduleDirs == null || moduleDirs.length == 0) {
      LOGGER.warn("No module directory found in [{}]", rootDir.getAbsolutePath());
      return;
    }

    ClassLoader bootClassLoader = currentThread().getContextClassLoader();

    for (File moduleDir : moduleDirs) {

      LOGGER.debug("moduleDir: [{}]", moduleDir);

      ModuleClassLoader classLoader = new ModuleClassLoader(bootClassLoader, moduleDir);

      currentThread().setContextClassLoader(classLoader);

      loadModule(moduleDir, moduleDir.listFiles(JAR), classLoader);
    }

    currentThread().setContextClassLoader(bootClassLoader);
  }

  protected void loadModule(File moduleDir, File[] jarFiles, ClassLoader classLoader) {
    LOGGER.debug("loadModule({}, {}, {})", moduleDir, jarFiles, classLoader);
  }

  @Override public void close() {
    LOGGER.debug("close()");
  }

}
