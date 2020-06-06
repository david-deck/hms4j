package org.hms4j.context;

import static org.assertj.core.api.Assertions.*;
import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class) public class JarFilenameFilterTests {

  File dir;

  @Test @Parameters({"my.jar, true", "not-a-jar, false" })
  public void testAccept(String filename, boolean expectedResult) {
    assertThat(JarFilenameFilter.JAR.accept(dir, filename)).isEqualTo(expectedResult);
  }
}
