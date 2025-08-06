package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // class is eligible for web mvc based application
@RequestMapping("/Wipro") // global controller url pattern at runtime(browser page)
public class FirstController {
	
	//http://localhost:8098/MyWiproBatch/Wipro/Signin
	 @RequestMapping("/Signin")//controller url pattern at runtime
	public String disp() 
	{

			// view layer file name --jsp file name
			// I WANT THE WEB RESPONSE ONLY IN JSP FILE!
		   return "FirstViewLayer";//FirstViewLayer.jsp
	}
	 
	//http://localhost:8098/MyWiproBatch/Wipro/Signout
		
		//set the handler mapping
	 @RequestMapping("/Signout")//controller url pattern at runtime
	 public String disp1()
	 {
			//view layer file name --jsp file name
		   //I WANT THE WEB RESPONSE ONLY IN JSP FILE!
		   return "SecondViewLayer";//SecondViewLayer.jsp
	 }

}
