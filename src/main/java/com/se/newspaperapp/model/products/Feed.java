/**
 * 
 */
package com.se.newspaperapp.model.products;

import java.sql.SQLException;
import java.util.ArrayList;

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
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the headline
	 */
	public String getHeadline() {
		return headline;
	}

	/**
	 * @param headline the headline to set
	 */
	public void setHeadline(String headline) {
		this.headline = headline;
	}

	/**
	 * @return the department
	 */
	public int getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(int department) {
		this.department = department;
	}

	/**
	 * @return the fdao
	 */
	public FeedDAO getFdao() {
		return fdao;
	}

	/**
	 * @param fdao the fdao to set
	 */
	public void setFdao(FeedDAO fdao) {
		this.fdao = fdao;
	}

	FeedDAO fdao;

	@Override
	public abstract void addFeed();

	// TODO Auto-generated method stub
	// TODO put the code to insert the feed from the view form into the
	// object in the feed products and then insert in db in the decorator
	// decorate and display in the DB.

	public abstract void deleteFeed();

	public abstract Feed getFeed();
	
	@Override
	public ArrayList<Feed> getFeeds(int channel) {
		ArrayList<Feed> feeds = null;
		try {
			feeds = fdao.selectFeedsByEditor(department);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return feeds;
	}


	
}
