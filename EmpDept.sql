-- DEPARTMENT TABLE
CREATE TABLE Departments (
    dept_id    INT          PRIMARY KEY AUTO_INCREMENT,
    dept_name  VARCHAR(50)  NOT NULL
);


-- STAFF TABE
CREATE TABLE Staff (
    emp_id      INT           PRIMARY KEY AUTO_INCREMENT,
    emp_name    VARCHAR(100)  NOT NULL,
    department  VARCHAR(50),
    salary      DECIMAL(10,2),
    email       VARCHAR(100),
    dept_id     INT,
    FOREIGN KEY (dept_id) REFERENCES Departments(dept_id)
);

-- INSERT VALUE IN DEPT TABLE
INSERT INTO Departments (dept_name) VALUES
    ('IT'),
    ('HR'),
    ('Testing'),
    ('Finance'),
    ('Marketing');
    
-- INSERT VALUE IN STAFF TABLE
INSERT INTO Staff
    (emp_name, department, salary, email, dept_id)
VALUES
    ('Rahul Sharma',  'IT',        75000.00, 'rahul@example.com',  1),
    ('Riya Mehta',    'HR',        48000.00, 'riya@example.com',   2),
    ('Amit Verma',    'Testing',   52000.00, 'amit@example.com',   3),
    ('Sneha Rao',     'IT',        68000.00, 'sneha@example.com',  1),
    ('Vikram Das',    'Finance',   90000.00, 'vikram@example.com', 4),
    ('Priya Nair',    'HR',        45000.00, NULL,                  2),
    ('Rohit Singh',   'Testing',   55000.00, 'rohit@example.com',  3),
    ('Kavya Pillai',  'Marketing', 38000.00, 'rahul@example.com',  5),
    ('Deepak Joshi',  'IT',        82000.00, NULL,                  1),
    ('Meena Iyer',    'Finance',   71000.00, 'meena@example.com',  4);
    
-- Fetch all staff from IT department
SELECT * FROM Staff
WHERE department = 'IT';

-- Update salary for Testing department
SET SQL_SAFE_UPDATES = 0;

UPDATE Staff
SET salary = salary * 1.10
WHERE department = 'Testing';

SET SQL_SAFE_UPDATES = 1; 

-- Delete a staff member who resigned
DELETE FROM Staff
WHERE emp_id = 101;

-- Display staff sorted by highest salary
SELECT * FROM Staff
ORDER BY salary DESC;

-- Fetch top 2 highest-paid staff
SELECT * FROM Staff
ORDER BY salary DESC
LIMIT 2;

-- Count total records in Staff table
SELECT COUNT(*) AS total_staff
FROM Staff;

-- Calculate average salary of staff
SELECT AVG(salary) AS avg_salary
FROM Staff;


-- Find highest and lowest salary in the company
SELECT MAX(salary) AS highest,
       MIN(salary) AS lowest
FROM Staff;

-- Count staff department-wise using GROUP BY
SELECT department,
       COUNT(*) AS staff_count
FROM Staff
GROUP BY department;

-- Departments with more than one staff using HAVING
SELECT department, COUNT(*) AS staff_count
FROM Staff
GROUP BY department
HAVING COUNT(*) > 1;

-- Find staff whose email IDs are NULL
SELECT 
    *
FROM
    Staff
WHERE
    email IS NULL;

-- Fetch staff whose names start with 'R'
SELECT * FROM Staff
WHERE emp_name LIKE 'R%';

-- Find staff with salary between 40000 and 60000
SELECT * FROM Staff
WHERE salary BETWEEN 40000 AND 60000;

-- Fetch staff in HR and IT departments
SELECT * FROM Staff
WHERE department IN ('HR', 'IT');

-- Add mobile_number column to Staff
ALTER TABLE Staff
ADD mobile_number VARCHAR(15);

-- Rename column emp_name to employee_name
ALTER TABLE Staff
RENAME COLUMN emp_name TO employee_name;

-- Remove mobile_number column from Staff
ALTER TABLE Staff
DROP COLUMN mobile_number;

-- Fetch staff names with department names using JOIN
SELECT s.employee_name, d.dept_name
FROM Staff s
JOIN Departments d
  ON s.dept_id = d.dept_id;
  
-- Find staff earning more than average salary
SELECT * FROM Staff
WHERE salary > (
  SELECT AVG(salary) FROM Staff
);

-- Find duplicate email records in Staff
SELECT email, COUNT(*) AS cnt
FROM Staff
GROUP BY email
HAVING COUNT(*) > 1;

-- Verify staff data inserted successfully
SELECT * FROM Staff
WHERE emp_id = 201;

-- Or verify the latest inserted row:
SELECT * FROM Staff
ORDER BY emp_id DESC LIMIT 1;

-- Delete staff having NULL email IDs
SET SQL_SAFE_UPDATES = 0;

DELETE FROM Staff
WHERE email IS NULL;

SET SQL_SAFE_UPDATES = 1;

-- Create backup of Staff table
CREATE TABLE Staff_backup AS
SELECT * FROM Staff;

-- Delete all records using TRUNCATE
-- TRUNCATE TABLE Staff;

-- Permanently delete the Staff table
-- DROP TABLE Staff;


-- Salary Audit Report — top 3 highest paid above average
SELECT employee_name, salary
FROM Staff
WHERE salary > (SELECT AVG(salary) FROM Staff)
ORDER BY salary DESC
LIMIT 3;

-- Department-Wise Employee Count — departments with more than 5
SELECT department, COUNT(*) AS emp_count
FROM Staff
GROUP BY department
HAVING COUNT(*) > 5;

-- Recently Joined Employees — joined in 2024, sorted by date, limit 5
SELECT *
FROM Staff
WHERE YEAR(joining_date) = 2024
ORDER BY joining_date DESC
LIMIT 5;

















