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
public class EntertainmentFeed extends Feed {

	public EntertainmentFeed() {
		department = 2;
		fdao = new FeedDAO();
	}

	public EntertainmentFeed(int id) {
		this.id=id;
		department = 2;
		fdao = new FeedDAO();
	}

	public EntertainmentFeed(String headline) {
		department = 2;
		this.headline = headline;
		fdao = new FeedDAO();
	}

	public EntertainmentFeed(int id, String headline) {
		this.id = id;
		department = 2;
		this.headline = headline;
		fdao = new FeedDAO();
	}

}
