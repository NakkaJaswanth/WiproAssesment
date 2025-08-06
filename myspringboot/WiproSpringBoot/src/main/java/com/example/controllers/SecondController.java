package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//NO GLOBAL URL PATTERN LIKE FIRSTCONTROLLER.JAVA
public class SecondController {

	//@RequestParam is used to read the HTML form data provided by a user and bind it to the request parameter. 

	@RequestMapping(value="/checkaccount",method=RequestMethod.POST)//default is get
	public String readLogin(			
			@RequestParam("user1")//textboxname
			String user5,
			
			@RequestParam("pass1")//textboxname
			String pass4,
			
			//Built in interface=>take value from the controller and display in JSP RESPONSE FILE!
			Model mobj			
			)
	{
		if(user5.equals("Thananya"))  
		{  

			String msg="Hello "+ user5;  
			//add a message to the model  
			mobj.addAttribute("messageobj", msg); //OBJECT KEY,OBJECT VALUE
			return "successloginpage";  //1 view  jsp
		}
		else
		{
			String msg="Sorry! Invalid User Account "+ user5;  
			mobj.addAttribute("message1", msg);  
		     return "failureerrorpage"; //2 view jsp 
		       
		}

	}


}
