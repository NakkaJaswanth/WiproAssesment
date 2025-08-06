package com.example.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Beanfiles.FormBean;

@Controller
public class FormBeanMVCController 
{
	//http://localhost:8098/MyWiproBatch/callpage
	
	@GetMapping("/callpage")
	public String disp(Model m)
	{

		FormBean bobj=new FormBean();//POJO CLASS/Bean class OBJECT
		
		//Sending select option values from controller to JSP
		/*HTML CODE:::::
		 * <select>
		 * <option value="UnitedStates">UnitedStates</option>
		 * </select>
		 */
		Map<String,String> c1=new HashMap();
		c1.put("UnitedStates", "UnitedStates");//<option>
		c1.put("Singapore", "Singapore");//<option>
		c1.put("Malaysia", "Malaysia");//<option>
		c1.put("India", "India");//<option>


		m.addAttribute("countryoptions",c1);//select form tag

		m.addAttribute("result",bobj);//************FormBean object stored in a attrvariable called result!
		return "FormLogin";//FormLogin.jsp contains =>	textbox,checkbox,radio,select	
	}
	//@ModelAttribute-sending BEAN form values to JSP
	//Spring automatically populates the object data with form data all behind the 
	//scenes in "myforms"

	/*
	 * RULE::
	 * If we r already having the bean class object in MODEL INTERFACE,
	 * then only we can use @ModelAttribute annotation
	 */
/*
 * Two Main Purposes of @ModelAttribute
1. Binding form data to a Java object
Happens automatically when form fields match object property names.

2. Populating model attributes before rendering a view
Adds objects to the model before a view (like JSP, Thymeleaf) is rendered.
 */
	@RequestMapping("/valid")//FormLogin.jsp action="valid"
	public String SubmitForm1
	(
			@ModelAttribute("myforms")//@ModelAttribute holds all form data(GETTER METHODS)
		FormBean obj79666//ALREADY EXISTS!!!OBJECT NAME IS RESULT(BOBJ)
	)	
	{			
							return "SuccessForm";//SuccessForm.jsp file	
	}

	
	
}
