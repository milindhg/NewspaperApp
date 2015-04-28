package com.se.newspaperapp.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.se.newspaperapp.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("sessionUser")
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);
	private User uh = new User();

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
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
		u = u.getRegisteredUser(email, password);
		if (null == u) {
			model.addAttribute("message", "Login Unsuccessful");
			return "login";
		} else {
			model.addAttribute("sessionUser", u);
			return "redirect:home";
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

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "home")
	public String homeview(Locale locale, Model model, HttpSession session) {
		User u = (User) session.getAttribute("sessionUser");
		if (null == u)
			return "login";
		switch (u.getRole()) {
		case 0:
			return "userview";
		case 1:
			return "editorview";
		case 2:
			ArrayList<User> usersList = uh.getAllEditors();
			model.addAttribute("users", usersList);
			return "superuserview";
		default:
			model.addAttribute("message", "User Unauthorized");
		}
		return "login";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "adduser", method = RequestMethod.GET)
	public String addUser(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		return "adduser";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public String addUser(@RequestParam("firstname") String firstName,
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
		u.setRole(1);
		int res = u.addUser(u);

		return "redirect:home";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "deleteuser", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("userId") int userId, Model model,
			HttpSession session) {
		
		int res = uh.deleteUser(userId);

		return "redirect:home";
	}

}
