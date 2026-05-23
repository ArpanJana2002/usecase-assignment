package com.datadriven.testing;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDdt {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Path to Excel file in src/test/resources
		FileInputStream fis = new FileInputStream("src/test/resources/Book.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");

		int rows = sh.getLastRowNum();

		for (int i = 1; i <= rows; i++) {
			Row row = sh.getRow(i);
			if (row == null)
				continue;

			// Fetch username from column 0
			Cell usernameCell = row.getCell(0);
			if (usernameCell == null)
				continue;
			String username = usernameCell.getStringCellValue();

			// Fetch password from column 1
			Cell passwordCell = row.getCell(1);
			String password = "";
			if (passwordCell != null) {
				password = passwordCell.getStringCellValue();
			}

			WebDriver driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com");
			driver.findElement(By.id("user-name")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("login-button")).click();

			Thread.sleep(2000);

			driver.quit();
		}

		wb.close();
		fis.close();
	}
}