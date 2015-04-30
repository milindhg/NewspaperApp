package com.se.newspaperapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.se.newspaperapp.model.products.BusinessFeed;
import com.se.newspaperapp.model.products.EntertainmentFeed;
import com.se.newspaperapp.model.products.Feed;
import com.se.newspaperapp.model.products.GenericFeed;
import com.se.newspaperapp.model.products.SportsFeed;

public class FeedDAO {
	Connection con = null;
	private String SELECT_NEWSFEED;
	private String INSERT_NEWSFEED;
	private String UPDATE_NEWSFEED;
	private String DELETE_NEWSFEED;
	private String SELECT_INTERNETFEED;
	private String INSERT_INTERNETFEED;
	private String UPDATE_INTERNETFEED;
	private String DELETE_INTERNETFEED;
	private String SELECT_TWITTERFEED;
	private String INSERT_TWITTERFEED;
	private String UPDATE_TWITTERFEED;
	private String DELETE_TWITTERFEED;
	private String GET_SEQUENCE;
	private String UPDATE_SEQUENCE;

	/**
	 * Constructor
	 */
	public FeedDAO() {
		SELECT_NEWSFEED = "SELECT news_feed.id, news_feed.headline, news_feed.department FROM news_feed";
		INSERT_NEWSFEED = "INSERT INTO news_feed (id, headline, department) VALUES (?, ?, ?);";
		UPDATE_NEWSFEED = "UPDATE news_feed SET headline = ?, department = ? WHERE id = ?;";
		DELETE_NEWSFEED = "DELETE FROM news_feed WHERE id = ?;";
		SELECT_INTERNETFEED = "SELECT internet_feed.id, internet_feed.headline, internet_feed.department FROM internet_feed";
		INSERT_INTERNETFEED = "INSERT INTO internet_feed (id, headline, department) VALUES (?, ?, ?);";
		UPDATE_INTERNETFEED = "UPDATE internet_feed SET headline = ?, department = ? WHERE id = ?;";
		DELETE_INTERNETFEED = "DELETE FROM internet_feed WHERE id = ?;";
		SELECT_TWITTERFEED = "SELECT twitter_feed.id, twitter_feed.headline, twitter_feed.department FROM twitter_feed";
		INSERT_TWITTERFEED = "INSERT INTO twitter_feed (id, headline, department) VALUES (?, ?, ?);";
		UPDATE_TWITTERFEED = "UPDATE twitter_feed SET headline = ?, department = ? WHERE id = ?;";
		DELETE_TWITTERFEED = "DELETE FROM twitter_feed WHERE id = ?;";
		GET_SEQUENCE = "SELECT id_seq from sequence;";
		UPDATE_SEQUENCE = "UPDATE sequence SET id_seq=? where id_seq=?";
		con = DatabaseHandlerSingleton.getDBConnection();
	}

	public int getSeqId() {
		int currSeqId = -1;
		try {
			currSeqId = selectCurrSequenceId();
			updateCurrSequenceId(currSeqId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currSeqId;
	}

	/**
	 * @return List of Feeds
	 * @throws SQLException
	 */
	public int selectCurrSequenceId() throws SQLException {
		String SelectSeqIdStatement = GET_SEQUENCE;
		PreparedStatement ps = null;
		ResultSet rSet = null;
		try {
			con = DatabaseHandlerSingleton.getDBConnection();
			ps = con.prepareStatement(SelectSeqIdStatement);
			rSet = ps.executeQuery();
			int currSeq = -1;
			if (rSet != null) {
				while (rSet.next()) {
					currSeq = rSet.getInt("id_seq");
				}
			}
			return currSeq;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rSet != null)
				rSet.close();
			if (ps != null)
				ps.close();
		}

	}

	/**
	 * @return List of Feeds
	 * @throws SQLException
	 */
	public void updateCurrSequenceId(int oldSeqId) throws SQLException {
		String UpdateSeqIdStatement = UPDATE_SEQUENCE;
		PreparedStatement ps = null;
		int res = -1;
		try {
			con = DatabaseHandlerSingleton.getDBConnection();
			ps = con.prepareStatement(UpdateSeqIdStatement);
			ps.setInt(1, oldSeqId + 1);
			ps.setInt(2, oldSeqId);
			res = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}

	}

	/**
	 * @return List of Feeds
	 * @throws SQLException
	 */

	public ArrayList<Feed> selectFeedsByEditor(int dept) throws SQLException {
		String SelectNewsFeedsByEditorStatement = SELECT_NEWSFEED
				+ " WHERE department=?;";
		PreparedStatement ps = null;
		ResultSet rSet = null;
		try {
			con = DatabaseHandlerSingleton.getDBConnection();
			ps = con.prepareStatement(SelectNewsFeedsByEditorStatement);
			ps.setInt(1, dept);
			rSet = ps.executeQuery();
			ArrayList<Feed> feeds = new ArrayList<Feed>();
			Feed feed = null;
			if (rSet != null) {
				while (rSet.next()) {
					feed = new GenericFeed();
					feed.setId(rSet.getInt("id"));
					feed.setHeadline(rSet.getString("headline"));
					feed.setDepartment(rSet.getInt("department"));
					feeds.add(feed);
				}
			}
			return feeds;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rSet != null)
				rSet.close();
			if (ps != null)
				ps.close();
		}

	}

	public ArrayList<Feed> selectNewsFeeds() throws SQLException {
		String SelectNewsFeedsAllStatement = SELECT_NEWSFEED;
		PreparedStatement ps = null;
		ResultSet rSet = null;
		try {
			con = DatabaseHandlerSingleton.getDBConnection();
			ps = con.prepareStatement(SelectNewsFeedsAllStatement);
			rSet = ps.executeQuery();
			ArrayList<Feed> feeds = new ArrayList<Feed>();
			Feed feed = null;
			if (rSet != null) {
				while (rSet.next()) {
					feed = new GenericFeed();
					feed.setId(rSet.getInt("id"));
					feed.setHeadline(rSet.getString("headline"));
					feed.setDepartment(rSet.getInt("department"));
					feeds.add(feed);
				}
			}
			return feeds;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rSet != null)
				rSet.close();
			if (ps != null)
				ps.close();
		}

	}

	public ArrayList<Feed> selectInternetFeeds() throws SQLException {
		String SelectInternetFeedsAllStatement = SELECT_INTERNETFEED;
		PreparedStatement ps = null;
		ResultSet rSet = null;
		try {
			con = DatabaseHandlerSingleton.getDBConnection();
			ps = con.prepareStatement(SelectInternetFeedsAllStatement);
			rSet = ps.executeQuery();
			ArrayList<Feed> feeds = new ArrayList<Feed>();
			Feed feed = null;
			if (rSet != null) {
				while (rSet.next()) {
					feed = new GenericFeed();
					feed.setId(rSet.getInt("id"));
					feed.setHeadline(rSet.getString("headline"));
					feed.setDepartment(rSet.getInt("department"));
					feeds.add(feed);
				}
			}
			return feeds;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rSet != null)
				rSet.close();
			if (ps != null)
				ps.close();
		}

	}

	public ArrayList<Feed> selectTwitterFeeds() throws SQLException {
		String SelectTwitterFeedsAllStatement = SELECT_TWITTERFEED;
		PreparedStatement ps = null;
		ResultSet rSet = null;
		try {
			con = DatabaseHandlerSingleton.getDBConnection();
			ps = con.prepareStatement(SelectTwitterFeedsAllStatement);
			rSet = ps.executeQuery();
			ArrayList<Feed> feeds = new ArrayList<Feed>();
			Feed feed = null;
			if (rSet != null) {
				while (rSet.next()) {
					feed = new GenericFeed();
					feed.setId(rSet.getInt("id"));
					feed.setHeadline(rSet.getString("headline"));
					feed.setDepartment(rSet.getInt("department"));
					feeds.add(feed);
				}
			}
			return feeds;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rSet != null)
				rSet.close();
			if (ps != null)
				ps.close();
		}

	}

	/**
	 * @return List of Feeds by department id
	 * @throws SQLException
	 */
	/*
	 * public ArrayList<Feed> selectFeedsByDeptId(int deptId) throws
	 * SQLException { String SelectFeedsByDeptStatement = SELECT +
	 * " where department=?"; PreparedStatement ps = null; ResultSet rSet =
	 * null; try { con = DatabaseHandlerSingleton.getDBConnection(); ps =
	 * con.prepareStatement(SelectFeedsByDeptStatement); ps.setInt(1, deptId);
	 * rSet = ps.executeQuery(); ArrayList<Feed> Feeds = new ArrayList<Feed>();
	 * if (rSet != null) { while (rSet.next()) { Feed nf = new Feed();
	 * nf.setId(rSet.getInt("id")); nf.setHeadline(rSet.getString("headline"));
	 * nf.setDepartment(rSet.getInt("department")); Feeds.add(nf); } } return
	 * Feeds; } catch (SQLException e) { e.printStackTrace(); throw e; } finally
	 * { if (rSet != null) rSet.close(); if (ps != null) ps.close(); }
	 * 
	 * }
	 * 
	 * public Feed selectFeedByPrimaryKey(int id) throws SQLException { String
	 * SelectFeedByPrimaryKeyStatement = SELECT + " where news_feed.id=?;";
	 * PreparedStatement ps = null; ResultSet rSet = null; try { con =
	 * DatabaseHandlerSingleton.getDBConnection(); ps =
	 * con.prepareStatement(SelectFeedByPrimaryKeyStatement); ps.setInt(1, id);
	 * rSet = ps.executeQuery(); if (rSet.next()) { Feed nf = new Feed();
	 * nf.setId(rSet.getInt("id")); nf.setHeadline(rSet.getString("headline"));
	 * nf.setDepartment(rSet.getInt("department")); return nf; } else return
	 * null; } catch (SQLException e) { e.printStackTrace(); throw e; } finally
	 * { if (rSet != null) rSet.close(); if (ps != null) ps.close();
	 * 
	 * } }
	 */

	/**
	 * @param u
	 * @throws SQLException
	 */
	public void insertFeed(String headline, int department) throws SQLException {
		int id_seq = getSeqId();
		insertNewsFeed(id_seq, headline, department);
		insertInternetFeed(id_seq, headline, department);
		insertTwitterFeed(id_seq, headline, department);
	}

	/**
	 * @param u
	 * @return
	 * @throws SQLException
	 */
	public int insertNewsFeed(int id, String headline, int department)
			throws SQLException {
		con = DatabaseHandlerSingleton.getDBConnection();
		String insertFeedStatement = INSERT_NEWSFEED;
		PreparedStatement ps = null;
		int result = -1;
		try {
			con = DatabaseHandlerSingleton.getDBConnection();
			ps = con.prepareStatement(insertFeedStatement);
			ps.setInt(1, id);
			ps.setString(2, headline);
			ps.setInt(3, department);
			result = ps.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	/**
	 * @param u
	 * @return
	 * @throws SQLException
	 */
	public int insertInternetFeed(int id, String headline, int department)
			throws SQLException {
		con = DatabaseHandlerSingleton.getDBConnection();
		String insertFeedStatement = INSERT_INTERNETFEED;
		PreparedStatement ps = null;
		int result = -1;
		try {
			con = DatabaseHandlerSingleton.getDBConnection();
			ps = con.prepareStatement(insertFeedStatement);
			ps.setInt(1, id);
			ps.setString(2, headline);
			ps.setInt(3, department);
			result = ps.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	/**
	 * @param u
	 * @return
	 * @throws SQLException
	 */
	public int insertTwitterFeed(int id, String headline, int department)
			throws SQLException {
		con = DatabaseHandlerSingleton.getDBConnection();
		String insertFeedStatement = INSERT_TWITTERFEED;
		PreparedStatement ps = null;
		int result = -1;
		try {
			con = DatabaseHandlerSingleton.getDBConnection();
			ps = con.prepareStatement(insertFeedStatement);
			ps.setInt(1, id);
			ps.setString(2, headline);
			ps.setInt(3, department);
			result = ps.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	/*
	 * public int updateFeed(Feed nf) throws SQLException { String
	 * updateFeedStatement = UPDATE; PreparedStatement ps = null; int result =
	 * -1; try { con = DatabaseHandlerSingleton.getDBConnection(); ps =
	 * con.prepareStatement(updateFeedStatement); ps.setString(1,
	 * nf.getHeadline()); ps.setInt(2, nf.getDepartment()); result =
	 * ps.executeUpdate(); return result; } catch (SQLException e) {
	 * e.printStackTrace(); throw e; } finally { if (ps != null) ps.close();
	 * 
	 * } }
	 * 
	 * public int deleteFeed(int id) throws SQLException { String
	 * updateFeedStatement = DELETE; PreparedStatement ps = null; int result =
	 * -1; try { con = DatabaseHandlerSingleton.getDBConnection(); ps =
	 * con.prepareStatement(updateFeedStatement); ps.setInt(1, id); result =
	 * ps.executeUpdate(); return result; } catch (SQLException e) {
	 * e.printStackTrace(); throw e; } finally { if (ps != null) ps.close(); } }
	 */

}
