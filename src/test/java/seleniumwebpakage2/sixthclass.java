package seleniumwebpakage2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sixthclass {

    public static void main(String[] args) {
        // Set the path for the ChromeDriver
       

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        
        try {
            // Open the Wikipedia main page
            driver.get("https://en.wikipedia.org/wiki/English_Wikipedia");

            // Click on the login link
            driver.findElement(By.id("pt-login-2")).click();

            // Enter username
            driver.findElement(By.id("wpName1")).sendKeys("Varshini1987");

            // Enter password
            driver.findElement(By.id("wpPassword1")).sendKeys("arrow@7501");

            // Click login button
            driver.findElement(By.id("wpLoginAttempt")).click();
            
            // Check for successful login by looking for a user-specific element
            try {
                WebElement userPageLink = driver.findElement(By.id("pt-userpage"));
                // If the element is found, login was successful
                System.out.println("Login Successful: User page link is visible.");
            } catch (Exception e) {
                // If the element is not found, login failed
                System.out.println("Login Failed: User page link not found.");
            }
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
