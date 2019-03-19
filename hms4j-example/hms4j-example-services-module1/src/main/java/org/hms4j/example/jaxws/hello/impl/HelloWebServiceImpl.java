package org.hms4j.example.jaxws.hello.impl;

import javax.jws.WebService;

import org.hms4j.example.jaxws.hello.HelloWebService;

@WebService(endpointInterface = "org.hms4j.example.jaxws.hello.HelloWebService")
public class HelloWebServiceImpl implements HelloWebService {

	public HelloWebServiceImpl() {
		super();
		System.out.println("########################## new HelloWebServiceImpl()");
	}

	@Override
	public void sayHelloWorld() {
		System.out.println("Hello World !");
	}

}
