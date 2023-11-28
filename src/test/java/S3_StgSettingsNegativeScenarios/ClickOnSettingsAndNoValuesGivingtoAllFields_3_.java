package S3_StgSettingsNegativeScenarios;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class ClickOnSettingsAndNoValuesGivingtoAllFields_3_ extends BaseClass {

	@Test(groups = "SettingsNegative1", priority = 3)                           // click On Settings And No Values Giving to All Fields
	public void clickOnSettingsAndNoValuesGivingtoAllFields () throws Exception {
	
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
	
	driver.findElement(By.xpath("//a[.=' Account']")).click();
	
	Thread.sleep(3000);
			
	WebElement name = driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
	name.clear();
	name.sendKeys(" ");
	Thread.sleep(2000);
	
	WebElement email = driver.findElement(By.xpath("//input[@placeholder='Enter Your Email']"));
	email.clear();
	email.sendKeys(" ");
	Thread.sleep(2000);
	
	WebElement PhoneNo = driver.findElement(By.xpath("//input[@placeholder='Enter Your Mobile Number']"));
	PhoneNo.clear();
	PhoneNo.sendKeys(" ");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[.='Submit']")).click();
    
	String SuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	System.out.println(SuccessMsg);
	
//	WebElement NameError = driver.findElement(By.xpath("//p[text()='Name']/../following-sibling::div[.='This field is required']"));
//	String NameErrorMsg = NameError.getText();
//	
//	WebElement EmailError = driver.findElement(By.xpath("//p[text()='Email']/../following-sibling::div/div[.='This field is required ']"));
//	String EmailErrorMsg = EmailError.getText();
//	
//	WebElement MobileError = driver.findElement(By.xpath("//p[text()='Mobile']/../following-sibling::div/div[.='This field is required ']"));
//	String MobileErrorMsg = MobileError.getText();
	
	
}
}
