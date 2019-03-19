package org.hms4j.example.scheduling;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hms4j.example.service.HelloService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.context.ApplicationContext;

public class HelloJob2 implements Job {

	private static final Log LOG = LogFactory.getLog(HelloJob2.class);

	@Override
	public void execute(JobExecutionContext context) {

		ApplicationContext applicationContext = (ApplicationContext) context.getMergedJobDataMap().get("applicationContext");
		HelloService helloService = (HelloService) applicationContext.getBean("helloService", HelloService.class);
		LOG.info("helloService.sayHelloTo(\"World\") returns \"" + helloService.sayHelloTo("World") + '"');
	}

}
