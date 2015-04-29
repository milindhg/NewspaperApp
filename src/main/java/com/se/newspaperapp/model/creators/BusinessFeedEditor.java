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

}
