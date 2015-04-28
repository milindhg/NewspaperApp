package com.se.newspaperapp.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.newspaperapp.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		return "login";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email,
			@RequestParam("password") String password, Model model,
			HttpSession session) {

		User u = new User();
		u=u.getRegisteredUser(email, password);
		if (null == u) {
			model.addAttribute("message", "Login Unsuccessful");
			return "login";
		} else {
			switch (u.getRole()) {
			case 0:
				return "userview";
			case 1:
				return "editorview";
			case 2:
				return "superuserview";
			default:
				model.addAttribute("message", "User Unauthorized");
				return "login";
			}
		}
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);

		return "register";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerUser(@RequestParam("firstname") String firstName,
			@RequestParam("lastname") String lastName,
			@RequestParam("contactnumber") String contactNumber,
			@RequestParam("email") String email,
			@RequestParam("password") String password, Model model,
			HttpSession session) {

		User u = new User();
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setEmail(email);
		u.setPassword(password);
		u.setContactNumber(contactNumber);
		u.setRole(0);
		int res = u.addUser(u);
		if (res != -1)
			model.addAttribute("message", "User Successfully Created");
		else
			model.addAttribute("message", "Failure in user creation");
		return "login";
	}

}
