package com.necc.net.IA.database;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuestionSource 
{
	


		
		private static Connection connection = null;  // variable is static to prevent multiple instaciations
		private static boolean hasData = false;  // static prevent multiple instaciations
		
		/**
		 * @return information related to the specified customer
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 */
		public ResultSet getUserInfo() throws ClassNotFoundException, SQLException
		{	
			if( connection == null)
			{
				getConnection();
			}	
			Statement state = connection.createStatement();
			 ResultSet res = state.executeQuery("SELECT date, description, amount, valance FROM custumer_info");
			 return res;
		}

		/**
		 * @throws SQLException 
		 * @throws ClassNotFoundException 
		 * @param return resultset users
		 */
		public ResultSet getUsersTable(int id) throws ClassNotFoundException, SQLException
		{
			if( connection == null)
			{
				getConnection();
			}
			
			Statement state = connection.createStatement();
			 ResultSet res = state.executeQuery("SELECT * FROM USERS WHERE rowid =" + id );
			 
			 return res;
			
		}
		
		/**
		 * @param 
		 * @return true if user is in database
		 * @throws SQLException 
		 * @throws ClassNotFoundException 
		 */
		public boolean hasUser(String userid, String password) throws SQLException, ClassNotFoundException{
			
			if( connection == null)
			{
				getConnection();
			}
			String query = "SELECT * FROM USERS WHERE USERID = ? AND PASSWORD = ?";
			
			PreparedStatement preStatement = connection.prepareStatement(query);
			preStatement.setString(1, userid );
			preStatement.setString( 2, password );
			ResultSet res = preStatement.executeQuery();
			if(res.next() )
			{
				return true;
			}
		

			return false;
		}
		/**
		 * @param set the  drivers
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 */
		private void getConnection() throws ClassNotFoundException, SQLException {
			  
			  Class.forName("org.sqlite.JDBC"); // statement no needed anymore in java 8, java loads the driver by itself now
			  // database path, if it's new database, it will be created in the project folder
			  connection = DriverManager.getConnection("jdbc:sqlite:SQLiteBankData.sqlite");
			  System.out.println("connection open successfully");  
			  initialize();
		 }

		/**
		 * @throws ClassNotFoundException 
		 * @param creates data base and add data if data is not  found
		 */
		 private void initialize() throws SQLException, ClassNotFoundException 
		 {
			 if( !hasData ) {
				 hasData = true;
				 // check for database table
				 Statement state = connection.createStatement();
				 
				 ResultSet resulSet = state.executeQuery("SELECT NAME FROM sqlite_master WHERE type='table' AND name='custumer_info'");
				 if( !resulSet.next()) 
				 { 
					
					 createUserTable();  // create user table
					
					 testUser();  
					 
					 testData();  	
				 }	 
			 } 
		 }
		 /**
		  * @param method adds data to table for testing purposes. 
		  */
		 private void testData() throws SQLException
		 {
			 System.out.println("Building table with test data.");
			 // need to build the table
			  Statement statement = connection.createStatement();
			  
			  statement.executeUpdate("CREATE TABLE custumer_info( ID INTEGER PRIMARY KEY  NOT NULL," +" DATE VARCHAR( 60),"
					  +"DESCRIPTION VARCHAR (60)," +"AMOUNT INTEGER," + "VALANCE INTEGER,"  + " ACOUNT_TYPE VARCHAR (60) );");
			  
			  /*
			   * data use for testing purposes 
			   */
			  statement = connection.createStatement();
		      String sql = "INSERT INTO custumer_info ( ID, DATE , DESCRIPTION, AMOUNT, VALANCE,  ACOUNT_TYPE  ) " +
		                   "VALUES ( 1, 'Paul', 'desc', 20, 20000.00,  'savings' );"; 
		      statement.executeUpdate(sql);
		      sql = "INSERT INTO custumer_info ( ID, DATE , DESCRIPTION, AMOUNT, VALANCE,  ACOUNT_TYPE  ) " +
	                   "VALUES (  2, 'Paul', 'desc', 20, 20000.00,  'savings');"; 
	      statement.executeUpdate(sql);
		 }
		 
		 
		 
		 /**
		  * @param insert data into the given table.
		 * @throws SQLException 
		  */
		 public void insertData(String idField, String passwordField_1,  String fNameField, String lNameField, 
				 String MIField, String emailField, int savingRadio,
				 int checkingRadio, int creditRadio  ) throws SQLException
		 {
			 												
			 String query = "INSERT INTO USERS (USERID, PASSWORD, EMAIL, FirstName, "
			 		+ "LastName, MI, Gender) VALUES(?,?,?,?,?,?,?, ?,?)";
			 PreparedStatement  preState = connection.prepareStatement(query);
			 
			 preState.setString( 1, idField);
			 preState.setString( 2, passwordField_1 );
			 preState.setString( 3, emailField );
			 preState.setString( 4, fNameField );
			 preState.setString( 5, lNameField );
			 preState.setString( 6, MIField );
			 preState.setInt( 7, savingRadio );
			 preState.setInt( 8, checkingRadio );
			 preState.setInt( 9, creditRadio);

			 preState.execute();	
			 preState.close();
	     	
		 }
		 /**
		  * 
		  * @return
		 * @throws SQLException 
		  
		 public ResulgetUserInfotSet insertCostumerInfo(int ID, String DATE , String DESCRIPTION, int AMOUNT, 
				 int VALANCE, String ACOUNT_TYPE ) throws SQLException
		 {
			 String query = "SELECT * FROM custumer_info WHERE rowid =?  ";
			 PreparedStatement preState = connection.prepareStatement(query);
			 preState.setInt(1, ID);
			 preState.setString( 2, DATE);
			 preState.setString( 3, DESCRIPTION);
			 preState.setInt( 4, AMOUNT);
			 preState.setInt( 5, VALANCE);
			 preState.setString( 6, ACOUNT_TYPE);
			 
			 return preState.executeQuery();
			 
		 }
		 */
		 /**
		  * @param creates a table for holding use userid, password, and the customer IDs(to be related on customer infor_table)
		  * @throws SQLException
		 * @throws ClassNotFoundException 
		  */
		private void createUserTable() throws SQLException, ClassNotFoundException
		{
			
			Statement statement = connection.createStatement();
			statement.executeUpdate("CREATE TABLE USERS ( USERID VARCHAR(60)," + " PASSWORD VARCHAR(60)," 
			 +"EMAIL VARCHAR(60),"+ " FirstName VARCHAR(60)," +" LastName VARCHAR(60)," +" MI VARCHAR(60)," +
			" Gender VARCHAR(60)," +" saving INTEGER," +" checking INTEGER," +" credit INTEGER  );");
			System.out.println("table users created");
		}
		
		/**
		 * @param creates a two test users Student and professor
		 * @throws SQLException 
		 */
		private void testUser() throws SQLException
		{
			Statement statement = connection.createStatement();
			System.out.println("test inside  testUser");
		    String sql = "INSERT INTO USERS (  USERID , PASSWORD, EMAIL, FirstName, LastName, MI, Gender, saving,  checking ,  credit) " +
	                  "VALUES (  'student', 'student', 'student', 'student', 'student', 'student', 'student', 1, 2, 3 );"; 
		    statement.executeUpdate(sql);
		     sql = "INSERT INTO USERS (  USERID , PASSWORD, EMAIL, FirstName, LastName, MI, Gender, saving,  checking ,  credit ) " +
	                "VALUES (  'professor', 'professor', 'student', 'student', 'student', 'student', 'student', 4, 5, 6 );"; 
		    statement.executeUpdate(sql);
		}
		
}
