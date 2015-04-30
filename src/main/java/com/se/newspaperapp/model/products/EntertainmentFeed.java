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
public class EntertainmentFeed extends Feed {

	public EntertainmentFeed() {
		department = 2;
		fdao = new FeedDAO();
	}

	public EntertainmentFeed(String headline) {
		department = 2;
		this.headline = headline;
		fdao = new FeedDAO();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.se.newspaperapp.model.Feed#addFeed()
	 */
	@Override
	public void addFeed() {
		try {
			fdao.insertFeed(headline, department);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.se.newspaperapp.model.Feed#getFeed()
	 */
	@Override
	public Feed getFeed() {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFeed() {
		/*
		 * try { fdao.deleteFeed(id); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
	}

}
