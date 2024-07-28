package seleniumwebpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class firsttest {

    public static void main(String[] args) {
    	WebDriver driver= new ChromeDriver();

    	driver.get("https://www.wikipedia.org/");
        WebElement englishLink = driver.findElement(By.id("js-link-box-en"));
        englishLink.click();
        
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
}
