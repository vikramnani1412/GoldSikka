package S3_StgSettingsPositiveScenarios;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class AccountUpdationExcelTest extends BaseClass {
	
	@Test(groups = "AccountUpdation" , priority = 1)
	public void accountUpdationTest() throws Exception 
	{
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String Name = eUtil.readDataFromExcel("Settings",1,6);
		String Mail = eUtil.readDataFromExcel("Settings",2,6);
		String PhNo = eUtil.readDataFromExcel("Settings",3,6);
		 
		for(;;)
		{
			Thread.sleep(3000);
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
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.=' Account']")).click();
		
		Thread.sleep(3000);
		WebElement NameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
		NameEdt.clear();
		NameEdt.sendKeys(Name+jUtil.getRandomNum());
		
		Thread.sleep(3000);
		WebElement EmailEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Your Email']"));
		EmailEdt.clear();
		EmailEdt.sendKeys(Mail);
		
		Thread.sleep(3000);WebElement MobileNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Your Mobile Number']"));
		MobileNoEdt.clear();
		MobileNoEdt.sendKeys(PhNo);
		
		Thread.sleep(3000);
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
		Thread.sleep(3000);
	}
	
}
