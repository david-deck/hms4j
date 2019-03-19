package org.hms4j.example.service.impl;

import org.hms4j.example.service.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHelloTo(String someone) {
		return String.format("Hello %s ! (v1)", someone);
	}

}
