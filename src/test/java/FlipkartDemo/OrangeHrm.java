package FlipkartDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class OrangeHrm {

	@Test
	public void drpdwn()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		d.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin",Keys.TAB,"admin123",Keys.ENTER);
	}
}
