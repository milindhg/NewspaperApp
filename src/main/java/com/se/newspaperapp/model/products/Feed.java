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
	 * @param id
	 *            the id to set
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
	 * @param headline
	 *            the headline to set
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
	 * @param department
	 *            the department to set
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
	 * @param fdao
	 *            the fdao to set
	 */
	public void setFdao(FeedDAO fdao) {
		this.fdao = fdao;
	}

	FeedDAO fdao;

	public void addFeed() {
		try {
			fdao.insertFeed(headline, department);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editFeed() {
		try {
			fdao.updateFeed(id, headline, department);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteFeed() {
		try {
			fdao.deleteFeed(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Feed getFeed() {
		Feed feed=null;
		try {
			feed= fdao.selectFeedByPrimaryKey(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return feed;
	}

	@Override
	public ArrayList<Feed> getFeeds(int channel) {
		ArrayList<Feed> feeds = null;
		try {
			feeds = fdao.selectFeedsByEditor(department);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return feeds;
	}

}
