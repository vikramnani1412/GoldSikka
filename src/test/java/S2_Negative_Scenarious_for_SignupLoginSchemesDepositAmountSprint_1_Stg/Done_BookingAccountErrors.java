package S2_Negative_Scenarious_for_SignupLoginSchemesDepositAmountSprint_1_Stg;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.WebDriverUtility;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class Done_BookingAccountErrors extends BaseClass {
	
	@Test(groups = "BookingAccount" , priority = 1)
	public void adding1RstoBookingAccount() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
		wait.until(ExpectedConditions.visibilityOf(bookingAccount));
		bookingAccount.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Amount']")).sendKeys("1",Keys.ENTER);
		Thread.sleep(3000);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//input[@id='contact']")).sendKeys("9876543210");
		
		
	}
	
	
	@Test(groups = "BookingAccount" , priority = 2)   //Passed Testcase
	public void adding50RstoBookingAccountAndClickingOnSuccessButtonPass() throws Exception
	{
		Robot r = new Robot();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		
		WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
		wait.until(ExpectedConditions.visibilityOf(bookingAccount));
		bookingAccount.click();
		driver.findElement(By.xpath("//input[@placeholder='Enter Amount']")).sendKeys("50",Keys.ENTER);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
		Thread.sleep(2000);
		driver.switchTo().frame(frame);
		driver.findElement(By.name("contact")).sendKeys("8686184458");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='redesign-v15-cta-wrapper svelte-s8db8t']")).click();
		Thread.sleep(3000);
        
		
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
		Thread.sleep(3000);
		
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(2000);
		WebElement PayNowBtn = driver.findElement(By.xpath("//button[text()='Pay Now']"));
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.elementToBeClickable(PayNowBtn));
		PayNowBtn.click();
		Thread.sleep(3000);
		
		Set<String> childWindow = driver.getWindowHandles();

		for(String childids : childWindow)
		{
			if(!childids.equals(parentWindow))
			{
				driver.switchTo().window(childids);
				driver.findElement(By.xpath("//button[.='Success']")).click();
			}
		}
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
	    
        WebDriverUtility wUtil = new WebDriverUtility();
        wUtil.takeScreenShot(driver, "50Rs Method");
		
        driver.switchTo().window(parentWindow);
		                
        wait.until(ExpectedConditions.alertIsPresent());
                       
		String AlertMsg = driver.switchTo().alert().getText();
		System.out.println(AlertMsg);
		
		driver.switchTo().alert().accept(); 	
		
	}
	
	
	@Test(groups = "BookingAccount" , priority = 3)
	public void withoutGivingAmountInBookingAccountTextFieldAndClickingOnSubmitButton() throws Exception
	{	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
		wait.until(ExpectedConditions.visibilityOf(bookingAccount));
		bookingAccount.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Amount']")).sendKeys(Keys.ENTER);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//input[@id='contact']")).sendKeys("9876543210");
		

	}
	
	
	@Test(groups = "BookingAccount" , priority = 4)
	public void entering1RsInWithdrawAmountTextFieldAndClickonWithdraw() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
		wait.until(ExpectedConditions.visibilityOf(bookingAccount));
		bookingAccount.click();
		Thread.sleep(3000);
			
		driver.findElement(By.xpath("//button[.='Withdraw']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Amount']")).sendKeys("1",Keys.ENTER);
		Thread.sleep(3000);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//input[@id='contact']")).sendKeys("9876543210");
		
		
	}
	
	
	@Test(groups = "BookingAccount" , priority = 5)
	public void entering50RsInWithdrawAmountTextFieldAndClickonWithdraw() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		
		WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
		wait.until(ExpectedConditions.visibilityOf(bookingAccount));
		bookingAccount.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[.='Withdraw']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Amount']")).sendKeys("50",Keys.ENTER);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//h6[.='   Transaction Successful ']")).getText();
		
		
				
	}
	
	@Test(groups = "BookingAccount" , priority = 6)
	public void entering499RsInWithdrawAmountTextFieldAndClickonWithdraw() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		Thread.sleep(3000);
		WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
		wait.until(ExpectedConditions.visibilityOf(bookingAccount));
		bookingAccount.click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[.='Withdraw']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Amount']")).sendKeys("499",Keys.ENTER);
		
		driver.findElement(By.xpath("//h6[.='   Transaction Successful ']")).getText();
		
		Thread.sleep(2000);
		
				
	}
	
	@Test(groups = "BookingAccount" , priority = 7 , invocationCount = 2)    //This is for withdraw 500Rs/- 2 times, 2nd time we got error
	public void entering500RsInWithdrawAmountTextFieldAndClickonWithdraw() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
		wait.until(ExpectedConditions.visibilityOf(bookingAccount));
		bookingAccount.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[.='Withdraw']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Amount']")).sendKeys("500",Keys.ENTER);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//h6[.='   Transaction Successful ']")).getText();
		
//		
//		try 
//		{
//			WebElement WhileWithdrawing2ndTimeError = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
//			wait.until(ExpectedConditions.visibilityOf(WhileWithdrawing2ndTimeError));
//			String WhileWithdrawing2ndTimeErrorMsg = WhileWithdrawing2ndTimeError.getText();
//			if(WhileWithdrawing2ndTimeError.isDisplayed())
//			{
//				System.out.println(WhileWithdrawing2ndTimeErrorMsg);
//			}
//		}
//		catch (Exception e) 
//		{
//			Thread.sleep(1);
//		}
		Thread.sleep(3000);
				
	}
	
	
	@Test(groups = "BookingAccount" , priority = 8)
	public void enteringNegative5RsInWithdrawAmountTextFieldAndClickonWithdraw() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
		wait.until(ExpectedConditions.visibilityOf(bookingAccount));
		bookingAccount.click();
		Thread.sleep(3000);		
				
		driver.findElement(By.xpath("//button[.='Withdraw']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Amount']")).sendKeys("-5",Keys.ENTER);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//h6[.='   Transaction Successful ']")).getText();
		
		Thread.sleep(3000);
		
				
	}
	
	
	@Test(groups = "BookingAccount" , priority = 9)             //have to operate model popup at last
	public void adding50RstoBookingAccountAndClickingOnFailureButton() throws Exception
	{	
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
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[.='Failure']")).click();
		
	}
	
	
	@Test                                        //Adding Amount using debit card error
	public void addingAmountToBookingAccountUsingDebitCard() throws InterruptedException, Exception {
				
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		Thread.sleep(3000);
		WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
		wait.until(ExpectedConditions.visibilityOf(bookingAccount));
		bookingAccount.click();
		driver.findElement(By.xpath("//input[@placeholder='Enter Amount']")).sendKeys("5000",Keys.ENTER);
		WebElement element = driver.findElement(By.xpath("//iframe[contains(@style,'op')]"));
		driver.switchTo().frame(element);
		driver.findElement(By.xpath("//input[@id='contact']")).sendKeys("8686184458");
		driver.findElement(By.xpath("//div[@class='redesign-v15-cta-wrapper svelte-s8db8t']")).click();
		
		
		driver.findElement(By.xpath("//div[.='Card']")).click();
		driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("4481");
		driver.findElement(By.xpath("//input[@id='card_expiry']")).sendKeys("0126");
		driver.findElement(By.xpath("//input[@id='card_name']")).sendKeys("Gvc");
		driver.findElement(By.xpath("//input[@id='card_cvv']")).sendKeys("032");
		driver.findElement(By.xpath("//input[@id='card_number']")).click();
		
		driver.findElement(By.xpath("//span[@class='checkbox svelte-1b61qmd']")).click();
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.className("svelte-s8db8t")).click();
		
		Set<String> childWindow = driver.getWindowHandles();
		
		for(String childid : childWindow)
		{
			if(!childid.equals(parentWindow))
			{
				driver.switchTo().window(childid);
				driver.findElement(By.xpath("//button[.='Success']")).click();
			}
		}
		
		Assert.fail();
		
		
	}
	
	
}
