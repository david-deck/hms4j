package org.hms4j.core;

import java.io.File;
import java.util.Collection;

import org.hms4j.context.ModuleContext;
import org.hms4j.spring.context.SpringModuleContext;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

//	@Test
	public void test() throws Exception {

		ApplicationContext parentApplicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");

		try (ModuleContext moduleContext = new SpringModuleContext(new File("modules"), parentApplicationContext)) {

			moduleContext.init();

			Collection<?> allSchedulers = new StdSchedulerFactory().getAllSchedulers();
			System.out.println("schedulers: " + allSchedulers.size());
			for (Object scheduler : allSchedulers) {
				System.out.println("scheduler: " + ((Scheduler)scheduler).getSchedulerName());
			}
		}
	}

}
