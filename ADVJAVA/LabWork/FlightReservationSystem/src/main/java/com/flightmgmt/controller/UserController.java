//Created by @AkhilD on 16/02/2021
package com.flightmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.flightmgmt.pojos.User;
import com.flightmgmt.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/registration")
	public String showRegistrationPage(Model model, User user) {// providing registration form
		return "/user/registration";
	}

	@PostMapping("/registration") // registering user
	public String processRegistration(User user, RedirectAttributes model) {
		model.addFlashAttribute("msg", userService.registeredUser(user));
		return "redirect:/login";
	}

	@GetMapping("/status")
	public String showStatusPage() {
		return "/user/status";
	}

}
