/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesp;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author GertLehmann
 */
public class DBConnector {
	private Connection connection = null;
	
	//Constants
	private static final String IP          = "localhost";
	private static final String PORT	= "3306";
	private static final String DATABASE	= "teams_and_users";
	private static final String USERNAME	= "root";
	private static final String PASSWORD	= "Akeelah1971>";      	
	
	public DBConnector() throws Exception {
  		Class.forName("com.mysql.jdbc.Driver").newInstance();
  		String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
  		this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
	}
	
	public Connection getConnection() {
  		return this.connection;
	}
}

