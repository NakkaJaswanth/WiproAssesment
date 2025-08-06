package com.example.Mainfiles;


import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.Beanfiles.Bank;
import com.example.Beanfiles.ClassKLM;
import com.example.Beanfiles.ConstructorInjectionDemo;
import com.example.Beanfiles.FirstSpringBootBean;
import com.example.Beanfiles.PropertiesBean;
import com.example.Beanfiles.PropertyBean;

@SpringBootApplication//starting point or entry point for your project
@EnableJpaRepositories(basePackages = "com.example.repository") 
@ComponentScan(basePackages= {"com.example.Beanfiles","com.example.controllers","com.example.services","com.example.repository"})



  

public class SpringBootEntryDemo {
	public static void main(String[] args) {

		ApplicationContext con1=SpringApplication.run(SpringBootEntryDemo.class,args);
		FirstSpringBootBean b1=con1.getBean(FirstSpringBootBean.class);
		b1.display();
	
		 
		PropertiesBean object2 = con1.getBean(PropertiesBean.class);
		System.out.println("Name:: "+object2.getName());
	
	    Bank b11=con1.getBean(Bank.class);
		System.out.println(b11.toString());
	    b11.getV1().category();//mybike
	    b11.getV1().parts();//mybike
	
	    List<String> obj=b11.getTechnologies();
	    for(String a:obj)
	    {
	    	System.out.println(a);
	    }
	    Map<String,Integer> obj2=b11.getRatings();
		System.out.println("Ratings::(Key&Value)::");

		for(Map.Entry<String, Integer> uobj:obj2.entrySet())
		{
			System.out.println(uobj.getKey()+ " "+uobj.getValue());
		}


				ConstructorInjectionDemo c1=con1.getBean(ConstructorInjectionDemo.class);
			    System.out.println(c1.toString());
			    List<String> obt=c1.technologies123;
			    for(String a:obt)
			    {
			    	System.out.println(a);
			    }
			    Map<String,Integer> obr=c1.ratings;
				System.out.println("Ratings::(Key&Value)::");

				for(Map.Entry<String, Integer> uobj:obr.entrySet())
				{
					System.out.println(uobj.getKey()+ " "+uobj.getValue());
				}		
				 ClassKLM objKLM = con1.getBean(ClassKLM.class);
			        objKLM.execute();
			        PropertyBean propertiesBean = con1.getBean(PropertyBean.class);
			        System.out.println("=== Properties from application.properties ===");
			        System.out.println("Integer Value: " + propertiesBean.getIntegerValue());
			        System.out.println("Decimal Value: " + propertiesBean.getDecimalValue());
			        System.out.println("Boolean Value: " + propertiesBean.getBooleanValue());
			     
	}
	
}

