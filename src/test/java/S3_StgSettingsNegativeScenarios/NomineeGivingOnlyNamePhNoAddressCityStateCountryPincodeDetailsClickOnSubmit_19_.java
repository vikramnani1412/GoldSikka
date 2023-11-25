package S3_StgSettingsNegativeScenarios;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class NomineeGivingOnlyNamePhNoAddressCityStateCountryPincodeDetailsClickOnSubmit_19_ extends BaseClass {

	@Test(groups = "Settings", priority = 19)
	  public void nomineeGivingOnlyNamePhNoAddressCityStateCountryPincodeDetailsClickOnSubmit() throws Exception
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
	
}
