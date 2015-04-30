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
public class SportsFeed extends Feed {

	public SportsFeed() {
		department = 3;
		fdao = new FeedDAO();
	}

	public SportsFeed(String headline) {
		department = 3;
		this.headline = headline;
		fdao = new FeedDAO();
	}

	@Override
	public Feed getFeed() {
		return null;
		// TODO Auto-generated method stub

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

	@Override
	public void deleteFeed() {
		/*
		 * try { fdao.deleteFeed(id); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
	}

}
