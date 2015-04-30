package com.se.newspaperapp.controller;

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
import com.se.newspaperapp.model.creators.BusinessFeedEditor;
import com.se.newspaperapp.model.creators.EntertainmentFeedEditor;
import com.se.newspaperapp.model.creators.FeedEditor;
import com.se.newspaperapp.model.creators.SportsFeedEditor;
import com.se.newspaperapp.model.products.Feed;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FeedController {

	private static final Logger logger = LoggerFactory
			.getLogger(FeedController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "addfeed", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "addfeed";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "addfeed", method = RequestMethod.POST)
	public String login(@RequestParam("headline") String headline, Model model,
			HttpSession session) {
		User u = (User) session.getAttribute("sessionUser");
		if (null == u) {
			return "login";
		} else {
			int dept = u.getDepartment();
			FeedEditor feedEditor =null;
			Feed feed=null;
			switch(dept){
			case 1: 
				feedEditor = new BusinessFeedEditor();
				feed = feedEditor.createFeed(headline);
				feed.addFeed();
				break;
			case 2: 
				feedEditor = new EntertainmentFeedEditor();
				feed = feedEditor.createFeed(headline);
				feed.addFeed();
				break;
			case 3: 
				feedEditor = new SportsFeedEditor();
				feed = feedEditor.createFeed(headline);
				feed.addFeed();
				break;
				default:
					return "login";
			}
			return "redirect:home";
		}
	}

}
