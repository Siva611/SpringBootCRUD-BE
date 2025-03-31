
# Hi, I'm Siva 👋


#  Student Portal Application 🌟

- This application will be used as a  __Student Management System__ that connects students with various educational resources, course enrollments, and student tracking.

<br>


#  Technologies 🛠️

## 🖥️ Backend:
<img width="50px" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg"/><img width="50px" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg"/>

**IDE:**  
<img width="50px" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/eclipse/eclipse-original.svg"/>


- Technologies: **Java, Spring Boot** <br>
- IDE: **Eclipse**  

---

## 🗄️ Database:
<img width="50px" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original-wordmark.svg"/>

**IDE:** 

<img width="50px" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg"/>


- Technology: **MySQL** <br>
- Tool: **MySQL Workbench**  

---

## 🛠️ APIS Testing Tool

For testing the APIs, we are using Postman.

**IDE:**  
<img width="50px" src="https://www.svgrepo.com/show/354202/postman-icon.svg"/>


---

## 🔹 Description
- Student Portal is a smart Student management system that integrates backend, and database technologies to provide seamless automation and control.

## 🔹 Features
- Secure backend 🛠️ API with Spring Boot
- MySQL database integration

<br>

# Features 🚀

## 🔹Student Portal

- **User Registration :**   
  - Students can register in securely.

- **Profile Management:**    
  - We can see and manage their details. 

- **Students Search:**    
  - Based on the Student register emails we can find the Students.  

<br>

## Backend Setup

### 1. Clone the backend repository:

- git clone https://github.com/Siva611/SpringBootCRUD-BE <br>
- cd SpringBootCRUD-BE

## 🔹 Database Configuration  

To configure the Update the MySQL database in **Spring Boot**, add the following properties in `application.properties`:  

```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
```



### Note: 
- Change the database name (__*your_database_name*__) if needed.
Ensure MySQL is running and the database is created.


### 3. Build and run the backend:

- mvn clean install <br>
- mvn spring-boot:run

<br>

# 🛠️ API 


## 🔹 Student API Endpoints  

<br>

### **Register New Student :**  
- **Method:** `POST`  
- 🛠️**API URL:** `http://localhost:8080/students `  
- **Content-Type:** `application/json`  
- **Request Body:**  
  ```json
  {

    "firstName": "Student1",
    "lastName": "S",
    "email": "student1@gmail.com",
    "department": "Mechanical",
    "aadharNumber": "335664577841"
   }
  ```

### **Get Student By ID :**  
- **Method:** `GET`  
- 🛠️**API URL:** `http://localhost:8080/students/3f364914-0532-4744-87f6-bf12996efde4"Auto generated Id"`  
- **Content-Type:** `application/json`

### **Get All Students:**  
- **Method:** `GET`  
- 🛠️**API URL:** `http://localhost:8080/students/`  
- **Content-Type:** `application/json`

### **Update Student :**  
- **Method:** `PUT`  
-  🛠️**API URL:** ` http://localhost:8080/students/`  
- **Content-Type:** `application/json`  
- **Request Body:**  
  ```json
   {

    "firstName": "Student1",
    "lastName": "S",
    "email": "student1@gmail.com",
    "department": "Mechanical",
    "aadharNumber": "335664577841"
    }

 ### **Delete Student :**  
- **Method:** `DELETE`  
-🛠️ **API URL:** `http://localhost:8080/students/3f364914-0532-4744-87f6-bf12996efde4"Auto generated Id"`  
- **Content-Type:** `application/json`  

---
<br>
