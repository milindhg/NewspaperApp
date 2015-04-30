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

import com.se.newspaperapp.dao.DatabaseHandlerSingleton;
import com.se.newspaperapp.model.User;
import com.se.newspaperapp.model.decorators.InternetFeed;
import com.se.newspaperapp.model.decorators.NewsFeed;
import com.se.newspaperapp.model.decorators.TwitterFeed;
import com.se.newspaperapp.model.products.BusinessFeed;
import com.se.newspaperapp.model.products.EntertainmentFeed;
import com.se.newspaperapp.model.products.Feed;
import com.se.newspaperapp.model.products.GenericFeed;
import com.se.newspaperapp.model.products.SportsFeed;

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
	@RequestMapping(value = "logout")
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		model.asMap().clear();
		DatabaseHandlerSingleton.close();
		return "login";
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
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String homeview(Locale locale, Model model, HttpSession session) {
		User u = (User) session.getAttribute("sessionUser");
		Feed feed =null;
		ArrayList<Feed> feeds =null;
		if (null == u)
			return "login";
		switch (u.getRole()) {
		case 0:	//Role is User
			feed = new GenericFeed();
			feeds = feed.getFeeds(1);
			InternetFeed internetFeeds = new InternetFeed(feeds);
			feeds = internetFeeds.getFeeds(1);
			model.addAttribute("internetfeeds", feeds);

			feed = new GenericFeed();
			feeds= feed.getFeeds(1);
			NewsFeed newspaperFeeds = new NewsFeed(feeds);
			feeds = newspaperFeeds.getFeeds(1);
			model.addAttribute("newspaperfeeds", feeds);
			
			feed = new GenericFeed();
			feeds = feed.getFeeds(1);
			TwitterFeed twitterFeeds = new TwitterFeed(feeds);
			feeds = twitterFeeds.getFeeds(1);
			model.addAttribute("twitterfeeds", feeds);
			return "userview";
		case 1:  //Role is editor
			int dept = u.getDepartment();
			switch(dept){
			case 1: 	//Department is Business
				feed = new BusinessFeed();
				break;
			case 2: 	//Department is Entertainment
				feed = new EntertainmentFeed();
				break;
			case 3: 	//Department is Sports
				feed = new SportsFeed();
				break;
			}
				feeds = feed.getFeeds(1);
				model.addAttribute("feeds", feeds);

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
			@RequestParam("password") String password,
			@RequestParam("department") int department, Model model,
			HttpSession session) {
		User u = new User();
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setEmail(email);
		u.setPassword(password);
		u.setContactNumber(contactNumber);
		u.setRole(1);
		u.setDepartment(department);
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
