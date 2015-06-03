/**
 * 
 */
package com.se.newspaperapp.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.se.newspaperapp.model.User;

/**
 * @author Milind Handles requests for the users handling.
 */
@Controller
@SessionAttributes("sessionUser")
public class UserControllerProxy implements IUserController {

	UserController userController = new UserController();

	/**
	 * Function to validate the user. Redirect to login page if user is not authorized.
	 * @param session
	 * @return
	 */
	public boolean isUserValid(HttpSession session) {
		User u = (User) session.getAttribute("sessionUser");
		if (null == u)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.se.newspaperapp.controller.IUserController#login(java.util.Locale,
	 * org.springframework.ui.Model)
	 */
	@Override
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		userController.login(locale, model);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.se.newspaperapp.controller.IUserController#login(java.lang.String,
	 * java.lang.String, org.springframework.ui.Model,
	 * javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email,
			@RequestParam("password") String password, Model model,
			HttpSession session) {
		return userController.login(email, password, model, session);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.se.newspaperapp.controller.IUserController#logout(org.springframework
	 * .ui.Model, javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(value = "logout")
	public String logout(Model model, HttpSession session) {
		return userController.logout(model, session);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.se.newspaperapp.controller.IUserController#register(java.util.Locale,
	 * org.springframework.ui.Model, javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(Locale locale, Model model, HttpSession session) {
		return userController.register(locale, model, session);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.se.newspaperapp.controller.IUserController#registerUser(java.lang
	 * .String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, org.springframework.ui.Model,
	 * javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerUser(@RequestParam("firstname") String firstName,
			@RequestParam("lastname") String lastName,
			@RequestParam("contactnumber") String contactNumber,
			@RequestParam("email") String email,
			@RequestParam("password") String password, Model model,
			HttpSession session) {
		return userController.registerUser(firstName, lastName, contactNumber,
				email, password, model, session);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.se.newspaperapp.controller.IUserController#homeview(java.util.Locale,
	 * org.springframework.ui.Model, javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String homeview(Locale locale, Model model, HttpSession session) {
		if(isUserValid(session))
		return userController.homeview(locale, model, session);
		return "login";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.se.newspaperapp.controller.IUserController#addUser(java.util.Locale,
	 * org.springframework.ui.Model)
	 */
	@Override
	@RequestMapping(value = "adduser", method = RequestMethod.GET)
	public String addUser(Locale locale, Model model,HttpSession session) {
		if(isUserValid(session))
		return userController.addUser(locale, model,session);
		return "login";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.se.newspaperapp.controller.IUserController#addUser(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * int, org.springframework.ui.Model, javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public String addUser(@RequestParam("firstname") String firstName,
			@RequestParam("lastname") String lastName,
			@RequestParam("contactnumber") String contactNumber,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("department") int department, Model model,
			HttpSession session) {
		if(isUserValid(session))
		return userController.addUser(firstName, lastName, contactNumber,
				email, password, department, model, session);
		return "login";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.se.newspaperapp.controller.IUserController#deleteUser(int,
	 * org.springframework.ui.Model, javax.servlet.http.HttpSession)
	 */
	@Override
	@RequestMapping(value = "deleteuser", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("userId") int userId, Model model,
			HttpSession session) {
		if(isUserValid(session))
		return userController.deleteUser(userId, model, session);
		return "login";
	}

}
