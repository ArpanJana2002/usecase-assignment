CREATE DATABASE ShopDB;
USE ShopDB;

-- Customers table
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Email VARCHAR(100) UNIQUE,
    Phone VARCHAR(20),
    Address VARCHAR(255),
    City VARCHAR(50),
    Country VARCHAR(50)
);

-- Products table
CREATE TABLE Products (
    ProductID INT PRIMARY KEY AUTO_INCREMENT,
    ProductName VARCHAR(100),
    Description TEXT,
    Price DECIMAL(10,2),
    StockQuantity INT
);

-- Orders table
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerID INT,
    OrderDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    Status VARCHAR(50),
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Payments table
CREATE TABLE Payments (
    PaymentID INT PRIMARY KEY AUTO_INCREMENT,
    OrderID INT,
    PaymentDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    Amount DECIMAL(10,2),
    PaymentMethod VARCHAR(50),
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID)
);

-- Insert sample customers
INSERT INTO Customers (FirstName, LastName, Email, Phone, Address, City, Country)
VALUES
('Amit', 'Sharma', 'amit.sharma@example.com', '9876543210', '123 MG Road', 'Pune', 'India'),
('Priya', 'Patel', 'priya.patel@example.com', '9123456780', '45 Nehru Street', 'Mumbai', 'India'),
('Mrinal', 'Sen', 'mrinal.sen@example.com', '9988776655', '789 SN Banerjee Road ', 'Kolkata', 'India');

-- Insert sample products
INSERT INTO Products (ProductName, Description, Price, StockQuantity)
VALUES
('Laptop', '15-inch business laptop', 75000.00, 20),
('Smartphone', 'Latest Android smartphone', 25000.00, 50),
('Headphones', 'Noise-cancelling headphones', 5000.00, 100);

-- Insert sample orders
INSERT INTO Orders (CustomerID, OrderDate, Status)
VALUES
(1, NOW(), 'Processing'),
(2, NOW(), 'Shipped'),
(3, NOW(), 'Delivered');

-- Insert sample payments
INSERT INTO Payments (OrderID, PaymentDate, Amount, PaymentMethod)
VALUES
(1, NOW(), 75000.00, 'Credit Card'),
(2, NOW(), 25000.00, 'UPI'),
(3, NOW(), 5000.00, 'PayPal');

-- which customer placed which order.
SELECT 
    c.CustomerID, c.FirstName, c.LastName, 
    o.OrderID, o.OrderDate, o.Status
FROM Customers c
JOIN Orders o ON c.CustomerID = o.CustomerID;


-- payment details for each order.
SELECT 
    o.OrderID, o.Status, 
    p.PaymentID, p.Amount, p.PaymentMethod, p.PaymentDate
FROM Orders o
JOIN Payments p ON o.OrderID = p.OrderID;

-- Join customers, orders & payments table
SELECT 
    c.FirstName, c.LastName, 
    o.OrderID, o.OrderDate, o.Status, 
    p.Amount, p.PaymentMethod
FROM Customers c
JOIN Orders o ON c.CustomerID = o.CustomerID
JOIN Payments p ON o.OrderID = p.OrderID;

-- INNER JOIN
SELECT 
    c.CustomerID, c.FirstName, c.LastName,
    o.OrderID, o.Status,
    p.Amount, p.PaymentMethod
FROM Customers c
INNER JOIN Orders o ON c.CustomerID = o.CustomerID
INNER JOIN Payments p ON o.OrderID = p.OrderID;


-- LEFT JOIN
SELECT 
    c.CustomerID, c.FirstName, c.LastName,
    o.OrderID, o.Status,
    p.Amount, p.PaymentMethod
FROM Customers c
LEFT JOIN Orders o ON c.CustomerID = o.CustomerID
LEFT JOIN Payments p ON o.OrderID = p.OrderID;

-- RIGHT JOIN
SELECT 
    c.CustomerID, c.FirstName, c.LastName,
    o.OrderID, o.Status,
    p.Amount, p.PaymentMethod
FROM Customers c
RIGHT JOIN Orders o ON c.CustomerID = o.CustomerID
RIGHT JOIN Payments p ON o.OrderID = p.OrderID;


-- FULL JOIN
SELECT 
    c.CustomerID, c.FirstName, c.LastName,
    o.OrderID, o.Status,
    p.Amount, p.PaymentMethod
FROM Customers c
LEFT JOIN Orders o ON c.CustomerID = o.CustomerID
LEFT JOIN Payments p ON o.OrderID = p.OrderID

UNION

SELECT 
    c.CustomerID, c.FirstName, c.LastName,
    o.OrderID, o.Status,
    p.Amount, p.PaymentMethod
FROM Customers c
RIGHT JOIN Orders o ON c.CustomerID = o.CustomerID
RIGHT JOIN Payments p ON o.OrderID = p.OrderID;







