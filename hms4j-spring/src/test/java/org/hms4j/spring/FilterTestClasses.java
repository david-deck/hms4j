package org.hms4j.spring;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;

/**
 * https://github.com/OpenPojo/openpojo/wiki/Tutorial-8.-Testing-Only-Production-classes
 */
public class FilterTestClasses implements PojoClassFilter {

  private static final Logger LOGGER = LoggerFactory.getLogger(FilterTestClasses.class);

  /**
   * Eclipse: default (*Builder), itest, test (*BuilderFactories)
   */
  private static final String TEST_CLASS_PATH_REGEX = "(.)+/(default|itest|test)/(.)*";

  private final Pattern pattern;

  public FilterTestClasses() {
    this.pattern = Pattern.compile(TEST_CLASS_PATH_REGEX);
  }

  @Override public boolean include(PojoClass pojoClass) {

    boolean included = true;

    if (pattern.matcher(pojoClass.getSourcePath()).matches()) {
      included = false;
    }

    LOGGER.debug("{} included ? {}", pojoClass.getSourcePath(), included);

    return included;
  }
}
