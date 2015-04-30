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
public class GenericFeed extends Feed {

	public GenericFeed() {
		fdao = new FeedDAO();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.se.newspaperapp.model.IFeed#getFeeds()
	 */
	@Override
	public ArrayList<Feed> getFeeds(int channel) {
		ArrayList<Feed> feeds = null;
		try {
			switch (channel) {
			case 1:
				feeds = fdao.selectInternetFeeds();
				break;
			case 2:
				feeds = fdao.selectNewsFeeds();
				break;
			case 3:
				feeds = fdao.selectTwitterFeeds();
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return feeds;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.se.newspaperapp.model.products.Feed#addFeed()
	 */
	@Override
	public void addFeed() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.se.newspaperapp.model.products.Feed#deleteFeed()
	 */
	@Override
	public void deleteFeed() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.se.newspaperapp.model.products.Feed#getFeed()
	 */
	@Override
	public Feed getFeed() {
		// TODO Auto-generated method stub
		return null;
	}

}
