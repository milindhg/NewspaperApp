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
public class SportsFeed extends Feed {

	public SportsFeed() {
		department = 3;
		fdao = new FeedDAO();
	}

	public SportsFeed(int id) {
		this.id=id;
		department = 3;
		fdao = new FeedDAO();
	}

	public SportsFeed(String headline) {
		department = 3;
		this.headline = headline;
		fdao = new FeedDAO();
	}

	public SportsFeed(int id,String headline) {
		this.id=id;
		department = 3;
		this.headline = headline;
		fdao = new FeedDAO();
	}

}
