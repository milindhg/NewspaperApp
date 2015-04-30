/**
 * 
 */
package com.se.newspaperapp.model.products;

import java.sql.SQLException;
import java.util.ArrayList;

import com.se.newspaperapp.dao.FeedDAO;

/**
 * @author Milind
 *
 */
public class BusinessFeed extends Feed {

	public BusinessFeed() {
		department = 1;
		fdao = new FeedDAO();
	}

	public BusinessFeed(String headline) {
		department = 1;
		this.headline = headline;
		
	}

	@Override
	public void deleteFeed() {
		/*
		 * try { fdao.deleteFeed(id); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
	}

	@Override
	public Feed getFeed() {
		return null;

	}

	@Override
	public void addFeed() {
		try {
			fdao.insertFeed(headline, department);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
