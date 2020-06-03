package org.hms4j.context;

import java.io.File;
import java.io.FilenameFilter;

class JarFilenameFilter implements FilenameFilter {

  static final FilenameFilter JAR = new JarFilenameFilter();

  private JarFilenameFilter() {
    super();
  }

  @Override public boolean accept(File dir, String name) {
    return name.endsWith(".jar");
  }
}
