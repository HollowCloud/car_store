package databaseconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.SQLException;

public class Main {
    private static Connection connection;
    private static String url = "jdbc:postgresql://localhost:5432/Test";
    private static String user = "postgres";
    private static String password = "Tamerlan2028";
    private static PreparedStatement preparedStatement;
    
    Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        MyApplication m = new MyApplication();
        m.start();//Here it all starts, it goes to MyApplication class where mini menu is situated... 
    }
    
    //This is for the first option 
    public void Option_1(){
        
        Car c = new Car();//Object of Car class
        c.AllCars();//It goes to the method AllCars in Car class
        
    }
    
    //This is for second option...
    public void Option_2(){
        SettingNewCar s = new SettingNewCar();
        MyApplication m = new MyApplication();//Object of MyApplication...
        try{
            m.BuyCar();//Where message about your order will appear...
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
    }
    
    public void SRC(){
        
        Cust_Run cr = new Cust_Run();
        MyApplication m = new MyApplication();
        try{
            cr.CustomerSearch();
            m.Search(cr.cust.getF());
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
    }
    
    
    //This is option number 4...
    public void Option_4(){
        MyApplication m = new MyApplication();//All is the same except method call...
        Cust_Run cr = new Cust_Run();
        try{
            cr.set_all_Data();//This is method of Cust_Run, where I set all values to create new Customer...
            //InsertIn method which dwells in MyApplication class, there exist prepared statements(INSERT). In the parameters I am calling getters in Customer class... 
            m.Insertin(cr.cust.get_id(), cr.cust.get_f_Name(), cr.cust.get_l_Name(), cr.cust.get_age(), cr.cust.get_town(), cr.cust.get_address(), cr.cust.get_telephoneNumber());
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void Option_5(){

        MyApplication m = new MyApplication();
        SettingNewCar s = new SettingNewCar();//This is object of class SettingNewCar, it is in the Car class...
        try{     
           s.SetUp();//This method for creating a new Car...
           //As I mentioned class Car has a getters and setters, and it will go InsertCar method, it is in the MyApplication class... 
           m.InsertCar(s.car.getId(), s.car.getName(), s.car.getBrand(), s.car.getYear(), s.car.getPrice(), s.car.getFuelSource(), s.car.getWeight(), s.car.getId2());       
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
    }
    
    //This is option number 6...
    public void Option_6() {

        SettingNewCar s = new SettingNewCar();//Everything is the same as in the Option_5, but it we are calling another method for another purpose...
        MyApplication m = new MyApplication();
        try{     
           s.CarDel();//This method is in the SettingNewCar class...
           //In DeleteCar, there is query to delete all information...
           m.DeleteCar(s.car.getDel());       
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
    }
    
    //This is option 7...
    public void Option_7(){
        
        MyApplication m = new MyApplication();
        Cust_Run cr = new Cust_Run();
        try{
            cr.Update_id();//Here we are able to update car_id only in the Customer table...
            m.Update(cr.cust.getIdUpdate());//This method is the realization of the query above... 
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
    }
    
    //Option number...
    public void Option_8(){

        MyApplication m = new MyApplication();
        Cust_Run c = new Cust_Run();
        try{     
           c.CustomerDel();//This method is for deleting all information about exact customer...
           //MyApplication holds method called DeleteCus, it has a query(DELETE)...
           m.DeleteCus(c.cust.getDel());       
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
    }
    
}
