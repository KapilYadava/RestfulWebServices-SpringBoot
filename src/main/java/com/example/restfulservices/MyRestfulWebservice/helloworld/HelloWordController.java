package com.example.restfulservices.MyRestfulWebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {
	
	
	@GetMapping(path= "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path= "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	// /hello-world/path-variable/in28mins
	@GetMapping(path= "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldBeanVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}


}
