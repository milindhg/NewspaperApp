/**
 * 
 */
package com.se.newspaperapp.model.decorators;

import java.util.ArrayList;
import com.se.newspaperapp.model.products.Feed;

/**
 * @author Milind
 *
 */
public class InternetFeed extends FeedDecorator {

	ArrayList<Feed> feeds = null;

	public InternetFeed(ArrayList<Feed> feedslist) {
		feeds = feedslist;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.se.newspaperapp.model.FeedDecorator#getFeed()
	 */
	@Override
	public ArrayList<Feed> getFeeds(int channel) {
		for (Feed f : feeds) {
			f.setHeadline("Internet Feed:" + f.getHeadline());
		}
		return feeds;
	}

}
