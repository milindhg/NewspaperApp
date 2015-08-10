package com.se.newspaperapp.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.newspaperapp.model.User;

/**
 * Handles requests for the feed management.
 */
@Controller
public class FeedControllerProxy implements IFeedController {

	FeedController feedController = new FeedController();
	
	/**
	 * Function to validate the editor. Redirect to login page if user is not authorized.
	 * @param session
	 * @return
	 */
	public boolean isEditorValid(HttpSession session) {
		User u = (User) session.getAttribute("sessionUser");
		if (null == u)
			return false;
		else if(u.getRole()!=1){  //If user is not an editor redirect to login.
			return false;
		}
		return true;
	}

	/**
	 * Display addfeed page to the editor.
	 */
	@Override
	@RequestMapping(value = "addfeed", method = RequestMethod.GET)
	public String addfeed(Locale locale, Model model, HttpSession session) {
		if(isEditorValid(session))
		return feedController.addfeed(locale, model, session);
		return "login";
	}


	/**
	 * Add the feed given by the user.
	 */
	@Override
	@RequestMapping(value = "addfeed", method = RequestMethod.POST)
	public String addfeed(@RequestParam("headline") String headline,
			Model model, HttpSession session) {
		if(isEditorValid(session))
		return feedController.addfeed(headline, model, session);
		return "login";
	}

	/**
	 * delete the feed selected by the user.
	 */
	@Override
	@RequestMapping(value = "deletefeed", method = RequestMethod.GET)
	public String deletefeed(@RequestParam("id") int id, Model model,
			HttpSession session) {
		if(isEditorValid(session))
		return feedController.deletefeed(id, model, session);
		return "login";
	}

	/**
	 * display edit feed page to hte editor.
	 */
	@Override
	@RequestMapping(value = "editfeed", method = RequestMethod.GET)
	public String editfeed(@RequestParam("id") int id, Model model, HttpSession session) {
		if(isEditorValid(session))
		return feedController.editfeed(id, model, session);
		return "login";
	}

	/**
	 * update the feed based on the input given by the editor.
	 */
	@Override
	@RequestMapping(value = "editfeed", method = RequestMethod.POST)
	public String editFeed(@RequestParam("id") int id,
			@RequestParam("headline") String headline, Model model,
			HttpSession session) {
		if(isEditorValid(session))
		return feedController.editFeed(id, headline, model, session);
		return "login";
	}

}
