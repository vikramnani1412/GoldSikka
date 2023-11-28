package S3_StgSettingsNegativeScenarios;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class ClearAllKYCFeildsDetailsClickOnSubmitError_9_ extends BaseClass {

	@Test(groups = "SettingsNegative1", priority = 9)
	  public void clearAllKYCFeildDetailsClickOnSubmit() throws InterruptedException, AWTException
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
	
}
