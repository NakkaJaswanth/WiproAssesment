package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller//A single controller CAN HAVE  MULTIPLE URL PATTERN(MULTIPLE RESPONSE)
public class RedirectionController {

	/*
	 * @RequestMapping is a general-purpose annotation that can handle requests of any HTTP method, 
	 * @GetMapping is tailored specifically for GET requests.
	 */
	
	//@RequestMapping(value="/myredirect1",method = RequestMethod.GET)//this is also valid!
	
	//http://localhost:8098/MyWiproBatch/myredirect1
	
	@GetMapping("/myredirect1")//Handle HTTP Get Requests ONLY
	public String my_redirect()
	{
		//local redirection(return another URL Pattern)
		//one requestmapping(myredirect1) calling another (myredirect2)requestmapping pattern
	
		//"redirect:" → Spring special prefix that triggers a redirect.
		return "redirect:myredirect2";//redirect the browser to a new URL instead of rendering a view.
	}
	
	@RequestMapping(value="/myredirect2",method = RequestMethod.GET)
	public String finalpage()
	{
		return "redirection";//redirection.jsp file name
	}

	/*
	 * "resources/static" directory::::
	 * 
	 * This directory is used to store static files such as HTML, CSS,
	 *  and JavaScript files that are served directly to the client without any processing by the server.
	 */
	//this file automatically lookup inside the src/main/resources/static directory!

	//http://localhost:8098/MyWiproBatch/myhtmlpages
	
		@GetMapping("/myhtmlpages")//Handle HTTP Get Requests
		public String page5()
		{
			return "redirect:mystaticwipropages/LoginPage.html";//NOT A JSP RESPONSE
		}
}
