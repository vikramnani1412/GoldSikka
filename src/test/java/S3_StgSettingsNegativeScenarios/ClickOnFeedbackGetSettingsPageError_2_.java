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
public class ClickOnFeedbackGetSettingsPageError_2_ extends BaseClass {

	@Test(groups = "SettingsNegative1", priority = 2)                           // Click on Feed Back
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
	
}
