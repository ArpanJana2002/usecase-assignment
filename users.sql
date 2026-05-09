-- Create table
CREATE TABLE users (
    user_id     INT PRIMARY KEY AUTO_INCREMENT,
    username    VARCHAR(100),
    email       VARCHAR(100),
    status      VARCHAR(20),
    last_login  DATETIME
);

-- INSERT VALUE
INSERT INTO users (username, email, status, last_login) VALUES
('arjun_sharma', 'arjun.sharma@email.com', 'active', '2026-05-08 14:30:00'),
('priya_patel', 'priya.patel@email.com', 'active', '2026-05-09 11:20:00'),
('rahul_kumar', 'rahul.kumar@email.com', 'inactive', '2026-05-07 16:45:00'),
('anita_singh', 'anita.singh@email.com', 'suspended', NULL);

-- Query
SELECT username, email
FROM users
WHERE status = 'ACTIVE'
  AND last_login IS NULL;
  
-- Duplicate Email Detection
SELECT email, COUNT(*) AS occurrences
FROM users
GROUP BY email
HAVING COUNT(*) > 1;