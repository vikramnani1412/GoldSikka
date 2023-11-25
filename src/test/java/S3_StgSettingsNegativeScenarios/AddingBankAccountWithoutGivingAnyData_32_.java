package S3_StgSettingsNegativeScenarios;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class AddingBankAccountWithoutGivingAnyData_32_ extends BaseClass {

	  @Test(groups = "Settings", priority = 32)
	  public void addingBankAccountWithoutGivingAnyData() throws Exception
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
	
}
