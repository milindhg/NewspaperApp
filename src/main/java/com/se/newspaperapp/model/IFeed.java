/**
 * 
 */
package com.se.newspaperapp.model;

import java.util.ArrayList;

import com.se.newspaperapp.model.products.Feed;


/**
 * @author Milind
 *
 */
public interface IFeed {
	
	public void addFeed();
	/*public void getFeed();
	void deleteFeed(int id);*/
	public ArrayList<Feed> getFeeds(int channel);
}
