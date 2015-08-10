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
	
	public ArrayList<Feed> getFeeds(int channel);
}
