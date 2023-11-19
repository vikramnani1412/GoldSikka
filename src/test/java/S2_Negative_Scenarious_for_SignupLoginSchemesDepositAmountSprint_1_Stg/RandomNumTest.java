package S2_Negative_Scenarious_for_SignupLoginSchemesDepositAmountSprint_1_Stg;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.JavaUtility;

public class RandomNumTest extends BaseClass {

	
	@Test
	public void ranTest()
	{
		
		Random r = new Random();
		int Num = r.nextInt(9999999);
		
		if(Num > 999999)
		{
			Num++;
		}
		System.out.println(Num);
	}
	
	
	@Test(groups = "BookingAccount" , priority = 2)             //have to operate model popup at last
	public void adding50RstoBookingAccountAndClickingOnFailureButton() throws Exception
	{
		String methodName = "adding50RstoBookingAccountAndClickingOnFailureButton";
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		Robot r = new Robot();
		
		WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
		wait.until(ExpectedConditions.visibilityOf(bookingAccount));
		bookingAccount.click();
		Thread.sleep(3000);
		
		WebElement amountEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));
		wait.until(ExpectedConditions.visibilityOf(amountEdt));
		amountEdt.sendKeys("50",Keys.ENTER);
		Thread.sleep(3000);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
		Thread.sleep(2000);
		driver.switchTo().frame(frame);
		
		try {
			Thread.sleep(3000);
			driver.findElement(By.name("contact")).sendKeys("8686184458");
			driver.findElement(By.xpath("//div[@class='redesign-v15-cta-wrapper svelte-s8db8t']")).click();
		} catch (Exception e) {
			Thread.sleep(2000);
		}
		
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		
		while (true)
		{
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[.='Netbanking']"))).click();
			break;
		} 
		catch (Exception e) 
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
		}
		Thread.sleep(3000);
		
//		WebElement bank = driver.findElement(By.xpath("//div[contains(@id,'bank-item-"+BankName+"')]"));
		driver.findElement(By.xpath("//div[.='ICICI']")).click();
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(3000);
		
		WebElement PayNowBtn = driver.findElement(By.xpath("//button[text()='Pay Now']"));
		wait.until(ExpectedConditions.elementToBeClickable(PayNowBtn));
		PayNowBtn.click();
		Thread.sleep(3000);
				
		Set<String> childWindow = driver.getWindowHandles();

		for(String childids : childWindow)
		{
			if(!childids.equals(parentWindow))
			{
				driver.switchTo().window(childids);
				driver.findElement(By.xpath("//button[.='Failure']")).click();
			}
		}
		
		
		
		driver.switchTo().window(parentWindow);
		

		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.body.click();");
		
//        Assert.fail();
//        
//        Thread.sleep(3000);
        
//      driver.findElement(By.xpath("//button[.='Try again']")).click();
//        
//		Thread.sleep(3000);
		
//        WebElement click = driver.findElement(By.xpath("//div[@id='backdrop']"));
//        
//        driver.switchTo().activeElement();
//                
//        driver.switchTo().window(parentWindow);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
            
        
//        Assert.fail();
//        wUtility.takeScreenShot(driver, methodName);
        
        
//        Assert.fail();
        
//        driver.switchTo().defaultContent();
//        
//        driver.switchTo().window(parentWindow);      
//		
//		WebElement tryAgain = driver.findElement(By.xpath("//button[text()='Try again']"));		
//		WebDriverUtility wUtil = new WebDriverUtility(); 
//		wUtil.clickOnWebElement(driver, tryAgain);
//		
//   	driver.switchTo().window(parentWindow);
//		
//		Thread.sleep(5000);
		
		
		

	}
	
}
