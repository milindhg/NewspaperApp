package com.se.newspaperapp.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface IUserController {

	/**
	 * Show the login page
	 */
	public String login(Locale locale, Model model);

	/**
	 * Perform login by taking the username and password
	 */
	public String login(String email, String password, Model model,
			HttpSession session);

	/**
	 * Perform logout and redirect to login
	 */
	public String logout(Model model, HttpSession session);

	/**
	 * Show User registration page
	 */
	public String register(Locale locale, Model model, HttpSession session);

	/**
	 * Register user by taking the inputs
	 */
	public String registerUser(String firstName, String lastName,
			String contactNumber, String email, String password, Model model,
			HttpSession session);

	/**
	 * Show home view as per the user role
	 */
	public String homeview(Locale locale, Model model, HttpSession session);

	/**
	 * Show add user form
	 */
	public String addUser(Locale locale, Model model, HttpSession session);

	/**
	 * Add the user as per the given inputs
	 */
	public String addUser(String firstName, String lastName,
			String contactNumber, String email, String password,
			int department, Model model, HttpSession session);

	/**
	 * Delete the specified user
	 */
	public String deleteUser(int userId, Model model, HttpSession session);
}
