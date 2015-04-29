/**
 * 
 */
package com.se.newspaperapp.model.products;

import java.sql.SQLException;

import com.se.newspaperapp.dao.FeedDAO;

/**
 * @author Milind
 *
 */
public class BusinessFeed extends Feed {

	public BusinessFeed(String headline){
		department=1;
		this.headline = headline;
		fdao = new FeedDAO();
	}
	
	@Override
	public void deleteFeed() {
/*		try {
			fdao.deleteFeed(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

	@Override
	public void getFeed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addFeed() {
		try {
			fdao.insertFeed(headline,department);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
