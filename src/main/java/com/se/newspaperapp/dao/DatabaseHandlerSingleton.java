package com.se.newspaperapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandlerSingleton {

	private static volatile DatabaseHandlerSingleton db;
	private static Connection con = null;

	// private Statement stmt = null;

	private static void createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bonusdb", "root", "root");
			con.createStatement();
		} catch (SQLException ex) {
			System.out.println("cannot query the database: " + ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println("cannot connect to MySQL database"
					+ ex.getMessage());
		}
	}

	public static Connection getDBConnection() {
		if (db == null) {
			synchronized (DatabaseHandlerSingleton.class) {
				if (db == null) {
					createConnection();
				}
			}
		}
		return con;
	}

	public static void close() {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
	}

	public void finalize() {
		close();
	}

}
