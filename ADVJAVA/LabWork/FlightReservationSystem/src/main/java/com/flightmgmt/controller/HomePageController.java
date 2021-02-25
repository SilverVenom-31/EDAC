//Created by @AkhilD on 16/02/2021
package com.flightmgmt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightmgmt.pojos.User;
import com.flightmgmt.service.UserServiceImpl;

@Controller
@RequestMapping("/")
public class HomePageController {
	@Autowired
	private UserServiceImpl userService;

	public HomePageController() {// to know the game has begun
		System.out.println("in constr: " + getClass().getName());
	}

	@GetMapping("/")
	public String showHomePage() {// providing login page
		return "/login";
	}

	@GetMapping(value = "/login")
	public String showLoginPage() {// providing login page
		return "/login";
	}

	@PostMapping(value = { "/", "/login" })
	public String processLoginPage(@RequestParam String email, @RequestParam String password, Model model,
			HttpSession hs) {// validating credential

		try {
			User user = userService.authenticateUser(email, password);
			// valid
			hs.setAttribute("user", user);

			return "redirect:/flight/search";
		} catch (RuntimeException e) {
			// invalid login
			// adding error msg in model attr
			model.addAttribute("msg", "Invalid Login, Please retry");
			return "/login";
		}

	}

	@GetMapping("/bookingConfirmed")
	public String showLogout(HttpSession hs,HttpServletRequest req, HttpServletResponse res) {
		hs.invalidate();
		res.setHeader("refresh", "5;url=" + req.getContextPath());
		return "/bookingConfirmed";
	}

}
