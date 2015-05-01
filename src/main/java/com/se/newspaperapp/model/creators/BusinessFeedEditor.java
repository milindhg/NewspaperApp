/**
 * 
 */
package com.se.newspaperapp.model.creators;

import com.se.newspaperapp.model.products.BusinessFeed;
import com.se.newspaperapp.model.products.Feed;

/**
 * @author Milind
 *
 */
public class BusinessFeedEditor extends FeedEditor {

	@Override
	public Feed createFeed(String headline) {
		Feed feed = new BusinessFeed(headline);
		return feed;
	}

	@Override
	public Feed prepareDeleteFeed(int id) {
		Feed feed = new BusinessFeed(id);
		return feed;
	}

	@Override
	public Feed prepareEditFeed(int id, String headline) {
		Feed feed = new BusinessFeed(id,headline);
		return feed;
	}
		

}
