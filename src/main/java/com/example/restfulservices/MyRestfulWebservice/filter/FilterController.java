package com.example.restfulservices.MyRestfulWebservice.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {

	@GetMapping(path = "/filter-some-bean")
	public MappingJacksonValue retrieveSomBeans() {
		SomeBean bean = new SomeBean("value1", "value2", "value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider provider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(bean);
		mapping.setFilters(provider);
		return mapping;
	}
	
	@GetMapping(path = "/filter-list")
	public MappingJacksonValue retrieveListOfSomBeans() {
		List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"), 
				new SomeBean("value12", "value22", "value32"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider provider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(provider);
		return mapping;
	}
}
