package seleniumwebpakage2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class shikhatest {
    public static void main(String[] args) {
        // Set path to the WebDriver executable
        
        WebDriver driver = new ChromeDriver();
        
        // Open the Ammas Pastries website
        driver.get("https://ammaspastries.in/");

        // Test Case 1: Verify that the title is as expected
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        if (pageTitle.equals("Ammas Pastries – We Care For Your Good Taste…!")) {
            System.out.println("Title verification passed!");
        } else {
            System.out.println("Title verification failed!");
        }

        // Test Case 2: Check if the main menu is displayed
        WebElement mainMenu = driver.findElement(By.id("main-menu"));
        if (mainMenu.isDisplayed()) {
            System.out.println("Test Case 2 Passed: Main menu is displayed.");
        } else {
            System.out.println("Test Case 2 Failed: Main menu is not displayed.");
        }

        // Test Case 3: Verify the search functionality
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("cake");
        searchBox.submit();
        WebElement searchResult = driver.findElement(By.className("search-results"));
        if (searchResult.isDisplayed()) {
            System.out.println("Test Case 3 Passed: Search functionality works.");
        } else {
            System.out.println("Test Case 3 Failed: Search functionality does not work.");
        }

        // Test Case 4: Ensure that the specific product category page (Exotic Fruitz) can be accessed
        driver.get("https://ammaspastries.in/product-category/cakes/exotic-fruitz/feed/");
        String categoryPageTitle = driver.getTitle();
        if (categoryPageTitle.contains("Exotic Fruitz")) {
            System.out.println("Test Case 4 Passed: Exotic Fruitz category page can be accessed.");
        } else {
            System.out.println("Test Case 4 Failed: Could not access Exotic Fruitz category page.");
        }

        // Test Case 5: Open the chat bot
        WebElement chatBotIframe = driver.findElement(By.id("tidio-chat-iframe"));
        if (chatBotIframe.isDisplayed()) {
            System.out.println("Test Case 5 Passed: Chat bot iframe is displayed.");
        } else {
            System.out.println("Test Case 5 Failed: Chat bot iframe is not displayed.");
        }

        // Close the browser
        driver.quit();
    }
}