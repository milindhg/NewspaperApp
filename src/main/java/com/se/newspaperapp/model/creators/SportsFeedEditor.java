/**
 * 
 */
package com.se.newspaperapp.model.creators;

import com.se.newspaperapp.model.products.Feed;
import com.se.newspaperapp.model.products.SportsFeed;

/**
 * @author Milind
 *
 */
public class SportsFeedEditor extends FeedEditor {

	/* (non-Javadoc)
	 * @see com.se.newspaperapp.model.FeedCreator#createFeed()
	 */
	@Override
	public Feed createFeed(String headline) {
		Feed feed = new SportsFeed(headline);
		return feed;
	}

}
