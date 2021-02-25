package com.app.controller;

import javax.annotation.PostConstruct;
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

import com.app.pojos.UserRole;
import com.app.pojos.Vendors;
import com.app.service.IVendorService;

@Controller // mandatory
@RequestMapping("/user") // optional: recommended for separation
public class UserController {

	// dependency
	@Autowired
	private IVendorService vendorService;

	public UserController() {
		// TODO Auto-generated constructor stub
		System.out.println("in constr: " + getClass().getName() + " " + vendorService);
	}

	@PostConstruct // just for checking
	public void anyInit() {
		System.out.println("after constr: " + vendorService);
	}

	// add request handling method for showing form
	@GetMapping("/login") // Key: /user/login , method=get
	// value: c.a.c.u.showLoginForm
	public String showLoginForm() {
		System.out.println("in showLogin");

		return "/user/login";
	}

	// add a req handling method for processing form
	@PostMapping("/login") // @RequestMapping + method=post
	// key: /user/login,method = post
	// value: c.a.c.u.processlOgin
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model model,
			HttpSession hs) {
		System.out.println("in processLogin " + email + " " + password);
//invoke service layer for BL
		try {
			Vendors user = vendorService.authenticateUser(email, password);
			// valid
			// save validated users under session scope

			hs.setAttribute("user_dets", user);
			hs.setAttribute("msg", user.getRole() + " " + user.getName() + " Login successful");
			if (user.getRole().equals(UserRole.ADMIN)) {
				// admin logged in
				return "redirect:/admin/list";
			}
			if (user.getRole().equals(UserRole.VENDOR)) {
				// admin logged in
				return "redirect:/vendor/details";
			}

		} catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println("err in controller: " + e);
			// invalid login
			// add error msg in model attr
			model.addAttribute("msg", "Invalid Login, Please retry");
			return "/user/login";
		}

		return "/vendor/details"; // actual view: /views/vendor/details.jsp

	}

	@GetMapping("/logout")
	public String userLogout(HttpSession hs, Model model, HttpServletRequest req, HttpServletResponse res) {
		// save user dets
		model.addAttribute("userDets", hs.getAttribute("user_dets"));
		System.out.println("in logout");
		// invalidate session
		hs.invalidate();
		// set refresh header to redirect/navigate client to home page(index.jsp) after
		// some delay

		res.setHeader("refresh", "5;url=" + req.getContextPath());
		return "/user/logout";
	}

}
