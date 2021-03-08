package databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Customer {
    
    private int id; 
    private String name; 
    private String name1;
    private int age;
    private String town;
    private String address; 
    private String telephone;
    private int del;
    private String first_n;
    private int id_up;
    
    //Getter and Setter for customer_id
    public int get_id(){
        return id;
    }
    
    public void set_id(int i){
        this.id = i;
    }
    
    //Getter and Setter for customer_f_id
    public String get_f_Name(){
        return name;
    }
    
    public void set_f_name(String n){
        this.name = n;
    }
    
    //Getter and Setter for customer_l_id
    public String get_l_Name(){
        return name1;
    }
    
    public void set_l_name(String n1){
        this.name1 = n1;
    }
    
    //Getter and Setter for age
    public int get_age(){
        return age;
    }
    
    public void set_age(int s){
        this.age = s;
    }
    
    //Getter and Setter for town
    public String get_town(){
        return town;
    }
    
    public void set_town(String t){
        this.town = t;
    }
    
    //Getter and Setter for address
    public String get_address(){
        return address;
    }
    
    public void set_address(String a){
        this.address = a;
    }
    
    //Getter and Setter for telephone
    public String get_telephoneNumber(){
        return telephone;
    }
    
    public void set_telephoneNumber(String tel){
        this.telephone = tel;
    }
    
    //This is to delete fields in the Customer table
    public void setDel(int d){
        this.del = d;
    }
    
    public int getDel(){
        return del;
    }
    
    //
    public void setF(String f){
        this.first_n = f;
    }
    
    public String getF(){
        return first_n;
    }
    
    //Here is the update for car_id in Customer Table
    public void setIdUpdate(int u){
        this.id_up = u;
    }
    
    public int getIdUpdate(){
        return id_up;
    }
 
}

class Cust_Run extends Main{

    Customer cust = new Customer();
    Scanner scanner = new Scanner(System.in);
    Scanner str = new Scanner(System.in);
    
    public void set_all_Data(){
        //Here user will be able to add himself/herself...
        System.out.println("Enter your id: ");
        int id = scanner.nextInt();
        cust.set_id(id);  
        cust.get_id();
        System.out.println("");
        
        System.out.println("Please enter your first name: ");
        String name = str.nextLine();
        cust.set_f_name(name);
        System.out.println("");
        
        System.out.println("Please enter your last name: ");
        String name1 = str.nextLine();
        cust.set_l_name(name1);
        System.out.println("");
        
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        cust.set_age(age);
        System.out.println("");
        
        System.out.println("Enter the city that you are living at the moment: ");
        String town = str.nextLine();
        cust.set_town(town);
        System.out.println("");
        
        System.out.println("Enter your address: ");
        String address = str.nextLine();
        cust.set_address(address);
        System.out.println("");
        
        System.out.println("Your telephone number: ");
        String telephone = str.nextLine();
        cust.set_telephoneNumber(telephone);
        System.out.println("");
        
    }
    //Deleting the customer...
    public void CustomerDel(){
        System.out.println("Enter the id of the Customer you want to Delete: ");
        int id = scanner.nextInt();
        cust.setDel(id);
        
    }
    
    public void CustomerSearch(){
        
        System.out.println("Enter your name: ");
        String d = str.nextLine();
        cust.setF(d);
        
    }
    
    //This method is for Updating the car_id
    public void Update_id(){
        
        System.out.println("Enter id of the Car: ");
        int n = scanner.nextInt();
        cust.setIdUpdate(n);
        
    }
    
}