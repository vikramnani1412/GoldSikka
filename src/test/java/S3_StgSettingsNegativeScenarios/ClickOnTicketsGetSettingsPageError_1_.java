package S3_StgSettingsNegativeScenarios;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class ClickOnTicketsGetSettingsPageError_1_ extends BaseClass {

	@Test(groups = "SettingsNegative1", priority = 1)                           // Click on Ticket
	   public void clickOnTicketsGetSettingsPageError () throws Exception {
		
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
	
}
