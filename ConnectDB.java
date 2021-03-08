package databaseconnection;

import java.sql.*;

public class ConnectDB {
	
	//This is the method which I am calling with Connection. The whole class is done to connect with database...
	public Connection get_connection() {
		Connection connection = null;
		String host = "localhost";
		String port = "5432";
		String db_name = "Test";
		String username = "postgres";
		String password = "Tamerlan2028";
		
		   
		   try {
			  Class.forName("org.postgresql.Driver");
			   
			// Establish the connection
			  //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Tamerlan2028"); 
                            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name, username, password);
			   
			  if(connection!=null) {
				  System.out.println("");

			  } else {
				  System.out.println("Database failed to open \n");
			  }
			   	   
		   }catch(Exception e) {
			   System.out.println(e);
		   }
		return connection;	
	}
        
        

}