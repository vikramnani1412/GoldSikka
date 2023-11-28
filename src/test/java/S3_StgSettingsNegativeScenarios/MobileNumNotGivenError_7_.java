package S3_StgSettingsNegativeScenarios;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class MobileNumNotGivenError_7_ extends BaseClass {

	@Test(groups = "SettingsNegative1", priority = 7)                        //doubt from here not executing simply developing scripts
	  public void mobileNumNotGivenText() throws Exception
	  {
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String Name = eUtil.readDataFromExcel("Settings", 40, 4);
		String Email = eUtil.readDataFromExcel("Settings", 41, 4);
//		String MobileNo = eUtil.readDataFromExcel("Settings", 42, 4);
			
		driver.findElement(By.xpath("//span[.='Schemes']")).click();
		
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
		
		driver.findElement(By.xpath("//span[.='Settings']")).click();
		
		driver.findElement(By.xpath("//a[.=' Account']"));
		
		Thread.sleep(3000);
		
		WebElement name = driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
		name.clear();
		name.sendKeys(Name);
		Thread.sleep(2000);
		
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='Enter Your Email']"));
		email.clear();
		email.sendKeys(Email);
		Thread.sleep(2000);
		
		WebElement PhoneNo = driver.findElement(By.xpath("//input[@placeholder='Enter Your Mobile Number']"));
		PhoneNo.clear();
		PhoneNo.sendKeys("0");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[.='Submit']")).click();
	    
		String SuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		System.out.println(SuccessMsg);
	}
	
}
