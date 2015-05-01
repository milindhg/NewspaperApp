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
public class TwitterFeed extends FeedDecorator {

	ArrayList<Feed> feeds = null;

	public TwitterFeed(ArrayList<Feed> feedslist) {
		feeds = feedslist;
	}

	@Override
	public ArrayList<Feed> getFeeds(int channel) {
		for (Feed f : feeds) {
			f.setHeadline("Twitter Feed:" + f.getHeadline());
		}
		return feeds;
	}

}
