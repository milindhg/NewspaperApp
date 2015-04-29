package com.se.newspaperapp.model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.se.newspaperapp.dao.UserDAO;

/**
 * @author Milind
 *
 */
public class User {
	private int userId;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String email;
	private String password;
	private int role;
	private int department;
	UserDAO ud;

	public User() {
		userId = 0;
		firstName = null;
		lastName = null;
		contactNumber = null;
		email = null;
		password = null;
		role = 0;
		ud = new UserDAO();
	}

	public User(int userId, String firstName, String lastName,
			String contactNumber, String email, String password, int role,
			UserDAO ud) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.role = role;
		this.ud = ud;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param fname
	 *            the firstName to set
	 */
	public void setFirstName(String fname) {
		this.firstName = fname;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lname
	 *            the lastName to set
	 */
	public void setLastName(String lname) {
		this.lastName = lname;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber
	 *            the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public int getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}

	
	/**
	 * @return the department
	 */
	public int getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(int department) {
		this.department = department;
	}

	/**
	 * @param id
	 * @return
	 */
	public User getUser(int id) {
		User u = null;
		try {
			u = ud.selectUserByPrimaryKey(id);
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	/**
	 * @param id
	 * @return
	 */
	public User getRegisteredUser(String uname, String pwd) {
		User u = null;
		try {
			u = ud.selectUserByUnamePwd(uname, pwd);
			if(u!=null){
				u.setPassword(null);
			}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	/**
	 * @param id
	 * @return
	 */
	public ArrayList<User> getAllEditors() {
		ArrayList<User> ulist = null;
		try {
			ulist = ud.selectEditorsAll();
			return ulist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ulist;
	}

	/**
	 * @param id
	 * @return
	 */
	public int deleteUser(int id) {
		int res = -1;
		try {
			res = ud.deleteUser(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * @param u
	 * @return
	 */
	public int updateUser(User u) {
		int res = -1;
		try {
			res = ud.updateUser(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * @param u
	 * @return
	 */
	public int addUser(User u) {
		int res = -1;
		try {
			res = ud.insertUser(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", contactNumber=" + contactNumber
				+ ", email=" + email + ", password=" + password + ", role="
				+ role + ", ud=" + ud + "]";
	}
	
	

}
