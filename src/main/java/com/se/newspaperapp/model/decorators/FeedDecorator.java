/**
 * 
 */
package com.se.newspaperapp.model.decorators;

import java.util.ArrayList;

import com.se.newspaperapp.model.IFeed;
import com.se.newspaperapp.model.products.Feed;

/**
 * @author Milind
 *
 */
public abstract class FeedDecorator implements IFeed {

	/* (non-Javadoc)
	 * @see com.se.newspaperapp.model.IFeed#getFeed()
	 */
	@Override
	public abstract ArrayList<Feed> getFeeds(int channel);
}
