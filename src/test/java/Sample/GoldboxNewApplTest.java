package Sample;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class GoldboxNewApplTest {

	@Test
	public void testing() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://stg.goldbox.gold/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter Mobile Number']")).sendKeys("9100345025", Keys.ENTER);
		
		Thread.sleep(2000);
		
		Robot r = new Robot();
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_T);
 		
		driver.findElement(By.xpath("//input[@placeholder='Search Google or type a URL']")).sendKeys("URL");
		
	    
	}
}

//for(int i=1;i<=8;i++)
//{
//	Thread.sleep(1000);
//	r.keyPress(KeyEvent.VK_TAB);
//	r.keyRelease(KeyEvent.VK_TAB);
//}