/**
 * 
 */
package com.se.newspaperapp.model.products;

import com.se.newspaperapp.dao.FeedDAO;
import com.se.newspaperapp.model.IFeed;

/**
 * @author Milind
 *
 */
public abstract class Feed implements IFeed {

	int id;
	String headline;
	int department;
	FeedDAO fdao;

	@Override
	public abstract void addFeed();

	// TODO Auto-generated method stub
	// TODO put the code to insert the feed from the view form into the
	// object in the feed products and then insert in db in the decorator
	// decorate and display in the DB.

	public abstract void deleteFeed();

	public abstract void getFeed();

	
}
