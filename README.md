# car_store
This is Simple Car store with a panel in the console.
I have created 6 classes which are: Customer, Car, ConnectDB, MyApplication, Sorting, Main and 1 Interface called Sort.

ConnectDB class: this the place where I am establishing the connection between my database. In advance I have to open it with driver in java.

MyApplication class: this is place where my panel with option is situated. There are also methods with prepared statements for each option.
Here are my options: 
                    Welcome to the Car Store
                    
            Select option:
            1. View all Cars
            2. Purchase Car/Cars
            3. Sort all the Cars
            4. Add personal information
            5. Add a Car
            6. Remove Car
            7. Update personal Information
            8. Delete personal Information
            9. Exit from Menu

Main class: it contains main method where everything runs, within the class I have another methods for option pressed in the console.

Car class: it contains getters and setters for all information about car. It also has methods to delete and insert this information.

Customer class: it contains getters and setters for all information about customer. It also has methods to delete and insert personal information.

Sort Interface: it has only 2 methods sortByDate() and sortByPrice(), names aare telling what they do.

Sorting class: it owns 6 methods 3 to sorting the date and 3 of them are for sorting by price.
