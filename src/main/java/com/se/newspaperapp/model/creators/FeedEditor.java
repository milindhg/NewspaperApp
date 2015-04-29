/**
 * 
 */
package com.se.newspaperapp.model.creators;

import com.se.newspaperapp.model.User;
import com.se.newspaperapp.model.products.Feed;

/**
 * @author Milind
 *
 */
public abstract class FeedEditor {
	User editor;

	public abstract Feed createFeed(String headline);

	public void publishFeed(String headline) {
		Feed feed = createFeed(headline);
		feed.addFeed();
	}


}
