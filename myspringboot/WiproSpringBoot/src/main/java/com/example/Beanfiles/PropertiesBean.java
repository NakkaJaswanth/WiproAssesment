package com.example.Beanfiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesBean {
	//@Value ->inject value into field,method,constructor
	
	@Value("${myname}")//property key->IOC CONTAINER(application.properties) (DESIGN PATTERN DEPENDENCY INJECTION)
	String name;
	public String getName() 
	{
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
