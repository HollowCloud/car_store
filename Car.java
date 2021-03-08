package databaseconnection;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Car {
    private int id;
    private int id2;
    private String car_name;
    private String car_brand;
    private int year;
    private int price;
    private String fuel_source;
    private int weight;
    private int del;
    private int buy;
    
    Scanner scanner = new Scanner(System.in);
    Scanner str = new Scanner(System.in);
    ConnectDB dbc = new ConnectDB();
    
    //Setters adding a new car/cars
    public void setId(int i){
        this.id = i;
    }
    
    public void setId2(int u){
        this.id2 = u;
    }
    
    public void setName(String m){
        this.car_name = m;
    }
    
    public void setBrand(String b){
        this.car_brand = b;
    }
    
    public void setYear(int y){
        this.year = y;
    }
    
    public void setPrice(int p){
        this.price = p;
    }
    
    public void setFuel(String f){
        this.fuel_source = f;
    }
    
    public void setWeight(int i){
        this.weight = i;
    }
    
    //Getters for the new car/cars(the information that will be saved in DB)
    public int getId(){
        return id;
    }
    
    public int getId2(){
        return id2;
    }
    
    public String getName(){
        return car_name;
    }
    
    public String getBrand(){
        return car_brand;
    }
    
    public int getYear(){
        return year;
    }
    
    public int getPrice(){
        return price;
    }
    
    public String getFuelSource(){
        return fuel_source;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public void setDel(int d){
        this.del = d;
    }
    
    public int getDel(){
        return del;
    }
    
    public void setB(int d){
        this.buy = d;
    }
    
    public int getB(){
        return buy;
    }
    
    
    public void AllCars(){
        Connection c = null;
        Statement st = null;
        c = dbc.get_connection();
        
        try{
            
            st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT car_brand, price FROM Car");
            
            while(rs.next()){
                String name = rs.getString("car_brand");
                int price = rs.getInt("price");
                
                System.out.println("We have " + name + ", it costs " + price);
                System.out.println("");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}

//We will call this class when we press option number 5
    class SettingNewCar extends Main{
            
        Car car = new Car();
        Scanner scanner = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        
        public void SetUp(){
        
        //Here user will be able to add himself/herself...
        System.out.println("Enter id of the Car: ");
        int id = scanner.nextInt();
        car.setId(id);
        System.out.println("");
        
        System.out.println("Please enter model of the car: ");
        String name = str.nextLine();
        car.setName(name);
        System.out.println("");
        
        System.out.println("Please enter brand of the car: ");
        String name1 = str.nextLine();
        car.setBrand(name1);
        System.out.println("");
        
        System.out.println("Enter the published year: ");
        int year = scanner.nextInt();
        car.setYear(year);
        System.out.println("");
        
        System.out.println("Enter the current price: ");
        int price = scanner.nextInt();
        car.setPrice(price);
        System.out.println("");
        
        System.out.println("Enter in what type of fuel it uses: ");
        String fuel = str.nextLine();
        car.setFuel(fuel);
        System.out.println("");
        
        System.out.println("Enter weight of this car: ");
        int weight = scanner.nextInt();
        car.setWeight(weight);
        System.out.println("");
        
        System.out.println("Enter your id: ");
        int id2 = scanner.nextInt();
        car.setId2(id2);
        System.out.println("");
            
        }
        
        //This method is called when we want to delete car(we have to know what car it is(car_id))
        public void CarDel(){
        System.out.println("Enter the id of the Car you want to Delete: ");
        int id = scanner.nextInt();
        car.setDel(id);
        
    }
        
        public void Buy(){
            
            System.out.println("Enter the id of the Car you want to Buy:");
            int id = scanner.nextInt();
            car.setB(id);
            
        }
        
}
