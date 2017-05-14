package com.necc.net.IA.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AnswerSource 
{
		
		private static Connection connection = null;  // variable is static to prevent multiple instaciations
		private static boolean hasData = false;  // checks if a datebase exit on the  current directory
		
		
		/**
		 * @return information related to the specified customer
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 */
		public ResultSet desisplayQuestions() 
		{	
			 ResultSet res = null;
			try {
				this.getConnection();
			if( connection == null)
			{
				
				
				
			}	
			Statement state = connection.createStatement();
			  res = state.executeQuery("SELECT * FROM gameAnswer");
			 
			} catch (Exception e ) {
				System.out.println("failed to get connection method gameAnswer");
				e.printStackTrace();
			}
			 return res;
		}
		
		
		
		/**
		 * 
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 */
		private void getConnection() throws ClassNotFoundException, SQLException {
			  
			  Class.forName("org.sqlite.JDBC"); // statement no needed anymore in java 8, java loads the driver by itself now
			  // database path, if it's new database, it will be created in the project folder
			  connection = DriverManager.getConnection("jdbc:sqlite:appDATA.sqlite");
			  System.out.println("connection open successfully");  
			  this.initialize();
		 }
		
		
		private void initialize() throws SQLException, ClassNotFoundException 
		 {
			 if( !hasData ) {
				 hasData = true;
				 // check for database table
				 Statement state = connection.createStatement();
				 
				 ResultSet resulSet = state.executeQuery("SELECT NAME FROM sqlite_master WHERE type='table' AND name='gameAnswer'");
				 if( !resulSet.next()) // check if the database has data
				 { 
					 
					
					 this.createAnswerTable();  // creates new table
								
					 this.answerOnFile();  	
				 }	 
			 } 
		 }
		
		/**
		 * 
		 */
		 private void createAnswerTable()
		 {
			 System.out.println("Creating new table");
			 try {
				 Statement statement = connection.createStatement();
				statement.executeUpdate("CREATE TABLE gameAnswer( guessCorrectly INTEGER, ANSWER VARCHAR(100) );");
			} catch (SQLException e) {
				System.out.print("fail to create tabel question");
				e.printStackTrace();
			}
		 }
		
		 
		 private void answerOnFile() throws SQLException
		 {
			  
			  Statement statement = connection.createStatement();
		      String sql = "INSERT INTO gameAnswer ( rowid, guessCorrectly , ANSWER ) " +
		                   "VALUES ( 1, 20, 'Something' );"; 
		      statement.executeUpdate(sql);
		     
		 }
		
		
		 public void addAnswer(long rowid, String answer, int guessCorrectly ) throws SQLException, ClassNotFoundException
		 {
			 if( connection == null)
				{
					this.getConnection();
				}	
			 												
			 String query = "INSERT INTO gameAnswer (rowid, guessCorrectly, ANSWER) VALUES(?,?,?)";
			 PreparedStatement  preState = connection.prepareStatement(query);
			 
			 preState.setLong( 1, rowid);
			 preState.setInt( 2, guessCorrectly );
			 preState.setString( 3, answer );
			
			 preState.execute();	
			 preState.close();
	     	
		 }
		 
}
