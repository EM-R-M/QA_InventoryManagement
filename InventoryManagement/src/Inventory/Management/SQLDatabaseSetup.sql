CREATE DATABASE inventorymanagement;

USE inventorymanagement;

CREATE TABLE customers (
	customerID INT AUTO_INCREMENT PRIMARY KEY,
    customerName VARCHAR(255) NOT NULL,
    customerEmail VARCHAR(255) NOT NULL);