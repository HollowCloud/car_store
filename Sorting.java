package databaseconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Sorting implements SortAll{
    Scanner scanner = new Scanner(System.in);
    Scanner str = new Scanner(System.in);
    ConnectDB dbc = new ConnectDB();

    @Override
    public void SortByPrice() {
        Connection c = null;
        Statement st = null;
        MyApplication m = new MyApplication();
        c = dbc.get_connection();
        
        try {                       

                    //Here is the way to execute the query. It will execute price in ascending order...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT * FROM Car ORDER BY price ASC");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                int price = rs.getInt("price");
		      		System.out.println("Name: " + username);
                                System.out.println("The price of it is: " + price);     
                                System.out.println("");
                        }
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        
    }

    @Override
    public void SortByDate() {
        Connection c = null;
        Statement st = null;
        MyApplication m = new MyApplication();
        c = dbc.get_connection();    
    
        try {                       

                    //Here is the way to execute the query. It will execute date in ascending order...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT * FROM Car ORDER BY published_year ASC");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                int price = rs.getInt("published_year");
		      		
                                System.out.println("Name: " + username);
                                System.out.println("The date is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
    
    }
    
    //Fixed range of the price from 10000-70000
    public void Region(){
        
        Connection c = null;
        Statement st = null;
        MyApplication m = new MyApplication();
        c = dbc.get_connection();    
    
        try {                       

                    //Here is the way to execute the query. It will execute price with defined range in ascending order...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT car_name, price FROM Car WHERE price > 10000 AND price < 70000 ORDER BY price ASC");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                int price = rs.getInt("published_year");
		      		
                                System.out.println("Name: " + username);
                                System.out.println("The price is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    //Fixed range of price from 70000-200000
    public void Region_1(){
        
        Connection c = null;
        Statement st = null;
        MyApplication m = new MyApplication();
        c = dbc.get_connection();    
    
        try {                       

                    //Here is the way to execute the query. It will execute price with defined range in ascending order...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT car_name, price FROM Car WHERE price > 10000 AND price < 70000 ORDER BY price ASC");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                int price = rs.getInt("published_year");
		      		
                                System.out.println("Name: " + username);
                                System.out.println("The price is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    //This condition is for the date, if user wants to see the result with the defined range of year from 1950-2000
    public void Range(){
        
        Connection c = null;
        Statement st = null;
        MyApplication m = new MyApplication();
        c = dbc.get_connection();    
    
        try {                       

                    //Here is the way to execute the query. It will execute date with defined range in ascending order...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT car_name, published_year FROM Car WHERE published_year > 1950 AND published_year < 2000 ORDER BY published_year ASC");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                int price = rs.getInt("published_year");
		      		
                                System.out.println("Name: " + username);
                                System.out.println("The date is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    //This condition is for the date, if user wants to see the result with the defined range of year from 2000-2050
    public void Range_1(){
        
        Connection c = null;
        Statement st = null;
        MyApplication m = new MyApplication();
        c = dbc.get_connection();    
    
        try {                       

                    //Here is the way to execute the query. It will execute date with defined range in ascending order...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT car_name, published_year FROM Car WHERE published_year > 2000 AND published_year < 2050 ORDER BY published_year ASC");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                int price = rs.getInt("published_year");
		      		
                                System.out.println("Name: " + username);
                                System.out.println("The price is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
}
