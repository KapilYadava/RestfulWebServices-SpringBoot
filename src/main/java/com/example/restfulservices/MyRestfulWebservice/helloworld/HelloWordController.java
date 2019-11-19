package com.example.restfulservices.MyRestfulWebservice.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfulservices.MyRestfulWebservice.filter.SomeBean;

@RestController
public class HelloWordController {
	
	@Autowired
	MessageSource messageSource;
	
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

	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, 
									LocaleContextHolder.getLocale());
	}

}
