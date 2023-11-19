package S3_StgSettingsNegativeScenarios;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.sym.Name;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.WebDriverUtility;
import freemarker.ext.jsp.TaglibFactory.ClearMetaInfTldSource;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class Settings_ErrorsTest extends BaseClass {

	   @Test(groups = "Settings", priority = 1)                           // Click on Ticket
	   public void clickOnTickets () throws Exception {
		
		for(;;)
		{
		try 
		{
			driver.findElement(By.xpath("//span[.='Tickets']")).click();
			break;
		}
		catch(Exception e)
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}}
		
		driver.findElement(By.xpath("//span[.='Tickets']")).click();
		
		WebElement Tickets = driver.findElement(By.xpath("//h3[.='Tickets']"));
		
		if(Tickets.isDisplayed())
		{
			Assert.fail();
		}
		
		
  }
		
	   
		@Test(groups = "Settings", priority = 2)                           // Click on Feed Back
		public void clickOnFeedback () throws Exception {
		
		for(;;)
		{
		try 
		{
			driver.findElement(By.xpath("//span[.='Feed Back']")).click();
			break;
		}
		catch(Exception e)
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}}
		
		driver.findElement(By.xpath("//span[.='Feed Back']")).click();
		
		WebElement createFeedbackBtn = driver.findElement(By.xpath("//button[.='Create Feedback']"));
		
		if(createFeedbackBtn.isDisplayed())
		{
			Assert.fail();
		}
		
		
	}
		
		@Test(groups = "Settings", priority = 3)                           // click On Settings And No Values Giving to All Fields
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
		
//		WebElement NameError = driver.findElement(By.xpath("//p[text()='Name']/../following-sibling::div[.='This field is required']"));
//		String NameErrorMsg = NameError.getText();
//		
//		WebElement EmailError = driver.findElement(By.xpath("//p[text()='Email']/../following-sibling::div/div[.='This field is required ']"));
//		String EmailErrorMsg = EmailError.getText();
//		
//		WebElement MobileError = driver.findElement(By.xpath("//p[text()='Mobile']/../following-sibling::div/div[.='This field is required ']"));
//		String MobileErrorMsg = MobileError.getText();
		
		
	}
		
		// click On Settings And Giving Invalid Details to Account All Fields--> 1
		
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
		
		@Test
		public void mobileNumberInvalidGivenText() throws Exception
		{
			ExcelFileUtility eUtil = new ExcelFileUtility();
			String Name = eUtil.readDataFromExcel("Settings", 40, 2);
			String Email = eUtil.readDataFromExcel("Settings", 41, 2);
			String MobileNo = eUtil.readDataFromExcel("Settings", 42, 2);
				
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
		
		  @Test                        //doubt from here not executing simply developing scripts
		  public void nameInvalidGivenText() throws Exception
		  {
			ExcelFileUtility eUtil = new ExcelFileUtility();
//			String Name = eUtil.readDataFromExcel("Settings", 40, 3);
			String Email = eUtil.readDataFromExcel("Settings", 41, 3);
			String MobileNo = eUtil.readDataFromExcel("Settings", 42, 3);
				
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
			name.sendKeys(Keys.TAB);
			Thread.sleep(2000);
			
//			Robot r = new Robot();
//			r.keyPress(KeyEvent.VK_CONTROL);
//			r.keyPress(KeyEvent.VK_A);
//			
//			r.keyRelease(KeyEvent.VK_CONTROL);
//			r.keyRelease(KeyEvent.VK_A);
//		    
//			r.keyPress(KeyEvent.VK_DELETE);
//			r.keyRelease(KeyEvent.VK_DELETE);
			
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
		
		  
		  @Test                        //doubt from here not executing simply developing scripts
		  public void mobileNumNotGivenText() throws Exception
		  {
			ExcelFileUtility eUtil = new ExcelFileUtility();
			String Name = eUtil.readDataFromExcel("Settings", 40, 4);
			String Email = eUtil.readDataFromExcel("Settings", 41, 4);
//			String MobileNo = eUtil.readDataFromExcel("Settings", 42, 4);
				
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
	
	
	
	





//try {
//	if(NameError.isDisplayed())
//	{
//		System.out.println(Input1);
//		Assert.fail();
//	}
//} catch (Exception e) {
//	Thread.sleep(1000);
//}
//try {
//	if (EmailError.isDisplayed()) 
//	{
//		System.out.println(Input2);
//		Assert.fail();
//	}
//} catch (Exception e) {
//	Thread.sleep(1000);
//}
//try {
//	if (MobileError.isDisplayed()) 
//	{
//		System.out.println(Input3);
//		Assert.fail();
//	}
//} catch (Exception e) {
//	Thread.sleep(1000);
//}
//try {
//	if (InvalidDetailsError.isDisplayed()); 
//	{
//		System.out.println(Input4);
//		Assert.fail();
//	}
//} catch (Exception e) {
//	Thread.sleep(1000);
//}





















//if(NameErrorMsg.contains("required"))
//{
//	Assert.fail();
//}
//else if (EmailErrorMsg.contains("required")) 
//{
//	Assert.fail();
//}
//else if (MobileErrorMsg.contains("required")) 
//{
//	Assert.fail();
//}
//
////try
////{
////	WebElement NameError = driver.findElement(By.xpath("//p[text()='Name']/../following-sibling::div[.='This field is required']"));
////	String NameErrorMsg = NameError.getText();
////	
////	WebElement EmailError = driver.findElement(By.xpath("//p[text()='Email']/../following-sibling::div/div[.='This field is required ']"));
////	String EmailErrorMsg = EmailError.getText();
////	
////	WebElement MobileError = driver.findElement(By.xpath("//p[text()='Mobile']/../following-sibling::div/div[.='This field is required ']"));
////	String MobileErrorMsg = MobileError.getText();
////	
////	if(NameErrorMsg.contains("required"))
////	{
////		Assert.fail();
////	}
////	else if (EmailErrorMsg.contains("required")) 
////	{
////		Assert.fail();
////	}
////	else if (MobileErrorMsg.contains("required")) 
////	{
////		Assert.fail();
////	}
////}
////catch(Exception e)
////{
////	Thread.sleep(1);
////}