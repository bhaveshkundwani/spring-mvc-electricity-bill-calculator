# Spring MVC Electricity Bill Calculator

A simple Electricity Bill Calculator web application built using **Spring MVC, Spring JDBC (JdbcTemplate), MySQL, JSP, Maven, and Java 17**.

The application allows users to search for a consumer using their **name or service number**, retrieve consumer information from MySQL, and calculate the electricity bill based on the number of units consumed.

> This project is created for learning and portfolio purposes to demonstrate traditional Spring MVC architecture, JDBC database connectivity, JSP views, and deployment on Apache Tomcat.

---

## Features

* Search consumer by person name
* Search consumer by service number
* Retrieve consumer details from MySQL
* Calculate electricity charges based on consumed units
* Display consumer and bill details using JSP
* Spring MVC Controller-based request handling
* Spring JDBC `JdbcTemplate` for database access
* Maven-based dependency management
* JUnit and Spring Test support
* Deployable as a WAR application on Apache Tomcat 9

---

## Technology Stack

**Technology**     - **Version**
- Java             - 17
- Spring Framework - 5.3.39
- Spring MVC       - 5.3.39
- Spring JDBC      - 5.3.39
- MySql            - 8.x
- MySQL Connector/J - 8.4.0
- JSP              - Servlet/JSP support provided by Tomcat 9
- JSTL             - 1.2
- Apache Tomcat    - 9.0.x
- Maven            - 3.x
- JUnit            - 4.13.2

---

## Project Architecture

The application follows a traditional layered Spring MVC architecture:

```text
Browser
   |
   v
JSP View
   |
   v
Spring MVC Controller
   |
   v
DAO Layer
   |
   v
JdbcTemplate
   |
   v
MySQL Database
```

### Layers

**Model**

Contains the `Person` Java class representing consumer information.

**Controller**

Handles HTTP requests, accepts search input, invokes the DAO, calculates electricity charges, and sends data to the JSP view.

**DAO**

Uses Spring JDBC `JdbcTemplate` to execute SQL queries and retrieve consumer information from MySQL.

**View**

JSP pages provide the user interface for searching consumers and displaying electricity bill details.

---

## Electricity Bill Calculation

The application uses the following unit-based tariff:

**Units Consumed** - **Rate** 
- First 100 units - ₹10 per unit 
- 101–200 units   - ₹15 per unit 
- 201–300 units   - ₹20 per unit 
- Above 300 units - ₹25 per unit

For example, for **250 units**:

```text
First 100 units  = 100 × ₹10 = ₹1000
Next 100 units   = 100 × ₹15 = ₹1500
Remaining 50     =  50 × ₹20 = ₹1000
                              ------
Total                        ₹3500
```

---

## Database

The project uses a MySQL database named:

```text
electricity_bill_db
```

The database setup script is available at:

```text
database/schema.sql
```

The sample table is:

```text
personsdetails
```

---

## Prerequisites

Before running the project, install:

* Java JDK 17
* Apache Maven
* MySQL Server
* Spring Tool Suite (STS) or Eclipse
* Apache Tomcat 9

Tomcat 9 is used because this project uses the Java EE `javax.*` API and the Servlet 4.0 specification.

---

## Project Setup

### 1. Clone the repository

```bash
git clone https://github.com/bhaveshkundwani/spring-mvc-electricity-bill-calculator.git
```

### 2. Open the project in STS

Import it as:

```text
File
→ Import
→ Maven
→ Existing Maven Projects
```

Select the project directory and import the Maven project.

### 3. Configure Java

Use:

```text
Java 17
```

### 4. Configure MySQL

Execute:

```text
database/schema.sql
```

in MySQL Workbench or the MySQL command line.

### 5. Configure database credentials

Create:

```text
src/main/resources/db.properties
```

using the example file:

```text
src/main/resources/db.properties.example
```

Update the MySQL username and password.

Example:

```properties
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/electricity_bill_db?serverTimezone=UTC
db.username=root
db.password=YOUR_MYSQL_PASSWORD
```

> `db.properties` is intentionally excluded from Git because it contains local database credentials.

### 6. Configure Tomcat

Add:

```text
Apache Tomcat 9
```

as a server runtime in STS.

Make sure the project is targeted to Tomcat 9.

### 7. Run the application

Right-click the project:

```text
Run As
→ Run on Server
```

Select:

```text
Tomcat 9
```

Then open:

```text
http://localhost:8080/spring-mvc-electricity-bill-calculator/
```

---

## Application Flow

```text
User opens application
        |
        v
Consumer Search Form
        |
        +--------------------+
        |                    |
   Person Name        Service Number
        |                    |
        +---------+----------+
                  |
                  v
        PersonController
                  |
                  v
             PersonDao
                  |
                  v
            JdbcTemplate
                  |
                  v
              MySQL
                  |
                  v
        Consumer Information
                  |
                  v
       Electricity Calculation
                  |
                  v
             welcome.jsp
```

---

## Project Structure

```text
spring-mvc-electricity-bill-calculator/
│
├── database/
│   └── schema.sql
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/electricitybill/
│   │   │       ├── controller/
│   │   │       ├── dao/
│   │   │       └── model/
│   │   │
│   │   ├── resources/
│   │   │   ├── db.properties.example
│   │   │   └── db.properties
│   │   │
│   │   └── webapp/
│   │       ├── index.jsp
│   │       └── WEB-INF/
│   │           ├── web.xml
│   │           ├── spring-servlet.xml
│   │           └── jsp/
│   │               ├── personsearchform.jsp
│   │               └── welcome.jsp
│   │
│   └── test/
│       └── java/
│
├── .gitignore
├── pom.xml
└── README.md
```

---

## Learning Objectives

This project demonstrates:

* Spring MVC request mapping
* Model-View-Controller architecture
* Dependency Injection
* Constructor-based dependency injection
* Spring JDBC
* `JdbcTemplate`
* DAO pattern
* `BeanPropertyRowMapper`
* MySQL connectivity
* JSP and JSTL
* Maven dependency management
* WAR packaging
* Apache Tomcat deployment
* JUnit testing
* Basic Git and GitHub project management

---

## Future Improvements

Possible improvements for future versions include:

* Add validation for search fields
* Add a dedicated electricity billing service layer
* Add bill history
* Add payment simulation
* Improve UI and responsive design
* Add more detailed unit tests
* Introduce Spring Boot in a separate version of the project

---

## Author

**Bhavesh Kundwani**

Java | Spring | Spring MVC | Spring Boot | MySQL

---

## License

This project is created for educational and portfolio purposes.
