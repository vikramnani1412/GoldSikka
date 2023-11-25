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
public class ClickOnSettingsAndGivingInvalidDetailstoAllFields_4_ extends BaseClass {

	@Test(groups = "Setting", priority = 4)                
	public void clickOnSettingsAndGivingInvalidDetailstoAllFields () throws Exception {
	
	ExcelFileUtility eUtil = new ExcelFileUtility();
	String Name = eUtil.readDataFromExcel("Settings", 40, 1);
	String Email = eUtil.readDataFromExcel("Settings", 41, 1);
	String MobileNo = eUtil.readDataFromExcel("Settings", 42, 1);
		
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
	PhoneNo.sendKeys(MobileNo);
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[.='Submit']")).click();
    
	String SuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	System.out.println(SuccessMsg);
	
	
}
	
}
