package FlipkartDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class OrangeHrm {

	@Test
	public void drpdwn() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		Thread.sleep(2000);
		d.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin",Keys.TAB,"admin123",Keys.ENTER);
		Thread.sleep(2000);
		d.findElement(By.xpath("//span[.='Leave']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//span[.='Cancelled']")).click();
		d.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//span[.='CAN - FMLA']")).click();
		
		
	}
}
