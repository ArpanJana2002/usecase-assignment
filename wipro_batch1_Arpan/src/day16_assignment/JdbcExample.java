package day16_assignment;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {
	// Database credentials
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_db";
	static final String JDBC_USER = "your_username";
	static final String JDBC_PASSWORD = "your_password";

	public static void main(String[] args) {
		try {
			// 1. Load JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Establish connection
			Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			System.out.println("Connection established successfully.");

			// 3. Create table
			String createTableSQL = "CREATE TABLE IF NOT EXISTS employees (" + "id INT PRIMARY KEY AUTO_INCREMENT, "
					+ "name VARCHAR(50) NOT NULL, " + "department VARCHAR(50), " + "salary DOUBLE)";
			Statement stmt = conn.createStatement();
			stmt.execute(createTableSQL);
			System.out.println("Table 'employees' created successfully.");

			// 4. Insert data using PreparedStatement
			String insertSQL = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insertSQL);

			// Insert first employee
			pstmt.setString(1, "Animesh");
			pstmt.setString(2, "HR");
			pstmt.setDouble(3, 50000);
			pstmt.executeUpdate();

			// Insert second employee
			pstmt.setString(1, "Ritam");
			pstmt.setString(2, "Engineering");
			pstmt.setDouble(3, 70000);
			pstmt.executeUpdate();
			System.out.println("Data inserted successfully.");

			// 5. Update data
			String updateSQL = "UPDATE employees SET salary = ? WHERE name = ?";
			pstmt = conn.prepareStatement(updateSQL);
			pstmt.setDouble(1, 75000);
			pstmt.setString(2, "Ritam");
			int rowsUpdated = pstmt.executeUpdate();
			System.out.println("Rows updated: " + rowsUpdated);

			// 6. Query and display data
			String selectSQL = "SELECT * FROM employees";
			ResultSet rs = stmt.executeQuery(selectSQL);
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Department: "
						+ rs.getString("department") + ", Salary: " + rs.getDouble("salary"));
			}

			// 7. Close resources
			rs.close();
			pstmt.close();
			stmt.close();
			conn.close();
			System.out.println("Resources closed successfully.");

		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver not found: " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("SQL Exception: " + e.getMessage());
		}
	}
}