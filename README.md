# MotorPH Inventory Management System

A Java-based **inventory management application** for MotorPH, built with **NetBeans** and **Maven**.  
This project demonstrates **Object-Oriented Programming (OOP)** principles, CSV data integration, and an interactive menu-driven system for managing motorcycle stock records.

---

## 📌 Features
- Load inventory data from a CSV file (`src/main/resources/data/MotorPH Inventory Data.csv`)
- Display all inventory items
- Sort inventory by brand (Insertion Sort / Bubble Sort utilities)
- Search inventory by:
  - Brand
  - Engine number
  - Status
- Delete stock items by engine number
- Interactive **menu system** for user choice

---

## 📂 Project Structure
MotorPHInventory/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/com/mycompany/motorphinventory/
│   │   │   ├── InventoryApp.java
│   │   │   ├── MotorPHInventory.java
│   │   │   ├── SearchUtils.java
│   │   │   ├── SortUtils.java
│   │   │   └── Stock.java
│   │   └── resources/data/MotorPH Inventory Data.csv
