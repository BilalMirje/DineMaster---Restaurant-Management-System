# DineMaster — Restaurant Management System

**DineMaster** is a complete Restaurant Management System built using **Java Servlets**, **JSP**, and **MySQL**. It offers a robust and secure backend along with a dynamic frontend to handle various restaurant operations like managing orders, menus, billing, and users.

---

## 🔧 Tech Stack

- **Frontend:** JSP (Java Server Pages), HTML, CSS
- **Backend:** Java Servlets
- **Database:** MySQL
- **Other Tools:** Apache Tomcat, JDBC, GitHub

---

## 📦 Features

- Manage menu items (Add / Update / Delete)
- Take and process customer orders
- Generate bills
- Admin panel for overall management
- User authentication system (Admin & Staff)
- Session tracking using Servlet API

---

## ⚠️ Important Note

This project **does not include the `ConnectionFactory.java` file** (used for database connection in `com.dao`) in the repository **for privacy and security reasons**.

➡️ **You must create your own database connection file** using JDBC.  
Here’s an example structure:

```java
package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/your_db_name", "your_username", "your_password"
        );
    }
}
---

## 📄 License

**MIT License**  
Permission is granted to use, copy, modify, and distribute this software  
for any purpose, with or without fee, provided that the above copyright  
notice appears in all copies.  
This software is provided "as is", without any warranty.

&copy; 2025 Bilal Mirje


