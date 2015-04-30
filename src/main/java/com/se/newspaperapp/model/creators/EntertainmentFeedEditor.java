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

	/* (non-Javadoc)
	 * @see com.se.newspaperapp.model.creators.FeedEditor#createFeed(java.lang.String)
	 */
	@Override
	public Feed createFeed(String headline) {
		Feed feed = new EntertainmentFeed(headline);
		return feed;
	}

}
