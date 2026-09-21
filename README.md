# Car Rental Management System

A desktop-based Java application for managing a car rental business. This system simplifies the process of registering vehicles, managing customers, processing rentals, handling vehicle returns, and generating billing reports. 

Built using Java Swing (NetBeans GUI Builder) and MySQL, it provides a user-friendly interface for day-to-day rental operations.

## 🚀 Features

### 1. Vehicle Registration
*   **CRUD Operations**: Add, Edit, Delete, and view vehicles in the fleet.
*   **Image Support**: Upload and store photos of the vehicles.
*   **Categorization**: Categorize vehicles by type (Car, SUV, Van, Luxury Car, Scooter, Bike, etc.).
*   **Availability Tracking**: Automatically tracks if a vehicle is currently available for rent or out with a customer.

### 2. Customer Management
*   **Customer Profiles**: Register new customers with their personal details and contact information.
*   **NIC Verification**: Upload and store both front and back photos of the customer's National Identity Card (NIC) for security and verification.
*   **Customer Reports**: Generate printable PDF reports of registered customers using Jasper Reports.

### 3. Rental Operations
*   **Smart Search**: Filter available vehicles based on category.
*   **Rent Processing**: Assign a vehicle to a registered customer. Select the expected return (overdue) date.
*   **Live Status Updates**: Renting a vehicle automatically marks it as unavailable in the system.

### 4. Returns & Billing
*   **Automated Fee Calculation**: Enter the actual return date, and the system will calculate the total fee based on the vehicle category's base rate and apply specific late fees if returned past the overdue date.
*   **Receipt Generation**: Automatically generates a professional Jasper Report bill upon successful return.

## 🛠️ Technology Stack

*   **Language**: Java (JDK 8+)
*   **GUI Framework**: Java Swing (Designed with NetBeans GUI Builder)
*   **Database**: MySQL
*   **Reporting**: JasperReports 
*   **Other Libraries**: JCalendar (for date pickers)

## 📋 Prerequisites

To run this project locally, you will need:
1.  **Java Development Kit (JDK)**: Version 8 or higher.
2.  **MySQL Server**: Running locally on port 3306.
3.  **NetBeans IDE** (Recommended): For opening and running the project easily with its GUI builder components.

## ⚙️ Setup and Installation

### 1. Database Configuration
1. Open your MySQL client (e.g., MySQL Workbench, phpMyAdmin).
2. Create a new database named `vehiclerentdata`.
3. *(Note: A SQL dump file should be imported here if available. The required tables are `registration`, `customer`, `rent`, and `bill`)*.

### 2. Connect the Application to the Database
The database credentials are managed in the `db.properties` file.
1. Navigate to `src/main/resources/db.properties`.
2. Update the credentials to match your local MySQL setup:
    ```properties
    db.url=jdbc:mysql://localhost:3306/vehiclerentdata
    db.username=root
    db.password=YourPasswordHere
    db.driver=com.mysql.cj.jdbc.Driver
    ```

### 3. Add External Libraries (JAR Files)
Ensure the following libraries are added to your project's build path/classpath:
*   MySQL JDBC Connector (`mysql-connector-java.jar`)
*   JCalendar (`jcalendar.jar`)
*   JasperReports libraries (core, fonts, components, etc.)

### 4. Run the Application
Run the `login.java` file (or `Home.java` to bypass login for testing) directly from your IDE to launch the application.

## 📂 Project Architecture (Refactored)

The system is designed with a separation of concerns to keep the main GUI class (`Home.java`) manageable:

*   **`Home.java`**: The main GUI frame containing the Swing components.
*   **`DatabaseHelper.java`**: Centralized database connection manager utilizing `db.properties`.
*   **`RegistrationHelper.java`**: Contains all business logic and database queries for the Registration tab.
*   **`CustomerHelper.java`**: Contains all business logic for managing customers and their NIC images.
*   **`RentalHelper.java`**: Manages the logic for searching available cars and processing new rentals.
*   **`ReturnHelper.java`**: Handles the complex logic of calculating days rented, late fees, and processing vehicle returns.

## 📄 License
This project is open-source and available under the MIT License.
