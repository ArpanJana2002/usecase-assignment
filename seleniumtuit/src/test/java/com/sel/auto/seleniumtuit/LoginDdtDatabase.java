package com.sel.auto.seleniumtuit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDdtDatabase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");

		String DB_URL = DatabaseConfig.getDB_URL();
		String DB_USER = DatabaseConfig.getDB_USER();
		String DB_PASSWORD = DatabaseConfig.getDB_PASSWORD();

		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		System.out.println("Database connection is successful!");

		Statement statement = conn.createStatement();
		String sql = "SELECT username, password FROM login_credentials";
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			String username = rs.getString("username");
			String password = rs.getString("password");

			System.out.println("Testing with username: " + username);

			WebDriver driver = new ChromeDriver();

			driver.get("https://www.saucedemo.com");
			driver.findElement(By.id("user-name")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("login-button")).click();

			Thread.sleep(2000);

			driver.quit();

		}
		rs.close();
		statement.close();
		conn.close();
		System.out.println("All test completed");

	}

}
