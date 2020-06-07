package org.hms4j.web.context;

import static org.assertj.core.api.Assertions.*;
import static org.hms4j.web.context.ModuleContextLoaderListener.MODULE_DIRECTORY_PARAM;
import static org.mockito.Mockito.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

public class ModuleContextLoaderListenerTests {

  @Rule public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
  ModuleContextLoaderListener moduleContextLoaderListener;
  @Mock ServletContext servletContext;
  ServletContextEvent servletContextEvent;

  @Before public void setUp() {
    moduleContextLoaderListener = new ModuleContextLoaderListener();
    servletContextEvent = new ServletContextEvent(servletContext);
  }

  @Test public void testContextInitialized() {

    when(servletContext.getInitParameter(MODULE_DIRECTORY_PARAM)).thenReturn("foo");

    moduleContextLoaderListener.contextInitialized(servletContextEvent);

    assertThat(moduleContextLoaderListener.rootDir).isNotNull();
  }

}
