package org.hms4j.example.jaxws.hello;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(
	name="helloService",
	targetNamespace="http://ecar.gcatrans.com/hello"
)
public interface HelloWebService {

	@WebMethod
	void sayHelloWorld();
}
