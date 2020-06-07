package org.hms4j.spring;

import static com.openpojo.reflection.impl.PojoClassFactory.getPojoClassesRecursively;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.filters.FilterChain;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class) public class GettersAndSettersTest {

  private String packageName = "org.hms4j.spring";
  private Validator validator;

  @Before public void setUp() {
    validator = ValidatorBuilder.create().with(new GetterTester()).with(new SetterTester()).build();
  }

  @Test @Parameters public void validate(PojoClass pojoClass) {

    validator.validate(pojoClass);
  }

  List<PojoClass> parametersForValidate() {

    PojoClassFilter pojoClassFilter = new FilterChain(new FilterTestClasses());

    return getPojoClassesRecursively(packageName, pojoClassFilter);
  }
}
