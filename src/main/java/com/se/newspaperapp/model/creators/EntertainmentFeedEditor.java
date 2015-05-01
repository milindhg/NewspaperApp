/**
 * 
 */
package com.se.newspaperapp.model.creators;

import com.se.newspaperapp.model.products.EntertainmentFeed;
import com.se.newspaperapp.model.products.Feed;

/**
 * @author Milind
 *
 */
public class EntertainmentFeedEditor extends FeedEditor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.se.newspaperapp.model.creators.FeedEditor#createFeed(java.lang.String
	 * )
	 */
	@Override
	public Feed createFeed(String headline) {
		Feed feed = new EntertainmentFeed(headline);
		return feed;
	}

	@Override
	public Feed prepareDeleteFeed(int id) {
		Feed feed = new EntertainmentFeed(id);
		return feed;
	}

	@Override
	public Feed prepareEditFeed(int id, String headline) {
		Feed feed = new EntertainmentFeed(id, headline);
		return feed;
	}

}
