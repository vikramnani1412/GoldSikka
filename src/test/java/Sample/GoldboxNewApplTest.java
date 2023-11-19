package Sample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoldboxNewApplTest {

	@Test
	public void testing()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://stg.goldbox.gold/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter Your Mobile Number']")).sendKeys("9100345025", Keys.ENTER);
	}
}
