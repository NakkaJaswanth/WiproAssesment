package com.example.Beanfiles;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstructorInjectionDemo {

	int eno;
	String ename;
	Vehicle v1;
	public List<String> technologies123;
	public Map<String,Integer> ratings;

	public ConstructorInjectionDemo( 

			@Value("1001")
			int eno, 
			@Value("Devi")
			String ename,
			@Autowired
			@Qualifier ("mycar")
			Vehicle v1, 
			
			@Autowired
			@Qualifier ("technologies1")//lookup @Bean method :: public List<String> technologies1() 
			List<String> technologies123,

			@Autowired
			@Qualifier ("ratings")//100% optional
			Map<String, Integer> ratings)
	{

super();
this.eno = eno;
this.ename = ename;
this.v1 = v1;
this.technologies123 = technologies123;
this.ratings = ratings;
	}


@Override
public String toString() 
{
v1.category();//car
v1.parts();//car
return "ConstructorInjectionDemo [eno=" + eno + ", ename=" + ename + "]";
}
}
