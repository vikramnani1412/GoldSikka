package S3_StgSettingsNegativeScenarios;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class addressGivingOnlyNameFields_24_ extends BaseClass {

	@Test(groups = "SettingsNegative3", priority = 24)
	  public void addressGivingOnlyNameFields() throws Exception
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
	
}
