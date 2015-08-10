package com.se.newspaperapp.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface IFeedController {

	/**
	 * Display addfeed page to the editor.
	 */
	public String addfeed(Locale locale, Model model, HttpSession session);

	/**
	 * Add the feed given by the user.
	 */
	public String addfeed(String headline, Model model, HttpSession session);

	/**
	 * delete the feed selected by the user.
	 */
	public String deletefeed(int id, Model model, HttpSession session);

	/**
	 * diaplay edit feed page to hte editor.
	 */
	public String editfeed(int id, Model model, HttpSession session);

	/**
	 * update the feed based on the input given by the editor.
	 */
	public String editFeed(int id, String headline, Model model,
			HttpSession session);
}
