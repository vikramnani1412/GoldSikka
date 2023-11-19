package S3_StgSettingsPositiveScenarios;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.PropertyFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class AddressDetailsUpdationDeletionMakingPrimaryTest extends BaseClass{
	
	@Test(groups = "AddressUpdation" , priority = 1 , invocationCount = 2)
	public void addressUpdationTest() throws Exception
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String Title = eUtil.readDataFromExcel("Settings",23,6);
		String Address = eUtil.readDataFromExcel("Settings",24,6);
		String City = eUtil.readDataFromExcel("Settings",25,6);
		String StateValue = eUtil.readDataFromExcel("Settings",26,6);
		String PinCode = eUtil.readDataFromExcel("Settings",27,6);
		
		
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
		
		driver.findElement(By.xpath("//a[@href='/settings/addresses']")).click();
		
		driver.findElement(By.xpath("//a[@href='/settings/addresses/add']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Title']")).sendKeys(Title);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter City']")).sendKeys(City);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Pincode']")).sendKeys(PinCode);
		
		WebElement State = driver.findElement(By.xpath("//select[@formcontrolname='state_id']"));
		
		Select s = new Select(State);
		s.selectByVisibleText(StateValue);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Address']")).sendKeys(Address);
		
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		
		String RecentlyAddedAddress = driver.findElement(By.xpath("//h5[contains(.,'"+Title+"')]")).getText();
		                                                               
		if(RecentlyAddedAddress.contains(Title))
		{                      
			System.out.println("Address Added Successfully");
		}
		else
		{
			System.out.println("Address Not Added Successfully");
		}
	}// Upto here Doneeeee
	
		
	@Test(groups = "AddressUpdation" , priority = 2)
	public void settingAsPrimaryAddress() throws Exception
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String Title = eUtil.readDataFromExcel("Settings",23,6);
		
		
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
		
		driver.findElement(By.xpath("//a[@href='/settings/addresses']")).click();
		
		driver.findElement(By.xpath("//h5[.=' "+Title+" ']/../following-sibling::div[@class='col-lg-6']//a[.='Set As Primary']")).click();
		
		String AfterSettingPrimaryConformationMsg = driver.findElement(By.xpath("//h5[.=' "+Title+" '] /../following-sibling::div//a[.=' Primary']")).getText();
		
		if(AfterSettingPrimaryConformationMsg.equalsIgnoreCase("Primary"))
		{
			System.out.println(Title+" Address setted as Primary Address");
		}
		else
		{
			System.out.println(Title+" Address not setted as Primary Address");
		}
	}
	
	
		@Test(groups = "AddressUpdation" , priority = 3)
		public void edtingExistingAddressTest() throws Exception
		{
			ExcelFileUtility eUtil = new ExcelFileUtility();
			String Title = eUtil.readDataFromExcel("Settings",23,1);
			
			String EditTitle = eUtil.readDataFromExcel("Settings",23,2);
			String EditAddress = eUtil.readDataFromExcel("Settings",24,2);
			String EditCity = eUtil.readDataFromExcel("Settings",25,2);
			String EditStateValue = eUtil.readDataFromExcel("Settings",26,2);
			String EditPinCode = eUtil.readDataFromExcel("Settings",27,2);
			
			
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
			
			driver.findElement(By.xpath("//a[@href='/settings/addresses']")).click();
		    
			driver.findElement(By.xpath("(//h5[text()=' Staging '])[2]/../following-sibling::div//i[@class='far fa-edit']")).click();
			                                                  
			WebElement TitleEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Title']"));
			TitleEdt.clear();
			TitleEdt.sendKeys(EditTitle);
			
			WebElement AddressEdt = driver.findElement(By.xpath("//textarea[@placeholder='Enter Address']"));
			AddressEdt.clear();
			AddressEdt.sendKeys(EditAddress);
			
			WebElement CityEdt = driver.findElement(By.xpath("//input[@placeholder='Enter city']"));
			CityEdt.clear();
			CityEdt.sendKeys(EditCity);
			
			WebElement State = driver.findElement(By.xpath("//select[@formcontrolname='state_id']"));
			
			Select s = new Select(State);
			s.selectByVisibleText(EditStateValue);
			
			WebElement PincodeEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Pincode']"));
			PincodeEdt.clear();
			PincodeEdt.sendKeys(EditPinCode);
			
			driver.findElement(By.xpath("//button[.=' Submit ']")).click();
			
			try
			{
				String SuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
				System.out.println(SuccessMsg);
			}
			catch(Exception e)
			{
				System.out.println("Address Not Updated Successfully");
				Assert.fail();
			}

    	}
		
		
		@Test(groups = "AddressUpdation" , priority = 4)
		public void addressDeletion() throws Exception
		{
			ExcelFileUtility eUtil = new ExcelFileUtility();
			String Title = eUtil.readDataFromExcel("Settings",23,6);
			
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
			
			driver.findElement(By.xpath("//a[@href='/settings/addresses']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//h5[text()=' "+Title+" '])[2]/../following-sibling::div//i[@class='far fa-trash-alt']")).click();
			                            
			driver.switchTo().alert().accept();
					
			try
			{
				String SuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
				System.out.println(SuccessMsg);
			}
			catch(Exception e)
			{
				System.out.println("Not Deleted");
				Assert.fail();
			}
		}
		
		
}
