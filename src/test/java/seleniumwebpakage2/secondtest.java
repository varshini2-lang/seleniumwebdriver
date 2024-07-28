package seleniumwebpakage2;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class secondtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
	
		
		    driver.get("https://en.wikipedia.org/wiki/Main_Page");
		    WebElement featuredArticleLink = driver.findElement(By.cssSelector("#mp-tfa a"));
		    String expectedUrl = featuredArticleLink.getAttribute("href");
		    featuredArticleLink.click();
		    
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

		}

		


	

