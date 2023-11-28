package S3_StgSettingsNegativeScenarios;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.border.TitledBorder;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.sym.Name;
import com.google.common.annotations.VisibleForTesting;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;
import freemarker.ext.jsp.TaglibFactory.ClearMetaInfTldSource;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class All_Settings_Errors_Test extends BaseClass {

	   @Test(groups = "SettingsNegative1", priority = 1)          // Click on Ticket Lnk checking settings is opening r not
	   public void clickOnTicketsLnkGetSettingsPageErrorTest () throws Exception {
		
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
		
		try {
			if(Tickets.isDisplayed())
			{
				Assert.fail();
			}
		} catch (Exception e) {
			Thread.sleep(2000);
		}
		
		
		
		
  }
		
	   
		@Test(groups = "SettingsNegative1", priority = 2)            // Click on FeedBack Lnk checking settings is opening r not
		public void clickOnFeedbackLnkGetSettingsPageErrorTest () throws Exception {
		
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
		
		try {
			if(createFeedbackBtn.isDisplayed())
			{
				Assert.fail();
			}
		} catch (Exception e) {
			Thread.sleep(1000);
		}
		
		
		
	}
		
		@Test(groups = "SettingsNegative1", priority = 3)              // click On Settings And Giving Null Values Giving to All Fields
		public void clickOnSettingsAndNoValuesGivingtoAllFieldsErrorTest () throws Exception {
		
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
		
        
		@Test(groups = "SettingsNegative1", priority = 4)     // click On Settings And Giving Invalid Details to Account All Fields--> 1
		public void clickOnSettingsAndGivingInvalidDetailstoAllFieldsErrorTest () throws Exception {
		
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
		
		@Test(groups = "SettingsNegative1", priority = 5)    //Giving invalid Mobile no error
		public void mobileNumberInvalidGivenErrorErrorTest() throws Exception
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
		
		  @Test(groups = "SettingsNegative1", priority = 6)    // Name not given error
		  public void nameNotGivenErrorErrorTest() throws Exception
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
		
		  
		  @Test(groups = "SettingsNegative1", priority = 7)      // 0 Given as mobile num error
		  public void mobileNumGiven0ErrorTest() throws Exception
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
		  
		  
		  @Test(groups = "SettingsNegative1", priority = 8)         // Email Not Given Error
		  public void emailNotGivenTextErrorTest() throws Exception
		  {
			JavaUtility jUtil = new JavaUtility();
			ExcelFileUtility eUtil = new ExcelFileUtility();
			String Name = eUtil.readDataFromExcel("Settings", 40, 5);
//			String Email = eUtil.readDataFromExcel("Settings", 41, 4);
			String MobileNo = eUtil.readDataFromExcel("Settings", 42, 5);
				
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
			email.sendKeys("");
			Thread.sleep(2000);
			
			WebElement PhoneNo = driver.findElement(By.xpath("//input[@placeholder='Enter Your Mobile Number']"));
			PhoneNo.clear();
			PhoneNo.sendKeys(MobileNo+jUtil.getRandomNum());
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[.='Submit']")).click();
		    
			String SuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
			System.out.println(SuccessMsg);
			
			
		}
		  
		  
		  @Test(groups = "SettingsNegative1", priority = 9)                  //Without giving kyc details click on submit error
		  public void clearAllKYCFeildDetailsClickOnSubmitErrorTest() throws InterruptedException, AWTException
		  {
			  
			  
			  Thread.sleep(3000);
			  
			  driver.findElement(By.xpath("//span[.='Settings']")).click();
			  
			  Thread.sleep(3000);
			  
			  driver.findElement(By.xpath("//a[@routerlink='/settings/kyc']")).click();
			  
			  Thread.sleep(3000);
			  
			  driver.findElement(By.xpath("//button[.=' Update Kyc ']")).click();
			  
			  Thread.sleep(3000);
			  
			  driver.findElement(By.xpath("//input[@placeholder='Enter Father Name']")).clear();
			  
			  Thread.sleep(3000);
			  
	          Robot r = new Robot();
	          
	          r.keyPress(KeyEvent.VK_TAB);
	          r.keyRelease(KeyEvent.VK_TAB);
	          
	          r.keyPress(KeyEvent.VK_DELETE);
	          r.keyRelease(KeyEvent.VK_DELETE);
	          
	          Thread.sleep(3000);
	          
	          r.keyPress(KeyEvent.VK_TAB);
	          r.keyRelease(KeyEvent.VK_TAB);
	          
	          r.keyPress(KeyEvent.VK_DELETE);
	          r.keyRelease(KeyEvent.VK_DELETE);
			  
	          Thread.sleep(3000);
	          
	          r.keyPress(KeyEvent.VK_TAB);
	          r.keyRelease(KeyEvent.VK_TAB);
	          
	          r.keyPress(KeyEvent.VK_DELETE);
	          r.keyRelease(KeyEvent.VK_DELETE);
	          
	          Thread.sleep(3000);
	          
	          r.keyPress(KeyEvent.VK_TAB);
	          r.keyRelease(KeyEvent.VK_TAB);
	          
	          r.keyPress(KeyEvent.VK_DELETE);
	          r.keyRelease(KeyEvent.VK_DELETE);
			  
	          Thread.sleep(3000);
	          
	          driver.findElement(By.xpath("//input[@value='M']")).click();
	          
	          Thread.sleep(3000);
	          
	          driver.findElement(By.xpath("//button[.='Submit']")).click();
	          
	          driver.findElement(By.xpath("abc")).click();
	         
	          
		  }
		  
		  @Test(groups = "SettingsNegative1", priority = 10)           // Giving only father name while adding kyc and click on submit
		  public void enterOnlyFatherNameAndClickOnSubmitOfKYCModuleErrorTest () throws Exception
		  {
			  
			  Thread.sleep(3000);
			  
			  driver.findElement(By.xpath("//span[.='Settings']")).click();
			  
			  Thread.sleep(3000);
			  
			  driver.findElement(By.xpath("//a[@routerlink='/settings/kyc']")).click();
			  
			  Thread.sleep(3000);
			  
			  driver.findElement(By.xpath("//button[.=' Update Kyc ']")).click();
			  
			  Thread.sleep(3000);
			  
			  driver.findElement(By.xpath("//input[@placeholder='Enter Father Name']")).click();
			  
              Robot r = new Robot();
	          
	          r.keyPress(KeyEvent.VK_TAB);
	          r.keyRelease(KeyEvent.VK_TAB);
	          
	          r.keyPress(KeyEvent.VK_DELETE);
	          r.keyRelease(KeyEvent.VK_DELETE);
	          
	          Thread.sleep(3000);
	          
	          r.keyPress(KeyEvent.VK_TAB);
	          r.keyRelease(KeyEvent.VK_TAB);
	          
	          r.keyPress(KeyEvent.VK_DELETE);
	          r.keyRelease(KeyEvent.VK_DELETE);
			  
	          Thread.sleep(3000);
	          
	          r.keyPress(KeyEvent.VK_TAB);
	          r.keyRelease(KeyEvent.VK_TAB);
	          
	          r.keyPress(KeyEvent.VK_DELETE);
	          r.keyRelease(KeyEvent.VK_DELETE);
	          
	          Thread.sleep(3000);
	          
	          r.keyPress(KeyEvent.VK_TAB);
	          r.keyRelease(KeyEvent.VK_TAB);
	          
	          r.keyPress(KeyEvent.VK_DELETE);
	          r.keyRelease(KeyEvent.VK_DELETE);
			  
	          Thread.sleep(3000);
	          
	          driver.findElement(By.xpath("//input[@value='M']")).click();
	          
	          Thread.sleep(3000);
	          
	          driver.findElement(By.xpath("//button[.='Submit']")).click();
	          
	          driver.findElement(By.xpath("abc")).click();
			  
		  }
		  
		  
		  
		  @Test(groups = "SettingsNegative2", priority = 11)        // Entering Invalid Data In All Kyc Feilds and click on submit
		  public void enteringInvalidDataInAllKycFeildsErrorTest()throws Exception
		  {
			ExcelFileUtility eUtil = new ExcelFileUtility();
			String FatherName = eUtil.readDataFromExcel("Settings", 46, 1);
			String SpouseName = eUtil.readDataFromExcel("Settings", 47, 1);
			String AlternatePhNo = eUtil.readDataFromExcel("Settings", 48, 1);
			String PanNo = eUtil.readDataFromExcel("Settings", 49, 1);
			String AadhaarNo = eUtil.readDataFromExcel("Settings", 50, 1);
				
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
			
			driver.findElement(By.xpath("//a[@href='/settings/kyc']")).click();
			
			Thread.sleep(3000);
						
			driver.findElement(By.xpath("//button[.=' Update Kyc ']")).click();
			
			Thread.sleep(3000);
			
			WebElement FathernameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Father Name']"));
			FathernameEdt.clear();
			FathernameEdt.sendKeys(FatherName);
			Thread.sleep(2000);
						
			WebElement SpouseNameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Spouse Name']"));
			SpouseNameEdt.clear();
			SpouseNameEdt.sendKeys(SpouseName);
			Thread.sleep(2000);
			
			WebElement AltPhoneNo = driver.findElement(By.xpath("//input[@placeholder='Enter Alternate Phone No']"));
			AltPhoneNo.clear();
			AltPhoneNo.sendKeys(AlternatePhNo);
			Thread.sleep(2000);
			
			WebElement PanNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter PAN No']"));
			PanNoEdt.clear();
			PanNoEdt.sendKeys(PanNo);
			Thread.sleep(2000);
			
			WebElement AadharNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Aadhaar No']"));
			AadharNoEdt.clear();
			AadharNoEdt.sendKeys(AadhaarNo);
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@value='M']")).click();
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[.='Submit']")).click();
			
			Thread.sleep(3000);
		    
			String SuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
			System.out.println(SuccessMsg);
			
			
		}
		  
		  
		  
		  @Test(groups = "SettingsNegative2", priority = 12)          // Without Giving Any Details in Nominee Module Click On Submit
		  public void nomineeWithoutGivingAnyDetailsClickOnSubmitErrorTest() throws Exception
		  {
			  
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
				
			   driver.findElement(By.xpath("//a[.=' Nominee Details ']")).click();
				
			   Thread.sleep(3000);
				
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
				
			   driver.findElement(By.xpath("//button[.='Submit']")).click();
				
			   driver.findElement(By.xpath("abc")).click();
				
				
				
		  }
		  
		  
		  @Test(groups = "SettingsNegative2", priority = 13)      //Giving only name while adding nominee details and click on submit
		  public void nomineeGivingOnlyNameDetailsClickOnSubmitErrorTest() throws Exception
		  {
			  ExcelFileUtility eUtil = new ExcelFileUtility();
			  String Name = eUtil.readDataFromExcel("Settings", 54, 1);
			  
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
				
			   driver.findElement(By.xpath("//a[.=' Nominee Details ']")).click();
				
			   Thread.sleep(3000);
				
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys(Name);
			   
			   driver.findElement(By.xpath("//button[.='Submit']")).click();
				
			   driver.findElement(By.xpath("abc")).click();
					
				
		  }
		  
		  
		  // Giving Only Name And PhNo Details While Adding Nominee And Click On Submit Error
		  
		  @Test(groups = "SettingsNegative2", priority = 14)      
		  public void nomineeGivingOnlyNameAndPhNoDetailsClickOnSubmitErrorTest() throws Exception
		  {
			  ExcelFileUtility eUtil = new ExcelFileUtility();
			  String Name = eUtil.readDataFromExcel("Settings", 54, 1);
			  String PhoneNo = eUtil.readDataFromExcel("Settings", 55, 1);
			  
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
				
			   driver.findElement(By.xpath("//a[.=' Nominee Details ']")).click();
				
			   Thread.sleep(3000);
				
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys(Name);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Number']")).sendKeys(PhoneNo);
			   
			   driver.findElement(By.xpath("//button[.='Submit']")).click();
				
			   driver.findElement(By.xpath("abc")).click();
					
				
		  }
		  
		  
	      // Giving Only Name , PhNo and Address Details While Adding Nominee And Click On Submit Error
		  
		  @Test(groups = "SettingsNegative2", priority = 15)
		  public void nomineeGivingOnlyNamePhNoAddressDetailsClickOnSubmitErrorTest () throws Exception
		  {
			  ExcelFileUtility eUtil = new ExcelFileUtility();
			  String Name = eUtil.readDataFromExcel("Settings", 54, 1);
			  String PhoneNo = eUtil.readDataFromExcel("Settings", 55, 1);
			  String Address = eUtil.readDataFromExcel("Settings", 56, 1);
			  
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
				
			   driver.findElement(By.xpath("//a[.=' Nominee Details ']")).click();
				
			   Thread.sleep(3000);
				
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys(Name);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Number']")).sendKeys(PhoneNo);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Address']")).sendKeys(Address);
			   
			   driver.findElement(By.xpath("//button[.='Submit']")).click();
				
			   driver.findElement(By.xpath("abc")).click();
					
				
		  }
		  
		  
		  // Giving Only Name , PhNo , Address And City Details While Adding Nominee And Click On Submit Error
		  
		  @Test(groups = "SettingsNegative2", priority = 16)
		  public void nomineeGivingOnlyNamePhNoAddressCityDetailsClickOnSubmitErrorTest () throws Exception
		  {
			  ExcelFileUtility eUtil = new ExcelFileUtility();
			  String Name = eUtil.readDataFromExcel("Settings", 54, 1);
			  String PhoneNo = eUtil.readDataFromExcel("Settings", 55, 1);
			  String Address = eUtil.readDataFromExcel("Settings", 56, 1);
			  String City = eUtil.readDataFromExcel("Settings", 57, 1);
			  
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
				
			   driver.findElement(By.xpath("//a[.=' Nominee Details ']")).click();
				
			   Thread.sleep(3000);
				
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys(Name);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Number']")).sendKeys(PhoneNo);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Address']")).sendKeys(Address);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter City']")).sendKeys(City);
			   
			   driver.findElement(By.xpath("//button[.='Submit']")).click();
				
			   driver.findElement(By.xpath("abc")).click();
					
				
		  }
		  
		  
		  // Giving Only Name , PhNo , Address , City and State Details While Adding Nominee And Click On Submit Error
		  
		  @Test(groups = "SettingsNegative2", priority = 17)
		  public void nomineeGivingOnlyNamePhNoAddressCityStateDetailsClickOnSubmitErrorTest () throws Exception
		  {
			  ExcelFileUtility eUtil = new ExcelFileUtility();
			  String Name = eUtil.readDataFromExcel("Settings", 54, 1);
			  String PhoneNo = eUtil.readDataFromExcel("Settings", 55, 1);
			  String Address = eUtil.readDataFromExcel("Settings", 56, 1);
			  String City = eUtil.readDataFromExcel("Settings", 57, 1);
			  String State = eUtil.readDataFromExcel("Settings", 58, 1);			  
			  
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
				
			   driver.findElement(By.xpath("//a[.=' Nominee Details ']")).click();
				
			   Thread.sleep(3000);
				
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys(Name);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Number']")).sendKeys(PhoneNo);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Address']")).sendKeys(Address);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter City']")).sendKeys(City);
			   
			   Thread.sleep(3000);
			   
			   WebElement state = driver.findElement(By.xpath("//select[@formcontrolname='state_id']"));
			   
			   Select s = new Select(state);
			   s.selectByVisibleText(State);
			   
			   Thread.sleep(3000);
			   
			   driver.findElement(By.xpath("//button[.='Submit']")).click();
				
			   driver.findElement(By.xpath("abc")).click();
					
				
		  }
		  
		  
		  // Giving Only Name , PhNo , Address , City , State and Country Details While Adding Nominee And Click On Submit Error
		  
		  @Test(groups = "SettingsNegative2", priority = 18)
		  public void nomineeGivingOnlyNamePhNoAddressCityStateCountryDetailsClickOnSubmitErrorTest () throws Exception
		  {
			  ExcelFileUtility eUtil = new ExcelFileUtility();
			  String Name = eUtil.readDataFromExcel("Settings", 54, 1);
			  String PhoneNo = eUtil.readDataFromExcel("Settings", 55, 1);
			  String Address = eUtil.readDataFromExcel("Settings", 56, 1);
			  String City = eUtil.readDataFromExcel("Settings", 57, 1);
			  String State = eUtil.readDataFromExcel("Settings", 58, 1);
			  String Country = eUtil.readDataFromExcel("Settings", 59, 1);
			  
			  
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
				
			   driver.findElement(By.xpath("//a[.=' Nominee Details ']")).click();
				
			   Thread.sleep(3000);
				
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys(Name);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Number']")).sendKeys(PhoneNo);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Address']")).sendKeys(Address);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter City']")).sendKeys(City);
			   
               Thread.sleep(3000);
			   
			   WebElement state = driver.findElement(By.xpath("//select[@formcontrolname='state_id']"));
			   
			   Select s = new Select(state);
			   s.selectByVisibleText(State);
			   
			   Thread.sleep(3000);
			   
			   WebElement country = driver.findElement(By.xpath("//select[@formcontrolname='country_id']"));
			   
			   Select ss = new Select(country);
			   ss.selectByVisibleText(Country);
			   
			   Thread.sleep(3000);
			   
			   driver.findElement(By.xpath("//button[.='Submit']")).click();
				
			   driver.findElement(By.xpath("abc")).click();
					
				
		  }
		  
		  
		  // Giving Only Name , PhNo , Address , City , State , Country And PinCode Details While Adding Nominee And Click On Submit Error
		  
		  @Test(groups = "SettingsNegative2", priority = 19)
		  public void nomineeGivingOnlyNamePhNoAddressCityStateCountryPincodeDetailsClickOnSubmitErrorTest () throws Exception
		  {
			  ExcelFileUtility eUtil = new ExcelFileUtility();
			  String Name = eUtil.readDataFromExcel("Settings", 54, 1);
			  String PhoneNo = eUtil.readDataFromExcel("Settings", 55, 1);
			  String Address = eUtil.readDataFromExcel("Settings", 56, 1);
			  String City = eUtil.readDataFromExcel("Settings", 57, 1);
			  String State = eUtil.readDataFromExcel("Settings", 58, 1);
			  String Country = eUtil.readDataFromExcel("Settings", 59, 1);
			  String Pincode = eUtil.readDataFromExcel("Settings", 60, 1);
			  
			  
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
				
			   driver.findElement(By.xpath("//a[.=' Nominee Details ']")).click();
				
			   Thread.sleep(3000);
				
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys(Name);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Number']")).sendKeys(PhoneNo);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Address']")).sendKeys(Address);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter City']")).sendKeys(City);
			   
               Thread.sleep(3000);
			   
			   WebElement state = driver.findElement(By.xpath("//select[@formcontrolname='state_id']"));
			   
			   Select s = new Select(state);
			   s.selectByVisibleText(State);
			   
			   Thread.sleep(3000);
			   
			   WebElement country = driver.findElement(By.xpath("//select[@formcontrolname='country_id']"));
			   
			   Select ss = new Select(country);
			   ss.selectByVisibleText(Country);
			   
			   Thread.sleep(3000);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Pincode']")).sendKeys(Pincode);
			 
			   driver.findElement(By.xpath("//button[.='Submit']")).click();
				
			   driver.findElement(By.xpath("abc")).click();
					
				
		  }
		  
		  
		// Giving Only Name , PhNo , Address , City , State , Country , PinCode And Relation Details While Adding Nominee And Click On Submit Error
		  
		  @Test(groups = "SettingsNegative2", priority = 20)                                                 // Passed Test Case
		  public void nomineeGivingOnlyNamePhNoAddressCityStateCountryPincodeRelationDetailsClickOnSubmitErrorTest () throws Exception
		  {
			  ExcelFileUtility eUtil = new ExcelFileUtility();
			  String Name = eUtil.readDataFromExcel("Settings", 54, 1);
			  String PhoneNo = eUtil.readDataFromExcel("Settings", 55, 1);
			  String Address = eUtil.readDataFromExcel("Settings", 56, 1);
			  String City = eUtil.readDataFromExcel("Settings", 57, 1);
			  String State = eUtil.readDataFromExcel("Settings", 58, 1);
			  String Country = eUtil.readDataFromExcel("Settings", 59, 1);
			  String Pincode = eUtil.readDataFromExcel("Settings", 60, 1);
			  String Relation = eUtil.readDataFromExcel("Settings", 61, 1);
			  
			  
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
				
			   driver.findElement(By.xpath("//a[.=' Nominee Details ']")).click();
				
			   Thread.sleep(3000);
				
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys(Name);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Number']")).sendKeys(PhoneNo);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Address']")).sendKeys(Address);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter City']")).sendKeys(City);
			   
               Thread.sleep(3000);
			   
			   WebElement state = driver.findElement(By.xpath("//select[@formcontrolname='state_id']"));
			   
			   Select s = new Select(state);
			   s.selectByVisibleText(State);
			   
			   Thread.sleep(3000);
			   
			   WebElement country = driver.findElement(By.xpath("//select[@formcontrolname='country_id']"));
			   
			   Select ss = new Select(country);
			   ss.selectByVisibleText(Country);
			   
			   Thread.sleep(3000);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Pincode']")).sendKeys(Pincode);
			   
			   WebElement relation = driver.findElement(By.xpath("//select[@formcontrolname='relation']"));
			   
			   Select sss = new Select(relation);
			   sss.selectByVisibleText(Relation);
			   
			   driver.findElement(By.xpath("//button[.='Submit']")).click();
			   
			   
			   
				
			   driver.findElement(By.xpath("abc")).click();
					
				
		  }
		  
		  
		  //Nominee deleting
		  
		  @Test(groups = "SettingsNegative3", priority = 21)
		  public void nomineeDeletionErrorTest () throws Exception
		  {
			  			  
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
				
			   driver.findElement(By.xpath("//a[.=' Nominee Details ']")).click();
				
			   Thread.sleep(3000);
				
			   driver.findElement(By.xpath("//i[@class='far fa-trash-alt']")).click();
			 
			   Thread.sleep(2000);
			   
			   driver.switchTo().alert().accept();
			   
			   String SuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
			 
			   System.out.println(SuccessMsg);
			   
			   driver.findElement(By.xpath("abc")).click();
					
				
		  }
		  
		  
		  // Giving Only Invalid Details While Adding Nominee And Click On Submit Error
		  
		  @Test(groups = "SettingsNegative3", priority = 22)    
		  public void nomineeGivingAllInvalidDetailsDetailsClickOnSubmitErrorTest () throws Exception
		  {
			  ExcelFileUtility eUtil = new ExcelFileUtility();
			  String Name = eUtil.readDataFromExcel("Settings", 54, 2);
			  String PhoneNo = eUtil.readDataFromExcel("Settings", 55, 2);
			  String Address = eUtil.readDataFromExcel("Settings", 56, 2);
			  String City = eUtil.readDataFromExcel("Settings", 57, 2);
			  String State = eUtil.readDataFromExcel("Settings", 58, 2);
			  String Country = eUtil.readDataFromExcel("Settings", 59, 2);
			  String Pincode = eUtil.readDataFromExcel("Settings", 60, 2);
			  String Relation = eUtil.readDataFromExcel("Settings", 61, 2);
			  
			  
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
				
			   driver.findElement(By.xpath("//a[.=' Nominee Details ']")).click();
				
			   Thread.sleep(3000);
				
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys(Name);
			   
			   Thread.sleep(3000);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Number']")).sendKeys(PhoneNo);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Address']")).sendKeys(Address);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter City']")).sendKeys(City);
			   
               Thread.sleep(3000);
			   
			   WebElement state = driver.findElement(By.xpath("//select[@formcontrolname='state_id']"));
			   
			   Select s = new Select(state);
			   s.selectByVisibleText(State);
			   
			   Thread.sleep(3000);
			   
			   WebElement country = driver.findElement(By.xpath("//select[@formcontrolname='country_id']"));
			   
			   Select ss = new Select(country);
			   ss.selectByVisibleText(Country);
			   
			   Thread.sleep(3000);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Pincode']")).sendKeys(Pincode);
			   
			   WebElement relation = driver.findElement(By.xpath("//select[@formcontrolname='relation']"));
			   
			   Select sss = new Select(relation);
			   sss.selectByVisibleText(Relation);
			   
			   driver.findElement(By.xpath("//button[.='Submit']")).click();
				
			   driver.findElement(By.xpath("abc")).click();
					
				
		  }
		  
		  
		// Without Giving Any Details While Adding Address And Click On Submit Error
		  
		  @Test(groups = "SettingsNegative3", priority = 23)
		  public void addressWithoutGivingDataInAnyFieldsErrorTest () throws Exception
		  {
			  
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
				
			   driver.findElement(By.xpath("//a[@href='/settings/addresses']")).click();
				
			   Thread.sleep(3000);
			 
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
			   
			   driver.findElement(By.xpath("//button[.='Submit']")).click();
			   
			   driver.findElement(By.xpath("abc")).click();
					
				
		  }
		  
		  
		 // Giving Only Title Details While Adding Address And Click On Submit Error
		  
		  @Test(groups = "SettingsNegative3", priority = 24)
		  public void addressGivingOnlyTitleFieldsErrorTest () throws Exception
		  {
			  
			  ExcelFileUtility eUtil = new ExcelFileUtility();
			  String Title = eUtil.readDataFromExcel("Settings", 65, 1);
			  
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
				
			   driver.findElement(By.xpath("//a[@href='/settings/addresses']")).click();
				
			   Thread.sleep(3000);
			 
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Title']")).sendKeys(Title);
			   
			   driver.findElement(By.xpath("//button[.='Submit']")).click();
			   
			   driver.findElement(By.xpath("abc")).click();
					
				
		  }
		  
		  
		  // Giving Only Title , City Details While Adding Address And Click On Submit Error
		  
		  @Test(groups = "SettingsNegative3", priority = 25)
		  public void addressGivingOnlyTitleCityFieldsErrorTest () throws Exception
		  {
			  ExcelFileUtility eUtil = new ExcelFileUtility();
			  String Title = eUtil.readDataFromExcel("Settings", 65, 1);
			  String City = eUtil.readDataFromExcel("Settings", 66, 1);
			  
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
				
			   driver.findElement(By.xpath("//a[@href='/settings/addresses']")).click();
				
			   Thread.sleep(3000);
			 
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Title']")).sendKeys(Title);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter City']")).sendKeys(City);
			   
			   driver.findElement(By.xpath("//button[.='Submit']")).click();
			   
			   driver.findElement(By.xpath("abc")).click();
					
				
		  }
		  
		  
		  // Giving Only Title , City , State Details While Adding Address And Click On Submit Error
		  
		  @Test(groups = "SettingsNegative3", priority = 26)
		  public void addressGivingOnlyTitleCityStateFieldsErrorTest () throws Exception
		  {
			  ExcelFileUtility eUtil = new ExcelFileUtility();
			  String Title = eUtil.readDataFromExcel("Settings", 65, 1);
			  String City = eUtil.readDataFromExcel("Settings", 66, 1);
			  String State = eUtil.readDataFromExcel("Settings", 67, 1);
			  
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
				
			   driver.findElement(By.xpath("//a[@href='/settings/addresses']")).click();
				
			   Thread.sleep(3000);
			 
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Title']")).sendKeys(Title);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter City']")).sendKeys(City);
			   
			   WebElement state = driver.findElement(By.xpath("//select[@formcontrolname='state_id']"));
			   
			   Select s = new Select(state);
			   s.selectByVisibleText(State);
			   
			   driver.findElement(By.xpath("//button[.='Submit']")).click();
			   
			   driver.findElement(By.xpath("abc")).click();
					
				
		  }
		  
		  
		// Giving Only Title , City , State , PinCode Details While Adding Address And Click On Submit Error
		  
		  @Test(groups = "SettingsNegative3", priority = 27)
		  public void addressGivingOnlyTitleCityStatePincodeFieldsErrorTest () throws Exception
		  {
			  ExcelFileUtility eUtil = new ExcelFileUtility();
			  String Title = eUtil.readDataFromExcel("Settings", 65, 1);
			  String City = eUtil.readDataFromExcel("Settings", 66, 1);
			  String State = eUtil.readDataFromExcel("Settings", 67, 1);
			  String Pincode = eUtil.readDataFromExcel("Settings", 68, 1);
			  
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
				
			   driver.findElement(By.xpath("//a[@href='/settings/addresses']")).click();
				
			   Thread.sleep(3000);
			 
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Title']")).sendKeys(Title);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter City']")).sendKeys(City);
			   
			   WebElement state = driver.findElement(By.xpath("//select[@formcontrolname='state_id']"));
			   
			   Select s = new Select(state);
			   s.selectByVisibleText(State);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Pincode']")).sendKeys(Pincode);
			   
			   driver.findElement(By.xpath("//button[.='Submit']")).click();
			   
			   driver.findElement(By.xpath("abc")).click();
					
				
		  }
		  
		  
		  // Giving Only Title , City , State , PinCode , Address Details While Adding Address And Click On Submit Error
		  
		  @Test(groups = "SettingsNegative3", priority = 28)
		  public void addressGivingOnlyTitleCityStatePincodeAddressFieldsErrorTest () throws Exception
		  {
			  ExcelFileUtility eUtil = new ExcelFileUtility();
			  String Title = eUtil.readDataFromExcel("Settings", 65, 1);
			  String City = eUtil.readDataFromExcel("Settings", 66, 1);
			  String State = eUtil.readDataFromExcel("Settings", 67, 1);
			  String Pincode = eUtil.readDataFromExcel("Settings", 68, 1);
			  String Address = eUtil.readDataFromExcel("Settings", 69, 1);
			  
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
				
			   driver.findElement(By.xpath("//a[@href='/settings/addresses']")).click();
				
			   Thread.sleep(3000);
			 
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Title']")).sendKeys(Title);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter City']")).sendKeys(City);
			   
			   WebElement state = driver.findElement(By.xpath("//select[@formcontrolname='state_id']"));
			   
			   Select s = new Select(state);
			   s.selectByVisibleText(State);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Pincode']")).sendKeys(Pincode);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Address']")).sendKeys(Address);
			   
			   driver.findElement(By.xpath("//button[.='Submit']")).click();
			   
			   driver.findElement(By.xpath("abc")).click();
					
				
		  }
		  
		  
		  
		  // Giving Invalid Details While Adding Address And Click On Submit Error
		  
		  @Test(groups = "SettingsNegative3", priority = 29)
		  public void addressGivingInvalidDetailsToTitleCityStatePincodeAddressFieldsErrorTest () throws Exception
		  {
			  ExcelFileUtility eUtil = new ExcelFileUtility();
			  String Title = eUtil.readDataFromExcel("Settings", 65, 2);
			  String City = eUtil.readDataFromExcel("Settings", 66, 2);
			  String State = eUtil.readDataFromExcel("Settings", 67, 2);
			  String Pincode = eUtil.readDataFromExcel("Settings", 68, 2);
			  String Address = eUtil.readDataFromExcel("Settings", 69, 2);
			  
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
				
			   driver.findElement(By.xpath("//a[@href='/settings/addresses']")).click();
				
			   Thread.sleep(3000);
			 
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Title']")).sendKeys(Title);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter City']")).sendKeys(City);
			   
			   WebElement state = driver.findElement(By.xpath("//select[@formcontrolname='state_id']"));
			   
			   Select s = new Select(state);
			   s.selectByVisibleText(State);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Pincode']")).sendKeys(Pincode);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Address']")).sendKeys(Address);
			   
			   driver.findElement(By.xpath("//button[.='Submit']")).click();
			   
			   driver.findElement(By.xpath("abc")).click();   
			   
			   
				
		  }
		  
		  
		  
		  @Test(groups = "SettingsNegative3", priority = 30)
		  public void deletePrimaryAccountErrorTest () throws Exception
		  {
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
				
			   driver.findElement(By.xpath("//a[@href='/settings/addresses']")).click();
				
			   Thread.sleep(3000);
			   
			   driver.findElement(By.xpath("//a[text()=' Primary']/following-sibling::button/i[@class='far fa-trash-alt']")).click();
			   
			   Thread.sleep(3000);
			   
			   driver.switchTo().alert().accept();
			   
			   Thread.sleep(3000);
			   
		  }
		  
		  
		  // Deleting Non Primary Bank Account
		  
		  @Test(groups = "SettingsNegative4", priority = 31)
		  public void deleteNonPrimaryAccountErrorTest () throws Exception
		  {
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
				
			   driver.findElement(By.xpath("//a[@href='/settings/addresses']")).click();
				
			   Thread.sleep(3000);
			   
			   driver.findElement(By.xpath("(//a[.='Set As Primary'])[1]/..//button/i[@class='far fa-trash-alt']")).click();
			   
			   Thread.sleep(3000);
			   
			   driver.switchTo().alert().accept();
			   
			   Thread.sleep(3000);
			   
		  }
		  
		  // Adding Bank Account without giving Any details
		  
		  @Test(groups = "SettingsNegative4", priority = 32)
		  public void addingBankAccountWithoutGivingAnyDataErrorTest () throws Exception
		  {
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
			   
			   driver.findElement(By.xpath("//a[@routerlink='/settings/bankAccounts']")).click();
			   
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
			   
			   driver.findElement(By.xpath("//button[.='Submit']")).click();
			   
			   driver.findElement(By.xpath("a")).click();
			 
			 
		  }
		  
		  
		  // Adding Bank Account without giving Any details
		  
		  @Test(groups = "SettingsNegative4", priority = 33)
		  public void addingBankAccountByGivingOnlyNameErrorTest () throws Exception
		  {
			  ExcelFileUtility eUtil = new ExcelFileUtility();
			  String Name = eUtil.readDataFromExcel("Settings", 73, 1);
			  
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
			   }
			  }
				
			   driver.findElement(By.xpath("//span[.='Settings']")).click();
			   
			   driver.findElement(By.xpath("//a[@routerlink='/settings/bankAccounts']")).click();
		       
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
			   
			   driver.findElement(By.xpath("//input[@formcontrolname='name_on_account']")).sendKeys(Name);
			   
               driver.findElement(By.xpath("//button[.='Submit']")).click();
			   
			   driver.findElement(By.xpath("a")).click();
			   
			   
		  }
		  
		  
		  // Adding Bank Account By Giving Only Name details
		  
		  @Test(groups = "SettingsNegative4", priority = 34)
		  public void addingBankAccountByGivingNameAccountNumErrorTest () throws Exception
		  {
			  ExcelFileUtility eUtil = new ExcelFileUtility();
			  String Name = eUtil.readDataFromExcel("Settings", 73, 1);
			  String AccountNo = eUtil.readDataFromExcel("Settings", 74, 1);
			  
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
			   }
			  }
				
			   driver.findElement(By.xpath("//span[.='Settings']")).click();
			   
			   driver.findElement(By.xpath("//a[@routerlink='/settings/bankAccounts']")).click();
		       
			   driver.findElement(By.xpath("//a[@routerlink='./add']")).click();
			   
			   driver.findElement(By.xpath("//input[@formcontrolname='name_on_account']")).sendKeys(Name);
			   
			   driver.findElement(By.xpath("//input[@placeholder='Enter Account Number']")).sendKeys(AccountNo);
			   
               driver.findElement(By.xpath("//button[.='Submit']")).click();
			   
			   driver.findElement(By.xpath("a")).click();
			   
			   
		  }
		  
		  
		  // Deleting Primary Bank Account Error
		  
		  @Test(groups = "SettingsNegative4", priority = 35)
		  public void deletingPrimaryBankAccountErrorTest () throws Exception
		  {
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
			   
			   driver.findElement(By.xpath("//a[@routerlink='/settings/bankAccounts']")).click();
			   
			   driver.findElement(By.xpath("//a[text()=' Primary']/..//a/i[@class='fas fa-trash-alt']")).click();
			   
			   driver.switchTo().alert().accept();
			   
			   driver.findElement(By.xpath("a")).click();
			   
		  }
		  
		  
		  
		  
   }
	
	
	
/*
 * Robot r = new Robot();  //8
 * r.keyPress(KeyEvent.Vk_TAB);
 * r.keyRelease(KeyEvent.Vk_TAB);
 */





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