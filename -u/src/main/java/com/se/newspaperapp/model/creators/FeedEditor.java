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

	public abstract Feed prepareDeleteFeed(int id);
	
	public abstract Feed prepareEditFeed(int id, String headline);

	public void publishFeed(int id, String headline) {
		Feed feed = createFeed(headline);
		feed.addFeed();
	}

}
