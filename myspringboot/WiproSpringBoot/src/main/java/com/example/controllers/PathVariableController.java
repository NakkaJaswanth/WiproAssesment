package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class PathVariableController 
{

	//The @PathVariable annotation is used to extract the value from the URL.	 
	
	/*
	 * 		 * Model is an interface. 
		 * ModelAndView(built in class) is just a container for both a ModelMap and a view object. 
		 * It allows a controller to return both(MODEL+VIEW) as a single value.
		 * ModelAndView is an object that holds both the model and view.
Useful when you want to set both view and model together.

	 */
	//http://localhost:8098/MyWiproBatch/path2/WIPRO/NOIDA/23213=>INVALID
	//http://localhost:8098/MyWiproBatch/path2/WIPRO/NOIDA =>VALID
	

	@RequestMapping("/path2/{company}/{location}")
	public ModelAndView display
	(
			@PathVariable("company") 
			String com,

			@PathVariable("location")
			String loc1	
     )
	{
		ModelAndView m1=new ModelAndView();//built in class
		m1.addObject("message123","CompanyName:: "+com + " "+"Location:: "+loc1);//model object::key,value
		m1.setViewName("PathParameter");//view layer jsp file name=>PathParameter.jsp
		return m1;//returning MODEL(message123) + VIEW(PathParameter.jsp) 
	}


}
