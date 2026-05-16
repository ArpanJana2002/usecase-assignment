package com.sel.auto.seleniumtuit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class AmazonSearchTest {
    WebDriver webdriver;
    WebDriverWait explicitWait;
    String searchQuery = "shoe for children";
    String amazonUrl = "https://www.amazon.in/";

    public void navigateToURL() {
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        webdriver.manage().deleteAllCookies();
        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webdriver.get(amazonUrl);
        explicitWait = new WebDriverWait(webdriver, Duration.ofSeconds(15));
    }

    void performSearch() {
        WebElement searchBar = explicitWait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))
        );
        searchBar.sendKeys(searchQuery);
        
        WebElement searchButton = explicitWait.until(
            ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button"))
        );
        searchButton.click();
        
        explicitWait.until(
            ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".a-spinner"))
        );
        System.out.println("Search completed");
    }

    void validatePageTitle() {
        String pageTitle = webdriver.getTitle();
        System.out.println("The title of the page is " + pageTitle);
    }

    void selectFirstProduct() {
        explicitWait.until(
            ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-component-type='s-search-result']"))
        );
        
        System.out.println("Found search results, selecting first product...");
        
        WebElement firstCard = explicitWait.until(
            ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-component-type='s-search-result']"))
        );
        
        WebElement productLink = firstCard.findElement(
            By.cssSelector("a.a-link-normal.s-underline-text.s-underline-link-text.s-link-style.a-text-normal")
        );
        
        JavascriptExecutor js = (JavascriptExecutor) webdriver;
        js.executeScript("arguments[0].scrollIntoView(true);", productLink);
        js.executeScript("arguments[0].click();", productLink);
        
        System.out.println("Clicked on product: " + productLink.getText());
        
        explicitWait.until(
            ExpectedConditions.urlContains("/dp/")
        );
        
        System.out.println("Product page loaded: " + webdriver.getCurrentUrl());
    }

    void addToCart() {
        explicitWait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("productTitle"))
        );
        
        System.out.println("Product page confirmed, finding Add to Cart button...");
        
        WebElement addToCartButton = explicitWait.until(
            ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button"))
        );
        
        JavascriptExecutor js = (JavascriptExecutor) webdriver;
        js.executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
        js.executeScript("arguments[0].click();", addToCartButton);
        
        System.out.println("Product added to cart successfully!");
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void buyNow() {
        WebElement buyNowButton = explicitWait.until(
            ExpectedConditions.elementToBeClickable(By.id("buy-now-button"))
        );
        JavascriptExecutor js = (JavascriptExecutor) webdriver;
        js.executeScript("arguments[0].scrollIntoView(true);", buyNowButton);
        js.executeScript("arguments[0].click();", buyNowButton);
        System.out.println("Buy Now clicked!");
    }

    void goToCart() {
        WebElement cartIcon = explicitWait.until(
            ExpectedConditions.elementToBeClickable(By.id("nav-cart"))
        );
        cartIcon.click();
        System.out.println("Navigated to cart page");
    }

    void validateCart() {
        boolean productInCart = webdriver.findElements(By.cssSelector(".sc-product-title")).size() > 0;
        System.out.println("Product in cart: " + productInCart);
    }

    void proceedToCheckout() {
        System.out.println("Proceeding to checkout...");
        
        explicitWait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("shopping-cart-elements"))
        );
        
        WebElement checkoutButton = explicitWait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector("#sc-checkout-submit-btn")
            )
        );
        
        JavascriptExecutor js = (JavascriptExecutor) webdriver;
        js.executeScript("arguments[0].scrollIntoView(true);", checkoutButton);
        js.executeScript("arguments[0].click();", checkoutButton);
        
        System.out.println("Proceed to checkout clicked!");
        
        explicitWait.until(
            ExpectedConditions.urlContains("/ap/signin") || 
            ExpectedConditions.urlContains("/checkout/")
        );
        
        if (webdriver.getCurrentUrl().contains("/ap/signin")) {
            System.out.println("Login required for checkout. Please login manually.");
            System.out.println("Waiting for manual login...");
            waitForManualLogin();
        } else {
            System.out.println("Checkout page loaded: " + webdriver.getCurrentUrl());
        }
    }

    void waitForManualLogin() {
        System.out.println("Please login manually. The test will continue after 10 seconds...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void placeOrder() {
        System.out.println("Attempting to place order...");
        
        explicitWait.until(
            ExpectedConditions.presenceOfElementLocated(By.cssSelector(".a-section"))
        );
        
        String currentUrl = webdriver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        
        if (currentUrl.contains("/checkout/gl")) {
            try {
                WebElement placeOrderButton = explicitWait.withTimeout(Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(
                        By.id("submitOrderButton")
                    ));
                
                JavascriptExecutor js = (JavascriptExecutor) webdriver;
                js.executeScript("arguments[0].scrollIntoView(true);", placeOrderButton);
                js.executeScript("arguments[0].click();", placeOrderButton);
                
                System.out.println("Order placed successfully!");
            } catch (Exception e) {
                System.out.println("Unable to place order automatically. Payment/shipping details may be required.");
                System.out.println("Manual intervention needed for checkout completion.");
            }
        } else {
            System.out.println("Not on order placement page. Full checkout requires pre-saved payment/shipping details.");
        }
    }

    void checkoutCompleteFlow() {
        System.out.println("Starting Complete Checkout Flow");
        
        goToCart();
        validateCart();
        proceedToCheckout();
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        placeOrder();
        
        System.out.println("Checkout Flow Complete");
    }

    public static void main(String[] args) {
        AmazonSearchTest test = new AmazonSearchTest();
        test.navigateToURL();
        test.validatePageTitle();
        test.performSearch();
        test.selectFirstProduct();
        test.addToCart();
        
        test.checkoutCompleteFlow();
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.webdriver.quit();
    }
}