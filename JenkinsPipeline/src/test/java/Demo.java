import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo {

    public WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Configure Chrome for headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        // Create a new instance of the ChromeDriver (auto-detects Chrome)
        driver = new ChromeDriver(options);

        // Navigate to a website
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void test1() {
        WebElement text = driver.findElement(By.xpath("//span[text()='Products']"));

        String originalText = "Products";
        String expectedText = text.getText();
        Assert.assertEquals(originalText, expectedText);
    }

    @AfterClass
    public void afterClass() {
        // Close the WebDriver instance
        driver.quit();
    }
}
