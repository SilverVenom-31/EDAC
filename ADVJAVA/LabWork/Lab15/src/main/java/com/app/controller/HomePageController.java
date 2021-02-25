//Created by @AkhilD on 10/02/2021
package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	public HomePageController() {
		System.out.println("in constru: " + getClass().getName());
	}

//add req handling method for disp index.jsp
	@RequestMapping("/")
	public String showHomePage() {
		System.out.println("in homePage");
		return "/index"; //WEB-INF/views/index.jsp  <--veiw resolver
	}
}
