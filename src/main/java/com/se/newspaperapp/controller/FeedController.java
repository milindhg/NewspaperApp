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

public class FeedController implements IFeedController  {

	private static final Logger logger = LoggerFactory
			.getLogger(FeedController.class);

	/**
	 * Display addfeed page to the editor.
	 */
	public String addfeed(Locale locale, Model model,HttpSession session) {
		model.addAttribute("sessionUser",session.getAttribute("sessionUser"));
		return "addfeed";
	}

	/**
	 * Add the feed given by the user.
	 */
	public String addfeed(String headline, Model model, HttpSession session) {
		User u = (User) session.getAttribute("sessionUser");
		if (null == u) {
			return "login";
		} else {
			int dept = u.getDepartment();
			FeedEditor feedEditor = null;
			Feed feed = null;
			switch (dept) {
			case 1:
				feedEditor = new BusinessFeedEditor();
				feed = feedEditor.createFeed(headline);
				break;
			case 2:
				feedEditor = new EntertainmentFeedEditor();
				feed = feedEditor.createFeed(headline);
				break;
			case 3:
				feedEditor = new SportsFeedEditor();
				feed = feedEditor.createFeed(headline);
				break;
			default:
				return "login";
			}
			feed.addFeed();
			return "redirect:home";
		}
	}

	/**
	 * delete the feed selected by the user.
	 */
	public String deletefeed(int id, Model model, HttpSession session) {
		User u = (User) session.getAttribute("sessionUser");
		if (null == u) {
			return "login";
		} else {
			int dept = u.getDepartment();
			FeedEditor feedEditor = null;
			Feed feed = null;
			switch (dept) {
			case 1:
				feedEditor = new BusinessFeedEditor();
				break;
			case 2:
				feedEditor = new EntertainmentFeedEditor();
				break;
			case 3:
				feedEditor = new SportsFeedEditor();
				break;
			default:
				return "login";
			}
			feed = feedEditor.prepareDeleteFeed(id);
			feed.deleteFeed();
			return "redirect:home";
		}
	}


	/**
	 * display edit feed page to hte editor.
	 */
	public String editfeed(int id, Model model, HttpSession session) {
		User u = (User) session.getAttribute("sessionUser");
		if (null == u) {
			return "login";
		} else {
			int dept = u.getDepartment();
			FeedEditor feedEditor = null;
			Feed feed = null;
			switch (dept) {
			case 1:
				feedEditor = new BusinessFeedEditor();
				break;
			case 2:
				feedEditor = new EntertainmentFeedEditor();
				break;
			case 3:
				feedEditor = new SportsFeedEditor();
				break;
			default:
				return "login";
			}
			feed = feedEditor.prepareDeleteFeed(id);
			feed = feed.getFeed();
			model.addAttribute("feed",feed);
			model.addAttribute("sessionUser",session.getAttribute("sessionUser"));
			return "editfeed";
		}

	}

	/**
	 * update the feed based on the input given by the editor.
	 */
	public String editFeed(int id, String headline, Model model,
			HttpSession session) {
		User u = (User) session.getAttribute("sessionUser");
		if (null == u) {
			return "login";
		} else {
			int dept = u.getDepartment();
			FeedEditor feedEditor = null;
			Feed feed = null;
			switch (dept) {
			case 1:
				feedEditor = new BusinessFeedEditor();
				break;
			case 2:
				feedEditor = new EntertainmentFeedEditor();
				break;
			case 3:
				feedEditor = new SportsFeedEditor();
				break;
			default:
				return "login";
			}
			feed = feedEditor.prepareEditFeed(id, headline);
			feed.editFeed();
			return "redirect:home";
		}
	}

}
