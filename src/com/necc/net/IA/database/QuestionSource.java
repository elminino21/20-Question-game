package com.necc.net.IA.database;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * handles the output and input of questions
 * @author elminino
 *
 */
public class QuestionSource 
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
			  res = state.executeQuery("SELECT * FROM gameQuestion");
			 
			} catch (Exception e ) {
				System.out.println("failed to get connection method gameQuestion");
				e.printStackTrace();
			}
			 return res;
		}
		
		/**
		 * returns the specified row
		 */
		public ResultSet setRow(long rowid)
		{
			ResultSet res = null;
			try {
				this.getConnection();
			if( connection == null)
			{
				
				
				
			}	
			Statement state = connection.createStatement();
			  res = state.executeQuery("SELECT gameQuestion FROM gameQuestion WHERE rowid ="+ rowid);
			  
			 
			} catch (Exception e ) {
				System.out.println("failed to get connection method gameQuestion");
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
				 
				 ResultSet resulSet = state.executeQuery("SELECT NAME FROM sqlite_master WHERE type='table' AND name='gameQuestion'");
				 if( !resulSet.next()) // check if the database has data
				 { 
					 
					
					 this.createQuestionTable();  // creates new table
								
					 this.questionOnFile();  	
				 }	 
			 } 
		 }
		
		/**
		 * 
		 */
		 private void createQuestionTable()
		 {
			 System.out.println("Creating new table");
			 try {
				 Statement statement = connection.createStatement();
				statement.executeUpdate("CREATE TABLE gameQuestion( randomlyGeneraded INTEGER, QUESTION VARCHAR(100) );");
			} catch (SQLException e) {
				System.out.print("fail to create tabel question");
				e.printStackTrace();
			}
		 }
		
		 
		 private void questionOnFile() throws SQLException
		 {
			  
			  Statement statement = connection.createStatement();
		      String sql = "INSERT INTO gameQuestion ( rowid, randomlyGeneraded , QUESTION ) " +
		                   "VALUES ( 1, 0, 'Is is alive?' );"; 
		      statement.executeUpdate(sql);
		     
		 }
		
		
		 public void addQuestion(long rowid, String question, int randonlyGenerated ) throws SQLException, ClassNotFoundException
		 {
			 if( connection == null)
				{
					this.getConnection();
				}	
			 												
			 String query = "INSERT INTO gameQuestion (rowid, randonlyGenerated, QUESTION) VALUES(?,?,?)";
			 PreparedStatement  preState = connection.prepareStatement(query);
			 
			 preState.setLong( 1, rowid);
			 preState.setInt( 2, randonlyGenerated );
			 preState.setString( 3, question );
			
			 preState.execute();	
			 preState.close();
	     	
		 }
		 
		 
		
		
		
		
}
