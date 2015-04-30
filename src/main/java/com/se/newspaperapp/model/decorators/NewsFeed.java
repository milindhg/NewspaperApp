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
public class NewsFeed extends FeedDecorator {

	ArrayList<Feed> feeds = null;

	public NewsFeed(ArrayList<Feed> feedslist) {
		feeds = feedslist;
	}

	@Override
	public void addFeed() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Feed> getFeeds(int channel) {
		for (Feed f : feeds) {
			f.setHeadline("Newspaper Feed:" + f.getHeadline());
		}
		return feeds;
	}

}
