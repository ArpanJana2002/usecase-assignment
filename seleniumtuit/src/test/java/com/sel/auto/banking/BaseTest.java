package banking;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	WebDriverWait wait;

	String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

	String username = "arpan12345";
	String password = "Arpan@123";

	@BeforeMethod
	public void setup() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {

			driver.quit();
		}
	}
}