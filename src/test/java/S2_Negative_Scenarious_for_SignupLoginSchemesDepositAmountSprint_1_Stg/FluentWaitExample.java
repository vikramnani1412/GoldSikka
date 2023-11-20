package S2_Negative_Scenarious_for_SignupLoginSchemesDepositAmountSprint_1_Stg;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitExample {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

        // Navigate to the desired URL
        driver.get("https://example.com");

        // Create a FluentWait instance
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                // Set the maximum amount of time to wait for the condition
                .withTimeout(Duration.ofSeconds(30))
                // Set the polling interval
                .pollingEvery(Duration.ofSeconds(2))
                // Ignore specific exceptions during polling
                .ignoring(NoSuchElementException.class);

        // Use the until() method along with ExpectedConditions to wait for a specific condition
        WebElement element = fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.id("exampleElementId")));

        // Perform actions on the element once it's found
        element.click();

        // Close the browser
        driver.quit();
        
	}
}
