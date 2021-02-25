//Created by @AkhilD on 16/02/2021
package com.flightmgmt.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.flightmgmt.pojos.FlightDetails;
import com.flightmgmt.pojos.PassengerDetails;
import com.flightmgmt.service.FlightServiceImpl;

@Controller
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	private FlightServiceImpl flightService;

	@GetMapping("/search")
	public String showSearchPage() {
		return "/flight/search";
	}

	@PostMapping("/search")
	public String processSearchPage(@RequestParam String departureCity, @RequestParam String arrivalCity,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDate, Model map, HttpSession hs) {
		try {
			System.out.println("in search: " + departureCity + " " + arrivalCity + " " + departureDate);

			List<FlightDetails> fList = flightService.fetchFlightDetails(departureDate, departureCity, arrivalCity);

			hs.setAttribute("fList", fList);
			return "/flight/display";
		} catch (RuntimeException e) {
			map.addAttribute("mssg", "No flights scheduled on given details yet!!!");
			return "/flight/search";
		}
	}

	@GetMapping("/passDetails")
	public String showPassDetailsForm(Model map, PassengerDetails ps, @RequestParam int pid, @RequestParam int aid,
			HttpSession hs) {

		hs.setAttribute("pid", flightService.getFlightById(pid));
		hs.setAttribute("aid", flightService.getAirlinesById(aid));
		return "/flight/passDetails";
	}

	@PostMapping("/passDetails")
	public String processPassDetails(PassengerDetails ps, RedirectAttributes fs) {
		System.out.println("in process passenger: " + ps);

		fs.addFlashAttribute("passdets", ps);
		return "redirect:/flight/cardDetails";
	}

	@GetMapping("/cardDetails")
	public String showCardDetsForm(Model map, PassengerDetails ps) {

		return "/flight/cardDetails";
	}

	@PostMapping("/cardDetails")
	public String processCardDets(PassengerDetails ps, RedirectAttributes fs) {

		fs.addFlashAttribute("passdets", ps);
		return "redirect:/user/status";
	}

}
