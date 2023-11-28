package S3_StgSettingsPositiveScenarios;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import GenericUtility.ExcelFileUtility;
import GenericUtility.PropertyFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class AccountUpdationExcelTest extends BaseClass {
	
	@Test(groups = "AccountUpdation" , priority = 1)
	public void accountUpdationTest() throws Exception
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String Name = eUtil.readDataFromExcel("Settings",1,6);
		String Mail = eUtil.readDataFromExcel("Settings",2,6);
		String PhNo = eUtil.readDataFromExcel("Settings",3,6);
		
		
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
		
		WebElement NameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
		NameEdt.clear();
		NameEdt.sendKeys(Name);
		
		WebElement EmailEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Your Email']"));
		EmailEdt.clear();
		EmailEdt.sendKeys(Mail);
		
		WebElement MobileNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Your Mobile Number']"));
		MobileNoEdt.clear();
		MobileNoEdt.sendKeys(PhNo);
		
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		
		try
		{
			WebElement SuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
			String successMsg = SuccessMsg.getText();
			System.out.println(successMsg);
		}
		catch(Exception e)
		{
			WebElement DangerMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
			String dangerMsg = DangerMsg.getText();
			System.out.println(dangerMsg);
			Assert.fail();
		}
		
	}
	
}
