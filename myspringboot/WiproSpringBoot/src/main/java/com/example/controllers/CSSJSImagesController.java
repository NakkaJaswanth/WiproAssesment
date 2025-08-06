package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CSSJSImagesController 
{
	@RequestMapping("/checkcssjs")
	public String dis()
	{
		return "cssjsimages";//VIEW JSP cssjsimages.jsp
	}
}
