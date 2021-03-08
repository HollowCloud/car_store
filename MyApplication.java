package databaseconnection;

import databaseconnection.ConnectDB;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    Scanner scanner = new Scanner(System.in);
    Scanner str = new Scanner(System.in);
    ConnectDB dbc = new ConnectDB();
    Main main = new Main();
    
    public void start() {
        Statement st1 = null;
        Connection c1 = null;
        Connection c = null;
        Statement st = null;
        MyApplication m = new MyApplication();
        c = dbc.get_connection();
        
        //Here is the Menu...
        while (true) {
            System.out.println();
            System.out.println("Welcome to the Car Store");
            System.out.println("Select option:");
            System.out.println("1. View all Cars");
            System.out.println("2. Purchase Car/Cars");
            System.out.println("3. Sort all the Cars");
            System.out.println("4. Add personal information");
            System.out.println("5. Add a Car");
            System.out.println("6. Remove Car");
            System.out.println("7. Update personal Information");
            System.out.println("8. Delete personal Information");
            System.out.println("9. Exit from Menu");
            System.out.println("");
            try {
                
                
                System.out.println("Enter option: ");
                int option = scanner.nextInt();
                //Option 1 represents list of all products...
                if (option == 1) {
                    main.Option_1();
                }    else if(option == 2){
                    
                    System.out.println("Have you ever been in this store?(Yes/No)");
                    String t = str.nextLine();
                    if("Yes".equals(t)){               
                       main.Option_2();
                    }else if("No".equals(t)){
                        main.Option_4();//If it is "No", it will bring you to the option number 4(Add personal information)[/_\]
                    }
                    
                }else if(option == 3){
                    Sorting sort = new Sorting();//Object of Sorting class...
                    System.out.println("What you want to sort?(Date/Price)");
                    String s = str.nextLine();
                    if("Date".equals(s)){//If you have chosen date, it will sort them by date in Ascending order...
                        sort.SortByDate();//Calling SortByDate method...
                        System.out.println("Do you want to see date with defined range?");//This was shaped in order to illustrate date in defined range...
                        String decision = str.nextLine();
                            if("Yes".equals(decision)){
                                //Here are the range...
                                System.out.println("Press 1 to see from 1950-2000");
                                System.out.println("");
                                System.out.println("Press 2 to see from 2000-2050");
                                int t = scanner.nextInt();
                                if(t == 1){
                                    sort.Range();
                                }else if(t == 2){
                                    sort.Range_1();
                                }
                            } else if("No".equals(decision)){//If you do not want to, menu starts again...
                                MyApplication n = new MyApplication();
                                n.start();
                            }
                    }else if("Price".equals(s)){
                        //Everything is the same, but here are conditions only for price...
                        sort.SortByPrice();
                        System.out.println("Do you want to see date with defined range?");
                        String decision = str.nextLine();
                            if("Yes".equals(decision)){
                                System.out.println("Press 1 to see from 10000-70000");
                                System.out.println("");
                                System.out.println("Press 2 to see from 70000-200000");
                                int t = scanner.nextInt();
                                if(t == 1){
                                    sort.Region();
                                }else if(t == 2){
                                    sort.Region_1();
                                }
                            } else if("No".equals(decision)){
                                MyApplication n = new MyApplication();
                                n.start();
                            }
                    }else{
                        //This is if you wrote something not what I expected...
                        System.out.println("Sorry I guess you have written something different...");
                        MyApplication n = new MyApplication();
                        n.start();
                    }
                    
                } else if(option == 4){
                    //It will go to Option_4 method in the Main class...
                   main.Option_4();     
                } else if(option == 5){//For the rest of the options we are doing the same(just calling their own methods in the Main class...)
                        main.Option_5();
               } else if(option == 6){
                   main.Option_6();
               }else if(option == 7){
                   main.Option_7();
               }else if(option == 8){
                   main.Option_8();
               }else {//Just to stope and exit from compilation...
                        System.out.println("I guess you have typed something wrong...");
                        break;
               }
                
                
          }
           catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("------------------------------");

        }
    }
    
    
    
    public void Insertin(int id, String name, String name1, int age, String town, String address, String telephone) throws SQLException, ClassNotFoundException{
        //Here the method to add customer. For this we are using Prepared Staements...
        String query = "INSERT INTO Customer(customer_id, customer_f_name, customer_l_name, age, town, address, customer_phone) VALUES( ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = dbc.get_connection().prepareStatement(query);
        
        //Method will gain values from parameters and restore it in the database...
        pst.setInt(1, id);
        pst.setString(2, name);
        pst.setString(3, name1);
        pst.setInt(4, age);
        pst.setString(5, town);
        pst.setString(6, address);
        pst.setString(7, telephone);

        
        pst.executeUpdate();//Executing the query...
    }
    
    public void BuyCar() throws SQLException, ClassNotFoundException{
        Connection c = null;
        Statement st = null;
        MyApplication m = new MyApplication();
        c = dbc.get_connection();    
        
        System.out.println("Please enter id of the Car: ");
        int id = scanner.nextInt();
        if(id == 1){
            try {                       

                    //Here is the way to execute the query. It will execute car with id number that is defined...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT car_name, car_brand, price FROM Car WHERE car_id = 1");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                String brand = rs.getString("car_brand");
                                int price = rs.getInt("price");
		      		
                                System.out.println("You have bought " + username + " " + brand + ".");
                                System.out.println("The price is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        }else if(id == 2){
            try {                       

                    //Here is the way to execute the query. It will execute car with id number that is defined...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT car_name, car_brand, price FROM Car WHERE car_id = 2");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                String brand = rs.getString("car_brand");
                                int price = rs.getInt("price");
		      		
                                System.out.println("You have bought " + username + " " + brand + ".");
                                System.out.println("The price is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        } else if(id == 3){
            try {                       

                    //Here is the way to execute the query. It will execute car with id number that is defined...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT car_name, car_brand, price FROM Car WHERE car_id = 3");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                String brand = rs.getString("car_brand");
                                int price = rs.getInt("price");
		      		
                                System.out.println("You have bought " + username + " " + brand + ".");
                                System.out.println("The price is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        }else if(id == 4){
            try {                       

                    //Here is the way to execute the query. It will execute car with id number that is defined...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT car_name, car_brand, price FROM Car WHERE car_id = 4");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                String brand = rs.getString("car_brand");
                                int price = rs.getInt("price");
		      		
                                System.out.println("You have bought " + username + " " + brand + ".");
                                System.out.println("The price is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        }else if(id == 5){
            try {                       

                    //Here is the way to execute the query. It will execute car with id number that is defined...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT car_name, car_brand, price FROM Car WHERE car_id = 5");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                String brand = rs.getString("car_brand");
                                int price = rs.getInt("price");
		      		
                                System.out.println("You have bought " + username + " " + brand + ".");
                                System.out.println("The price is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        }else if(id == 6){
            try {                       

                    //Here is the way to execute the query. It will execute car with id number that is defined...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT car_name, car_brand, price FROM Car WHERE car_id = 6");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                String brand = rs.getString("car_brand");
                                int price = rs.getInt("price");
		      		
                                System.out.println("You have bought " + username + " " + brand + ".");
                                System.out.println("The price is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        }else if(id == 7){
            try {                       

                    //Here is the way to execute the query. It will execute car with id number that is defined...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT car_name, car_brand, price FROM Car WHERE car_id = 7");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                String brand = rs.getString("car_brand");
                                int price = rs.getInt("price");
		      		
                                System.out.println("You have bought " + username + " " + brand + ".");
                                System.out.println("The price is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        }else if(id == 8){
            try {                       

                    //Here is the way to execute the query. It will execute car with id number that is defined...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT car_name, car_brand, price FROM Car WHERE car_id = 8");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                String brand = rs.getString("car_brand");
                                int price = rs.getInt("price");
		      		
                                System.out.println("You have bought " + username + " " + brand + ".");
                                System.out.println("The price is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        }else if(id == 9){
            try {                       

                    //Here is the way to execute the query. It will execute car with id number that is defined...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT car_name, car_brand, price FROM Car WHERE car_id = 9");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                String brand = rs.getString("car_brand");
                                int price = rs.getInt("price");
		      		
                                System.out.println("You have bought " + username + " " + brand + ".");
                                System.out.println("The price is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        }else if(id == 10){
            try {                       

                    //Here is the way to execute the query. It will execute car with id number that is defined...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT car_name, car_brand, price FROM Car WHERE car_id = 10");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                String brand = rs.getString("car_brand");
                                int price = rs.getInt("price");
		      		
                                System.out.println("You have bought " + username + " " + brand + ".");
                                System.out.println("The price is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        }else if(id == 11){
            try {                       

                    //Here is the way to execute the query. It will execute car with id number that is defined...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT car_name, car_brand, price FROM Car WHERE car_id = 11");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                String brand = rs.getString("car_brand");
                                int price = rs.getInt("price");
		      		
                                System.out.println("You have bought " + username + " " + brand + ".");
                                System.out.println("The price is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        }else if(id == 12){
            try {                       

                    //Here is the way to execute the query. It will execute car with id number that is defined...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT car_name, car_brand, price FROM Car WHERE car_id = 12");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                String brand = rs.getString("car_brand");
                                int price = rs.getInt("price");
		      		
                                System.out.println("You have bought " + username + " " + brand + ".");
                                System.out.println("The price is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        }else if(id == 13){
        try {                       

                    //Here is the way to execute the query. It will execute car with id number that is defined...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT car_name, car_brand, price FROM Car WHERE car_id = 13");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                String brand = rs.getString("car_brand");
                                int price = rs.getInt("price");
		      		
                                System.out.println("You have bought " + username + " " + brand + ".");
                                System.out.println("The price is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        }else if(id == 14){
            try {                       

                    //Here is the way to execute the query. It will execute car with id number that is defined...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT car_name, car_brand, price FROM Car WHERE car_id = 14");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                String brand = rs.getString("car_brand");
                                int price = rs.getInt("price");
		      		
                                System.out.println("You have bought " + username + " " + brand + ".");
                                System.out.println("The price is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        }else if(id == 15){
            try {                       

                    //Here is the way to execute the query. It will execute car with id number that is defined...
                    st = c.createStatement();      
                    ResultSet rs = st.executeQuery("SELECT car_name, car_brand, price FROM Car WHERE car_id = 15");
			  
			  while (rs.next()) { // Processing the result
		       		String  username = rs.getString("car_name");
                                String brand = rs.getString("car_brand");
                                int price = rs.getInt("price");
		      		
                                System.out.println("You have bought " + username + " " + brand + ".");
                                System.out.println("The price is: " + price);     
                                System.out.println("");
                                
                        }
                          
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        }


        
    }
    
    public void InsertCar(int id, String name, String name1, int year, int price, String fuel, int weight, int id2) throws SQLException, ClassNotFoundException{
        
        //This method is working as same as InsertIn method above, but it adds new Car...
        String query = "INSERT INTO Car(car_id, car_name, car_brand, published_year, price, fuel_source, weight, customer_id) VALUES( ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = dbc.get_connection().prepareStatement(query);
        
        pst.setInt(1, id);
        pst.setString(2, name);
        pst.setString(3, name1);
        pst.setInt(4, year);
        pst.setInt(5, price);
        pst.setString(6, fuel);
        pst.setInt(7, weight);
        pst.setInt(8, id2);
        
        pst.executeUpdate();
    }
    
    
    public void Search(String n1) throws SQLException, ClassNotFoundException{ 
        //Method was constructed for finding customer, if he has already visited us...
        String query = "SELECT customer_id, customer_l_name FROM Customer WHERE customer_f_name IN(?)";//That is the query for that...
        PreparedStatement pst = dbc.get_connection().prepareStatement(query);
        
        pst.setString(1, n1);
        
        pst.executeQuery();
       
        
    }
    
    public void Update(int id) throws SQLException, ClassNotFoundException{
        //Here you will be able to update car_id, if it is not prohibited(Primary Key, relationship between Customer and Car...)
        String query = "UPDATE Customer SET car_id = ? WHERE customer_id = ?";
        PreparedStatement pst = dbc.get_connection().prepareStatement(query);
        
        pst.setInt(1, id);
        pst.setInt(2, id);

        
        pst.executeUpdate();
        
    }
    
    public void DeleteCar(int id) throws SQLException, ClassNotFoundException{
        //This is query is for deleting all the information about one car(it all depends on what id you have written...)
        String sql = "DELETE FROM Car WHERE car_id = ?";
        PreparedStatement pst = dbc.get_connection().prepareStatement(sql);
        
        pst.setInt(1, id);
        pst.executeUpdate();
        
    }
    
    public void DeleteCus(int i) throws SQLException, ClassNotFoundException{
        //This is the same method as DeleteCar, but it deletes information about Customer...
        String sql = "DELETE FROM Customer WHERE customer_id = ?";
        PreparedStatement pst = dbc.get_connection().prepareStatement(sql);
        
        pst.setInt(1, i);
        pst.executeUpdate();
        
    }
   
}