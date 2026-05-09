CREATE TABLE buyers (
    buyer_id      INT PRIMARY KEY AUTO_INCREMENT,
    buyer_name    VARCHAR(100)
);

CREATE TABLE purchases (
    purchase_id   INT PRIMARY KEY AUTO_INCREMENT,
    buyer_id      INT,
    purchase_amount DECIMAL(10,2),
    FOREIGN KEY (buyer_id) REFERENCES buyers(buyer_id)
);

-- Insert sample data
INSERT INTO buyers (buyer_name) VALUES
('Arjun Sharma'),
('Priya Patel'),
('Rahul Kumar'),
('Anita Singh'),
('Vikram Reddy');

INSERT INTO purchases (buyer_id, purchase_amount) VALUES
(1, 25000.00), (1, 30000.00),
(2, 20000.00), (2, 35000.00),
(3, 15000.00), (3, 12000.00),
(4, 8000.00),
(5, 40000.00), (5, 25000.00);

-- Query
SELECT b.buyer_name,
       SUM(p.purchase_amount) AS total_spent
FROM buyers b
JOIN purchases p ON b.buyer_id = p.buyer_id
GROUP BY b.buyer_id, b.buyer_name
HAVING SUM(p.purchase_amount) > 50000;

-- Orders Without Customers — no matching customer record
SELECT p.purchase_id
FROM purchases p
LEFT JOIN buyers b ON p.buyer_id = b.buyer_id
WHERE b.buyer_id IS NULL;

-- 