package seleniumwebpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class alltest {

    public static void main(String[] args) {
        // Set the path for the ChromeDriver
        

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            testLanguageSelection(driver);
            testLoginFunctionality(driver);
            testPageTitle(driver);
            testSearchFunctionality(driver);
            testFeaturedArticleLink(driver);
            testlinknavigation(driver);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    public static void testLanguageSelection(WebDriver driver) throws InterruptedException {
        driver.get("https://www.wikipedia.org/");
        Thread.sleep(2000); // Pause for 2 seconds
        WebElement englishLink = driver.findElement(By.id("js-link-box-en"));
        englishLink.click();
        Thread.sleep(2000); // Pause for 2 seconds

        String expectedUrl = "https://en.wikipedia.org/wiki/Main_Page";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)) {
            System.out.println("Test Passed: Language selection works as expected.");
        } else {
            System.out.println("Test Failed: Language selection did not work as expected.");
            System.out.println("Expected URL: " + expectedUrl);
            System.out.println("Actual URL: " + actualUrl);
        }
    }

    public static void testLoginFunctionality(WebDriver driver) throws InterruptedException {
        driver.get("https://en.wikipedia.org/wiki/English_Wikipedia");
        Thread.sleep(2000); // Pause for 2 seconds
        driver.findElement(By.id("pt-login-2")).click();
        Thread.sleep(2000); // Pause for 2 seconds
        driver.findElement(By.id("wpName1")).sendKeys("Varshini1987");
        Thread.sleep(2000); // Pause for 2 seconds
        driver.findElement(By.id("wpPassword1")).sendKeys("arrow@7501");
        Thread.sleep(2000); // Pause for 2 seconds
        driver.findElement(By.id("wpLoginAttempt")).click();
        Thread.sleep(2000); // Pause for 2 seconds

        try {
            WebElement userPageLink = driver.findElement(By.id("pt-userpage"));
            System.out.println("Login Successful: User page link is visible.");
        } catch (Exception e) {
            System.out.println("Login Failed: User page link not found.");
        }
    }

    public static void testPageTitle(WebDriver driver) throws InterruptedException {
        driver.get("https://www.wikipedia.org/");
        Thread.sleep(2000); // Pause for 2 seconds
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        if (pageTitle.equals("Wikipedia")) {
            System.out.println("Title verification passed!");
        } else {
            System.out.println("Title verification failed!");
        }
    }

    public static void testSearchFunctionality(WebDriver driver) throws InterruptedException {
        driver.get("https://www.wikipedia.org/");
        Thread.sleep(2000); // Pause for 2 seconds
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("Selenium (software)");
        Thread.sleep(2000); // Pause for 2 seconds
        searchBox.submit();
        Thread.sleep(2000); // Pause for 2 seconds

        String expectedTitle = "Selenium (software) - Wikipedia";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Test Passed: Search functionality works as expected.");
        } else {
            System.out.println("Test Failed: Search functionality did not work as expected.");
            System.out.println("Expected Title: " + expectedTitle);
            System.out.println("Actual Title: " + actualTitle);
        }
    }

    public static void testFeaturedArticleLink(WebDriver driver) throws InterruptedException {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        Thread.sleep(2000); // Pause for 2 seconds
        WebElement featuredArticleLink = driver.findElement(By.cssSelector("#mp-tfa a"));
        String expectedUrl = featuredArticleLink.getAttribute("href");
        Thread.sleep(2000); // Pause for 2 seconds
        featuredArticleLink.click();
        Thread.sleep(2000); // Pause for 2 seconds

        String actualUrl = driver.getCurrentUrl();

        // Remove fragment identifiers for comparison
        String normalizedExpectedUrl = expectedUrl.split("#")[0];
        String normalizedActualUrl = actualUrl.split("#")[0];

        if (normalizedExpectedUrl.equals(normalizedActualUrl)) {
            System.out.println("Test Passed: Featured article link works as expected.");
        } else {
            System.out.println("Test Failed: Featured article link did not work as expected.");
            System.out.println("Expected URL: " + normalizedExpectedUrl);
            System.out.println("Actual URL: " + normalizedActualUrl);
        }
    }
    public static void testlinknavigation(WebDriver driver)throws InterruptedException {
		// TODO Auto-generated method stub
		    driver.get("https://en.wikipedia.org/wiki/Main_Page");
		    Thread.sleep(2000); 
		     driver.findElement(By.id("ca-viewsource")).click();
		     Thread.sleep(2000); 
		     String expectedUrl = "https://en.wikipedia.org/w/index.php?title=Main_Page&action=edit";
		        String actualUrl = driver.getCurrentUrl();
		        
		        if (expectedUrl.equals(actualUrl)) {
		            System.out.println("Test Passed: Link selection worked as expected");
		        } else {
		            System.out.println("Test Failed: Link selection did not work as expected.");
		            System.out.println("Expected URL: " + expectedUrl);
		            System.out.println("Actual URL: " + actualUrl);
		        }
		}
}
