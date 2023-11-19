package S3_StgSettingsPositiveScenarios;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.PropertyFileUtility;
import ObjectRepository.DashboardPage;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class AccountUpdation1Test extends BaseClass{

	@Test(groups = "Account Updation" , priority = 1)
	public void accountUpdationTest() throws Exception
	{
		for(;;)
		{
		try 
		{
			driver.findElement(By.xpath("//span[.='Settings']")).click();
			break;
		}
		catch(Exception e)
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}}
		
		driver.findElement(By.xpath("//a[.=' Account']")).click();
		WebElement name = driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
		name.clear();
		name.sendKeys("Pavani");
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='Enter Your Email']"));
		email.clear();
		email.sendKeys("pavanikaka2.com");
		WebElement PhoneNo = driver.findElement(By.xpath("//input[@placeholder='Enter Your Mobile Number']"));
		PhoneNo.clear();
		PhoneNo.sendKeys("9100345025");
		driver.findElement(By.xpath("//button[.='Submit']")).click();
	    
		try
		{
			String SuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
			System.out.println(SuccessMsg);
		}
		catch(Exception e)
		{
			String DeleteMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
			System.out.println(DeleteMsg);
			Assert.fail();
		}
		
		
	}
}
