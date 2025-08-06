package com.example.Beanfiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//class level annotation
public class MyCollectionConfig {
	@Bean//first bean method
	public List<String> technologies() 
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("Java");
		list.add("PHP");
		list.add("Python");
		list.add("DOCKER");
		list.add("SWAGGER");		
		return list;
	}
	@Bean//second bean method
	public Map<String,Integer> ratings() 
	{
		Map<String, Integer> obj1 = new HashMap<String, Integer>();
		obj1.put( "Java", 10 );
		obj1.put( "Oracle", 10);
		obj1.put( "MYSQL", 7);
		return obj1;
	}
	@Bean//third bean method
	public List<String> technologies1() 
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("DOTNET");
		list.add("GROOVY");
		list.add("AZURE");
		list.add("YAML");
		list.add("XML");		
		return list;
	}

}
