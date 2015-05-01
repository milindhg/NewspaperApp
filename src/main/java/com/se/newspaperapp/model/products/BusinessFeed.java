/**
 * 
 */
package com.se.newspaperapp.model.products;

import java.sql.SQLException;
import java.util.ArrayList;

import com.se.newspaperapp.dao.FeedDAO;

/**
 * @author Milind
 *
 */
public class BusinessFeed extends Feed {

	public BusinessFeed() {
		department = 1;
		fdao = new FeedDAO();
	}

	public BusinessFeed(int id) {
		this.id=id;
		department = 1;
		fdao = new FeedDAO();
	}

	public BusinessFeed(String headline) {
		department = 1;
		this.headline = headline;
		fdao = new FeedDAO();		
	}

	public BusinessFeed(int id, String headline) {
		this.id=id;
		department = 1;
		this.headline = headline;
		fdao = new FeedDAO();
	}

}
