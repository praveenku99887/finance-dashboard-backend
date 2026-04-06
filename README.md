# 💰 Finance Dashboard Backend

## 📌 Overview

This project is a backend system for managing financial records with secure authentication and role-based access control. It provides APIs for handling financial data and generating dashboard insights.

---

## 🚀 Tech Stack

* Java 17
* Spring Boot 3.x
* Spring Security (JWT Authentication)
* MySQL
* JPA (Hibernate)
* Maven

---

## 📁 Project Structure

```
com.finance.dashboard
│
├── controller
├── service
├── repository
├── entity
├── security
├── config
├── exception
```

---

## 🔐 Features

### 👤 Authentication

* User Registration
* User Login with JWT Token
* Secure password storage using BCrypt

---

### 🔑 Role-Based Access

| Role    | Permissions                |
| ------- | -------------------------- |
| ADMIN   | Full access (CRUD + users) |
| ANALYST | Read + dashboard           |
| VIEWER  | Read only                  |

---

### 💰 Financial Records

* Create record (Admin only)
* View records (All roles)
* Update record (Admin only)
* Delete record (Admin only)
* Filter by category

---

### 📊 Dashboard APIs

* Total Income
* Total Expense
* Net Balance
* Category-wise summary

---

## ⚙️ Setup Instructions

### 1️⃣ Clone Repository

```
git clone <your-repo-link>
cd finance-dashboard-backend
```

---

### 2️⃣ Setup Database

```
CREATE DATABASE finance_db;
```

---

### 3️⃣ Configure application.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 4️⃣ Run Application

```
mvn spring-boot:run
```

---

## 🌐 Base URL

```
http://localhost:8080
```

---

# 🔗 API ENDPOINTS

---

## 🔐 AUTH APIs

### ➤ Register

```
POST /auth/register
```

**Body:**

```
{
  "name": "Praveen",
  "email": "admin@gmail.com",
  "password": "1234",
  "role": "ADMIN",
  "active": true
}
```

---

### ➤ Login

```
POST /auth/login
```

**Body:**

```
{
  "email": "admin@gmail.com",
  "password": "1234"
}
```

**Response:**

```
JWT_TOKEN
```

---

# 🔑 Authorization

For protected APIs:

```
Authorization: Bearer YOUR_TOKEN
```

---

# 💰 FINANCIAL APIs

---

### ➤ Create Record (ADMIN)

```
POST /records
```

---

### ➤ Get All Records

```
GET /records
```

---

### ➤ Update Record (ADMIN)

```
PUT /records/{id}
```

---

### ➤ Delete Record (ADMIN)

```
DELETE /records/{id}
```

---

### ➤ Summary (ADMIN, ANALYST)

```
GET /records/summary
```

---

### ➤ Filter by Category

```
GET /records/category/{category}
```

---

# 🧪 Postman Testing Guide

### Step 1: Register User

* POST `/auth/register`

### Step 2: Login

* POST `/auth/login`
* Copy JWT Token

### Step 3: Add Header

```
Authorization: Bearer TOKEN
```

### Step 4: Test APIs

* Create record
* Get records
* Update record
* Delete record
* Summary

---

# 🗄️ Database Verification

Run:

```
SELECT * FROM users;
SELECT * FROM financial_record;
```

---

# ⚠️ Assumptions

* Roles are predefined
* JWT used for authentication
* Basic validation implemented

---

# 👨‍💻 Author
Praveen Kumar
NIT Arunachal Pradesh
