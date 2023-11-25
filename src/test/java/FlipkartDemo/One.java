package FlipkartDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class One {

	@Test
	public void abc()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//span[.='✕']")).click();
		
		driver.findElement(By.name("q")).sendKeys("iphone 15 pro max",Keys.ENTER);
		
		List<WebElement> productName = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		
		List<WebElement> productPrice = driver.findElements(By.xpath("//div[@class='_4rR01T']/../following-sibling::div/div[contains(.,'₹')]"));
		
		for(int i=1;i<productName.size()-1;i++)
		{
			System.out.println(productName.get(i).getText()+"--------->"+productPrice.get(i).getText());
		}
	}
}
