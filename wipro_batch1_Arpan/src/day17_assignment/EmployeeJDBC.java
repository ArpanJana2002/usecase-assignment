package day17_assignment;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeJDBC {

	// DB CONFIG
	private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
	private static final String USER = "root";
	private static final String PASSWORD = "your_password";

	// CONNECTION HELPER
	private static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	// 1. INSERT 5 EMPLOYEE RECORDS USING PreparedStatement
	public static void insertEmployees() {
		String insertDept = "INSERT IGNORE INTO departments (dept_id, dept_name) VALUES (?, ?)";
		String insertEmp = "INSERT INTO employees (name, dept_id, salary, email, password) " + "VALUES (?, ?, ?, ?, ?)";

		// Sample data: {name, dept_id, salary, email, password}
		Object[][] employees = { { "Alice Johnson", 1, 75000.00, "alice@company.com", "pass123" },
				{ "Bob Smith", 2, 45000.00, "bob@company.com", "pass456" },
				{ "Carol White", 1, 92000.00, "carol@company.com", "pass789" },
				{ "David Brown", 3, 38000.00, "david@company.com", "pass321" },
				{ "Eva Martinez", 2, 61000.00, "eva@company.com", "pass654" } };

		Object[][] departments = { { 1, "Engineering" }, { 2, "Marketing" }, { 3, "HR" } };

		try (Connection conn = getConnection()) {
			// Insert departments first
			try (PreparedStatement ps = conn.prepareStatement(insertDept)) {
				for (Object[] dept : departments) {
					ps.setInt(1, (int) dept[0]);
					ps.setString(2, (String) dept[1]);
					ps.addBatch();
				}
				ps.executeBatch();
				System.out.println("Departments inserted.");
			}

			// Insert 5 employees using PreparedStatement batch
			try (PreparedStatement ps = conn.prepareStatement(insertEmp, Statement.RETURN_GENERATED_KEYS)) {
				for (Object[] emp : employees) {
					ps.setString(1, (String) emp[0]);
					ps.setInt(2, (int) emp[1]);
					ps.setDouble(3, (double) emp[2]);
					ps.setString(4, (String) emp[3]);
					ps.setString(5, (String) emp[4]);
					ps.addBatch();
				}
				int[] results = ps.executeBatch();
				System.out.println("Inserted " + results.length + " employee records.");
			}

		} catch (SQLException e) {
			System.err.println("insertEmployees: " + e.getMessage());
		}
	}

	// 2. FETCH EMPLOYEES WITH SALARY > 50,000
	public static void fetchHighEarners(double threshold) {
		String sql = "SELECT emp_id, name, salary FROM employees WHERE salary > ?";

		System.out.println("\nEmployees with salary > " + threshold + " ──");
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setDouble(1, threshold);
			try (ResultSet rs = ps.executeQuery()) {
				boolean found = false;
				while (rs.next()) {
					found = true;
					System.out.printf("  ID: %d | Name: %-20s | Salary: %.2f%n", rs.getInt("emp_id"),
							rs.getString("name"), rs.getDouble("salary"));
				}
				if (!found)
					System.out.println("  No records found.");
			}
		} catch (SQLException e) {
			System.err.println("fetchHighEarners: " + e.getMessage());
		}
	}

	// 3. DELETE EMPLOYEE BY ID
	public static void deleteEmployee(int empId) {
		String sql = "DELETE FROM employees WHERE emp_id = ?";

		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, empId);
			int rows = ps.executeUpdate();
			System.out.println("\nDelete Employee ID " + empId + " ──");
			System.out.println(rows > 0 ? "  Employee deleted successfully." : "  No employee found with ID " + empId);

		} catch (SQLException e) {
			System.err.println("✘ deleteEmployee: " + e.getMessage());
		}
	}

	// 4. UPDATE EMPLOYEE SALARY USING PreparedStatement
	public static void updateSalary(int empId, double newSalary) {
		String sql = "UPDATE employees SET salary = ? WHERE emp_id = ?";

		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setDouble(1, newSalary);
			ps.setInt(2, empId);
			int rows = ps.executeUpdate();
			System.out.println("\nUpdate Salary for ID " + empId + " ──");
			System.out.println(rows > 0 ? "  Salary updated to " + newSalary : "  No employee found with ID " + empId);

		} catch (SQLException e) {
			System.err.println("✘ updateSalary: " + e.getMessage());
		}
	}

	// 5. CALL STORED PROCEDURE FOR EMPLOYEE SEARCH
	public static void searchEmployeeByName(String nameFragment) {
		String sql = "{CALL SearchEmployee(?)}";

		System.out.println("\nSearch Results for \"" + nameFragment + "\" ──");
		try (Connection conn = getConnection(); CallableStatement cs = conn.prepareCall(sql)) {

			cs.setString(1, nameFragment);
			try (ResultSet rs = cs.executeQuery()) {
				boolean found = false;
				while (rs.next()) {
					found = true;
					System.out.printf("  ID: %d | Name: %-20s | Dept: %-15s | Salary: %.2f%n", rs.getInt("emp_id"),
							rs.getString("name"), rs.getString("dept_name"), rs.getDouble("salary"));
				}
				if (!found)
					System.out.println("  No matching employees.");
			}
		} catch (SQLException e) {
			System.err.println("searchEmployeeByName: " + e.getMessage());
		}
	}

	// 6. COUNT TOTAL EMPLOYEES USING SQL COUNT()
	public static void countEmployees() {
		String sql = "SELECT COUNT(*) AS total FROM employees";

		System.out.println("\n── Total Employee Count ──");
		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			if (rs.next()) {
				System.out.println("  Total Employees: " + rs.getInt("total"));
			}
		} catch (SQLException e) {
			System.err.println("countEmployees: " + e.getMessage());
		}
	}

	// 7. DISPLAY HIGHEST SALARY EMPLOYEE
	public static void highestSalaryEmployee() {
		String sql = "SELECT emp_id, name, salary FROM employees "
				+ "WHERE salary = (SELECT MAX(salary) FROM employees)";

		System.out.println("\n── Highest Salary Employee ──");
		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				System.out.printf("  ID: %d | Name: %-20s | Salary: %.2f%n", rs.getInt("emp_id"), rs.getString("name"),
						rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			System.err.println("highestSalaryEmployee: " + e.getMessage());
		}
	}

	// 8. LOGIN VALIDATION USING JDBC
	public static boolean loginValidation(String email, String password) {
		String sql = "SELECT emp_id, name FROM employees WHERE email = ? AND password = ?";

		System.out.println("\n── Login Validation ──");
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, email);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					System.out.println("  Login SUCCESS — Welcome, " + rs.getString("name") + " (ID: "
							+ rs.getInt("emp_id") + ")");
					return true;
				} else {
					System.out.println("  Login FAILED — Invalid credentials.");
					return false;
				}
			}
		} catch (SQLException e) {
			System.err.println("loginValidation: " + e.getMessage());
			return false;
		}
	}

	// 9. FETCH EMPLOYEES DEPARTMENT-WISE

	public static void fetchByDepartment() {
		String sql = "SELECT d.dept_name, e.emp_id, e.name, e.salary " + "FROM employees e "
				+ "JOIN departments d ON e.dept_id = d.dept_id " + "ORDER BY d.dept_name, e.name";

		System.out.println("\n── Employees Department-Wise ──");
		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			String currentDept = "";
			while (rs.next()) {
				String dept = rs.getString("dept_name");
				if (!dept.equals(currentDept)) {
					System.out.println("\n  [" + dept + "]");
					currentDept = dept;
				}
				System.out.printf("    ID: %d | %-20s | Salary: %.2f%n", rs.getInt("emp_id"), rs.getString("name"),
						rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			System.err.println("✘ fetchByDepartment: " + e.getMessage());
		}
	}

	// 10. FULL CRUD OPERATIONS (Read + combined update showcase)
	public static void readAllEmployees() {
		String sql = "SELECT e.emp_id, e.name, d.dept_name, e.salary, e.email " + "FROM employees e "
				+ "JOIN departments d ON e.dept_id = d.dept_id " + "ORDER BY e.emp_id";

		System.out.println("\nAll Employees (READ) ──");
		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			System.out.printf("  %-5s %-20s %-15s %-12s %-25s%n", "ID", "Name", "Department", "Salary", "Email");
			System.out.println("  " + "─".repeat(80));

			while (rs.next()) {
				System.out.printf("  %-5d %-20s %-15s %-12.2f %-25s%n", rs.getInt("emp_id"), rs.getString("name"),
						rs.getString("dept_name"), rs.getDouble("salary"), rs.getString("email"));
			}
		} catch (SQLException e) {
			System.err.println("readAllEmployees: " + e.getMessage());
		}
	}

	// UPDATE — update both name and dept using PreparedStatement with transaction

	public static void updateEmployee(int empId, String newName, int newDeptId) {
		String sql = "UPDATE employees SET name = ?, dept_id = ? WHERE emp_id = ?";

		System.out.println("\nUpdate Employee ID " + empId + " (CRUD UPDATE) ──");
		try (Connection conn = getConnection()) {
			conn.setAutoCommit(false); // begin transaction
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, newName);
				ps.setInt(2, newDeptId);
				ps.setInt(3, empId);
				int rows = ps.executeUpdate();
				conn.commit(); // commit
				System.out.println(rows > 0 ? "  Employee updated: name=" + newName + ", dept=" + newDeptId
						: "  No employee found.");
			} catch (SQLException ex) {
				conn.rollback(); // rollback on error
				throw ex;
			}
		} catch (SQLException e) {
			System.err.println("✘ updateEmployee: " + e.getMessage());
		}
	}

	// MAIN — Demo all operations
	public static void main(String[] args) {

		System.out.println("--------JDBC Employee Management System----------");

		// 1. Insert 5 employees
		insertEmployees();

		// 2. Fetch salary > 50000
		fetchHighEarners(50000);

		// 3. Delete employee by ID
		deleteEmployee(4);

		// 4. Update salary
		updateSalary(1, 85000.00);

		// 5. Stored procedure search
		searchEmployeeByName("a");

		// 6. Count employees
		countEmployees();

		// 7. Highest salary
		highestSalaryEmployee();

		// 8. Login validation
		loginValidation("alice@company.com", "pass123");
		loginValidation("alice@company.com", "wrongpass");

		// 9. Department-wise
		fetchByDepartment();

		// 10. CRUD — Read + Update
		readAllEmployees();
		updateEmployee(2, "Robert Smith", 3);
		readAllEmployees();

		System.out.println("---------------All Tasks Complete------------");

	}
}
