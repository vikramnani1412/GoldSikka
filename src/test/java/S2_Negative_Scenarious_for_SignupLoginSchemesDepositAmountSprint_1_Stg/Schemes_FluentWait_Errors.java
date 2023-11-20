package S2_Negative_Scenarious_for_SignupLoginSchemesDepositAmountSprint_1_Stg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class Schemes_FluentWait_Errors extends BaseClass {

	@Test(groups = "Schemes" , priority = 1)
	public void givingInvalidCouponDetailsToSchemesPageTest() throws AWTException, InterruptedException
	{
	Robot r = new Robot();
	
	FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
		    .withTimeout(Duration.ofSeconds(100)) 
		    .pollingEvery(Duration.ofSeconds(2))
		    .ignoring(NoSuchElementException.class);
	
	WebElement schemes = driver.findElement(By.xpath("//span[.='Schemes']"));
	fluentWait.until(ExpectedConditions.visibilityOf(schemes));
	schemes.click();
	Thread.sleep(3000);
	
	WebElement subscribeBtn = driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']"));
	fluentWait.until(ExpectedConditions.visibilityOf(subscribeBtn));
	subscribeBtn.click();
	Thread.sleep(3000);
	
	WebElement amount = driver.findElement(By.xpath("//select[@formcontrolname='amount']"));
	fluentWait.until(ExpectedConditions.visibilityOf(amount));
	amount.click();
	Select s = new Select(amount);
	s.selectByValue("1500");
	Thread.sleep(3000);
	
	WebElement months = driver.findElement(By.xpath("//select[@placeholder='Months']"));
	fluentWait.until(ExpectedConditions.visibilityOf(months));
	months.click();
	Select s1 = new Select(months);
	s1.selectByVisibleText("12 Months");
	Thread.sleep(3000);
	
	try {
		WebElement AgreeCheckBox = driver.findElement(By.xpath("//p[.='I Agree to Terms & Conditions']/../..//input[@type='checkbox']"));
		fluentWait.until(ExpectedConditions.visibilityOf(AgreeCheckBox));
        AgreeCheckBox.click();
	} catch (Exception e) {
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//input[@placeholder='Enter coupon code']")).sendKeys("ghfhjv56354");
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//button[.='Apply']")).click();
	Thread.sleep(3000);
    
    driver.findElement(By.xpath("abc"));
	
}

//New Script Starts

	@Test(groups = "Schemes" , priority = 2)
	public void withoutGivingAnyDetailsInSchemesPageErrorTest() throws AWTException, InterruptedException
	{
		Robot r = new Robot();
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
			    .withTimeout(Duration.ofSeconds(100)) 
			    .pollingEvery(Duration.ofSeconds(2))
			    .ignoring(NoSuchElementException.class);
		
		WebElement schemes = driver.findElement(By.xpath("//span[.='Schemes']"));
		fluentWait.until(ExpectedConditions.visibilityOf(schemes));
		schemes.click();
		Thread.sleep(3000);
		
		WebElement subscribeBtn = driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']"));
		fluentWait.until(ExpectedConditions.visibilityOf(subscribeBtn));
		subscribeBtn.click();
		Thread.sleep(3000);
					
		while (true)
		{
		try 
		{
			WebElement startSubscribeBtn = driver.findElement(By.xpath("//div[@class='coupon-text2']/following-sibling::div/button[@type='submit']"));
			fluentWait.until(ExpectedConditions.visibilityOf(startSubscribeBtn));
			startSubscribeBtn.click();
			break;
		} 
		catch (Exception e) 
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
		}
		}
		Thread.sleep(3000);
		
		WebElement AgreeCheckBox = driver.findElement(By.xpath("(//div[.='You must accept the terms & conditions to continue. '])[2]"));
		fluentWait.until(ExpectedConditions.visibilityOf(AgreeCheckBox));
		
		WebElement AmountError = driver.findElement(By.xpath("//p[text()='Amount']/../following-sibling::div//div[.=' This field is required ']"));
		fluentWait.until(ExpectedConditions.visibilityOf(AmountError));
		
		if(AgreeCheckBox.isDisplayed())
		{
		   r.keyPress(KeyEvent.VK_PAGE_UP);
		   r.keyRelease(KeyEvent.VK_PAGE_UP);
		}
	    if(AmountError.isDisplayed())
		{
			AmountError.click();
			driver.findElement(By.xpath("abc"));
		}
		
		Thread.sleep(3000);
		
  }
	
	
	@Test(groups = "Schemes" , priority = 3)
	public void clickingOnStartSubscritionButtonWithOutCheckingIAgreeTermsAndConditionsCheckboxTest() throws Exception
	{
		Robot r = new Robot();
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
			    .withTimeout(Duration.ofSeconds(100)) 
			    .pollingEvery(Duration.ofSeconds(2))
			    .ignoring(NoSuchElementException.class);
		
		WebElement schemes = driver.findElement(By.xpath("//span[.='Schemes']"));
		fluentWait.until(ExpectedConditions.visibilityOf(schemes));
		schemes.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']")).click();
		Thread.sleep(3000);
		
		WebElement amount = driver.findElement(By.xpath("//select[@formcontrolname='amount']"));
		fluentWait.until(ExpectedConditions.visibilityOf(amount));
		amount.click();
		Select s = new Select(amount);
		s.selectByValue("9500");
		Thread.sleep(3000);
		
		WebElement months = driver.findElement(By.xpath("//select[@placeholder='Months']"));
		fluentWait.until(ExpectedConditions.visibilityOf(months));
		months.click();
		Select s1 = new Select(months);
		s1.selectByVisibleText("12 Months");
		Thread.sleep(3000);
		
		while (true)
		{
		try 
		{
			WebElement startSubscribeBtn = driver.findElement(By.xpath("//div[@class='coupon-text2']/following-sibling::div/button[@type='submit']"));
			fluentWait.until(ExpectedConditions.visibilityOf(startSubscribeBtn));
			startSubscribeBtn.click();
			break;
		} 
		catch (Exception e) 
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
		}
		}
		Thread.sleep(3000);
		
		WebElement AgreeCheckBoxError = driver.findElement(By.xpath("//input[@formcontrolname='agree']/following-sibling::div[.='You must accept the terms & conditions to continue. ']"));
		fluentWait.until(ExpectedConditions.visibilityOf(AgreeCheckBoxError));
		if(AgreeCheckBoxError.isDisplayed())
		{
			driver.findElement(By.xpath("abc"));
		}
		Thread.sleep(3000);
	}
	
	@Test(groups = "Schemes" , priority = 4)
	public void clickingOnStartSubscritionButtonByGivingAmountAndCheckingBookingAccountCheckboxTest() throws Exception
	{
		Robot r = new Robot();
		
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
			    .withTimeout(Duration.ofSeconds(100)) 
			    .pollingEvery(Duration.ofSeconds(2))
			    .ignoring(NoSuchElementException.class);
		
		WebElement schemes = driver.findElement(By.xpath("//span[.='Schemes']"));
		fluentWait.until(ExpectedConditions.visibilityOf(schemes));
		schemes.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']")).click();
		Thread.sleep(3000);
		
		WebElement amount = driver.findElement(By.xpath("//select[@formcontrolname='amount']"));
		fluentWait.until(ExpectedConditions.visibilityOf(amount));
		amount.click();
		Select s = new Select(amount);
		s.selectByValue("1000");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[.='Use Booking Account']//input[@type='checkbox']")).click();
		
		while (true)
		{
		try 
		{
			WebElement startSubscribeBtn = driver.findElement(By.xpath("//div[@class='coupon-text2']/following-sibling::div/button[@type='submit']"));
			fluentWait.until(ExpectedConditions.visibilityOf(startSubscribeBtn));
			startSubscribeBtn.click();
			break;
		} 
		catch (Exception e) 
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
		}
		}
		
		driver.findElement(By.xpath("abc"));
		Thread.sleep(3000);
		
		
	}
	
	@Test(groups = "Schemes" , priority = 5)
	public void afterSchemeSubscriptionFetchingSuccessMsgTest() throws Exception
	{
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
			    .withTimeout(Duration.ofSeconds(100)) 
			    .pollingEvery(Duration.ofSeconds(2))
			    .ignoring(NoSuchElementException.class);
		
		WebElement scheme = driver.findElement(By.xpath("//span[.='Schemes']"));
		fluentWait.until(ExpectedConditions.visibilityOf(scheme));
		scheme.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']")).click();
		Thread.sleep(3000);
		
		WebElement amount = driver.findElement(By.xpath("//select[@formcontrolname='amount']"));
		fluentWait.until(ExpectedConditions.visibilityOf(amount));
		amount.click();
		Select s = new Select(amount);
		s.selectByValue("9500");
		Thread.sleep(3000);
		
		WebElement months = driver.findElement(By.xpath("//select[@placeholder='Months']"));
		fluentWait.until(ExpectedConditions.visibilityOf(months));
		months.click();
		Select s1 = new Select(months);
		s1.selectByVisibleText("12 Months");
		Thread.sleep(3000);
		
		Robot r = new Robot();
		try 
		{
			driver.findElement(By.xpath("//p[.='Use Booking Account']/../..//div/input[@type='checkbox']")).click();
		} 
		catch (Exception e) 
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
		}
		Thread.sleep(3000);
		
		WebElement agreeCheckBox = driver.findElement(By.xpath("//p[.='I Agree to Terms & Conditions']/../..//input[@type='checkbox']"));
		fluentWait.until(ExpectedConditions.visibilityOf(agreeCheckBox)).click();
        
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@formcontrolname='enteredWalletAmount']")).sendKeys("9500");		
		Thread.sleep(5000);
		
//		String PayableAmount = driver.findElement(By.xpath("//p[text()=' Payable Amount:']/span[contains(.,'₹')]")).getText();
//		if(!PayableAmount.equals(0))
//		{
//			Thread.sleep(3000);                   //This is to know that payable amount
//			System.out.println(PayableAmount);    //got Reduced based on given amount
//		}
		
		while (true)
		{
		try 
		{
			WebElement submitBtn = driver.findElement(By.xpath("//div[@class='coupon-text2']/following-sibling::div/button[@type='submit']"));
			fluentWait.until(ExpectedConditions.visibilityOf(submitBtn)).click();
			break;
		} 
		catch (Exception e) 
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
		}
		}
		Thread.sleep(3000);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
		Thread.sleep(3000);
		
		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='contact']")).sendKeys("8686184458");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@class='svelte-s8db8t']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[.='Netbanking']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[.='ICICI']")).click();
		Thread.sleep(1000);
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(2000);
		
		WebElement submitBtn = driver.findElement(By.xpath("//button[.='Pay Now']"));
		fluentWait.until(ExpectedConditions.visibilityOf(submitBtn)).click();
		
		Set<String> childWindow = driver.getWindowHandles();
		
		for(String childid : childWindow)
		{
			if(!childid.equals(parentWindow))
			{
				driver.switchTo().window(childid);
				driver.findElement(By.xpath("//button[.='Success']")).click();
			}
		}
		Thread.sleep(3000);
		
		driver.switchTo().window(parentWindow);
		
		fluentWait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        
		String AlertMsg = driver.switchTo().alert().getText();
		System.out.println(AlertMsg);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		WebElement TextArea = driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']"));
		Thread.sleep(3000);
		
//		This is Before Completion of modal popup close button ele
//		driver.findElement(By.xpath("//div[.='Feedback']/following-sibling::div/button[.=' X ']")).click();
		
		fluentWait.until(ExpectedConditions.visibilityOf(TextArea));
		TextArea.sendKeys("Good Scheme");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//label[@for='4-star']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[.=' submit ']")).click();
		Thread.sleep(3000);
					
		//This is After Completion of modal popup close button ele
		driver.findElement(By.xpath("//div[.=' Thank for your Feedback']/following-sibling::div/button[.=' X ']")).click();
		Thread.sleep(3000);
		
		WebElement SuccessPopup = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		String SuccessMsg = SuccessPopup.getText();
		if(SuccessPopup.isDisplayed())
		{
			System.out.println(SuccessMsg);
			driver.findElement(By.xpath("abc"));
		}		
		
		Thread.sleep(3000);
	}
	
	
	                                                     
	
	
	
	@Test(groups = "Schemes" , priority = 6)
	public void afterSchemeSubscriptionFetchingFailureMsgTest() throws Exception
	{
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
			    .withTimeout(Duration.ofSeconds(100)) 
			    .pollingEvery(Duration.ofSeconds(2))
			    .ignoring(NoSuchElementException.class);
		
		WebElement schemes = driver.findElement(By.xpath("//span[.='Schemes']"));
		fluentWait.until(ExpectedConditions.visibilityOf(schemes));
		schemes.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']")).click();
		Thread.sleep(3000);
		
		WebElement amount = driver.findElement(By.xpath("//select[@formcontrolname='amount']"));
		fluentWait.until(ExpectedConditions.visibilityOf(amount));
		amount.click();
		Select s = new Select(amount);
		s.selectByValue("4500");
		Thread.sleep(3000);
		
		WebElement months = driver.findElement(By.xpath("//select[@placeholder='Months']"));
		fluentWait.until(ExpectedConditions.visibilityOf(months));
		months.click();
		Select s1 = new Select(months);
		s1.selectByVisibleText("12 Months");
		Thread.sleep(3000);
					
		Robot r = new Robot();
		try 
		{
			driver.findElement(By.xpath("//p[.='Use Booking Account']/../..//div/input[@type='checkbox']")).click();
		} 
		catch (Exception e) 
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
		}
		Thread.sleep(3000);
		
		WebElement aggreeCheckBox = driver.findElement(By.xpath("//p[.='I Agree to Terms & Conditions']/../..//input[@type='checkbox']"));
		fluentWait.until(ExpectedConditions.elementToBeClickable(aggreeCheckBox)).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@formcontrolname='enteredWalletAmount']")).sendKeys("4500");
		Thread.sleep(5000);
		
		while (true)
		{
		try 
		{
			WebElement submitBtn = driver.findElement(By.xpath("//div[@class='coupon-text2']/following-sibling::div/button[@type='submit']"));
			fluentWait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
			break;
		} 
		catch (Exception e) 
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
		}
		}
		Thread.sleep(3000);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='contact']")).sendKeys("8686184458");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@class='svelte-s8db8t']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[.='Netbanking']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[.='ICICI']")).click();
		Thread.sleep(3000);
		
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(3000);
		
		WebElement payNowBtn = driver.findElement(By.xpath("//button[.='Pay Now']"));
		fluentWait.until(ExpectedConditions.elementToBeClickable(payNowBtn));
		Thread.sleep(3000);
		
		Set<String> childWindow = driver.getWindowHandles();
		
		for(String childid : childWindow)
		{
			if(!childid.equals(parentWindow))
			{
				driver.switchTo().window(childid);
				driver.findElement(By.xpath("//button[.='Failure']")).click();
				Thread.sleep(1000);
			}
		}
		
		Thread.sleep(3000);
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("abc")).click();
		
		
	}
	                                                  
	
	@Test(groups = "Schemes" , priority = 6)
	public void takingScreenshotofRecentlySubscribedSchemeTest() throws Exception
	{
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
			    .withTimeout(Duration.ofSeconds(100)) 
			    .pollingEvery(Duration.ofSeconds(2))
			    .ignoring(NoSuchElementException.class);
		
		WebElement scheme = driver.findElement(By.xpath("//span[.='Schemes']"));
		fluentWait.until(ExpectedConditions.visibilityOf(scheme));
		scheme.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']")).click();
		Thread.sleep(3000);
		
		WebElement amount = driver.findElement(By.xpath("//select[@formcontrolname='amount']"));
		fluentWait.until(ExpectedConditions.visibilityOf(amount));
		amount.click();
		Select s = new Select(amount);
		s.selectByValue("1500");
		Thread.sleep(3000);
		
		WebElement months = driver.findElement(By.xpath("//select[@placeholder='Months']"));
		fluentWait.until(ExpectedConditions.visibilityOf(months));
		months.click();
		Select s1 = new Select(months);
		s1.selectByVisibleText("12 Months");
		Thread.sleep(3000);
					
		Robot r = new Robot();
		try 
		{
			driver.findElement(By.xpath("//p[.='Use Booking Account']/../..//div/input[@type='checkbox']")).click();
		} 
		catch (Exception e) 
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@formcontrolname='enteredWalletAmount']")).sendKeys("1800");		
		Thread.sleep(3000);
		
		WebElement agreeCheckBoX = driver.findElement(By.xpath("//p[.='I Agree to Terms & Conditions']/../..//input[@type='checkbox']"));
		fluentWait.until(ExpectedConditions.visibilityOf(agreeCheckBoX)).click();
		Thread.sleep(5000);
		
		while (true)
		{
		try 
		{
			WebElement submitBtn = driver.findElement(By.xpath("//div[@class='coupon-text2']/following-sibling::div/button[@type='submit']"));
			fluentWait.until(ExpectedConditions.visibilityOf(submitBtn)).click();
			break;
		} 
		catch (Exception e) 
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
		}
		Thread.sleep(3000);
		
		fluentWait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(3000);
		
		String AlertMsg = driver.switchTo().alert().getText();
		System.out.println(AlertMsg);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		
//		This is Before Completion of modal popup close button ele
//		driver.findElement(By.xpath("//div[.='Feedback']/following-sibling::div/button[.=' X ']")).click();
		
        WebElement TextArea = driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']"));
		fluentWait.until(ExpectedConditions.visibilityOf(TextArea));
		TextArea.sendKeys("Good Scheme");
		Thread.sleep(2000);
		                                                         //Upto here fluent wait done
		driver.findElement(By.xpath("//label[@for='4-star']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[.=' submit ']")).click();
		Thread.sleep(2000);
		
//		This is After Completion of modal popup close button ele
		driver.findElement(By.xpath("//div[.=' Thank for your Feedback']/following-sibling::div/button[.=' X ']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[.='Schemes']")).click();
		Thread.sleep(3000);
		
		WebElement SubscribeBtn = driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']"));
		fluentWait.until(ExpectedConditions.visibilityOf(SubscribeBtn));
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		
		WebElement ViewDetailsBtn = driver.findElement(By.xpath("(//button[.='View Details'])[1]"));
		fluentWait.until(ExpectedConditions.visibilityOf(ViewDetailsBtn));
		ViewDetailsBtn.click();
		Thread.sleep(3000);
		
		WebElement DownloadBtn = driver.findElement(By.xpath("//a[text()=' Download']"));
		fluentWait.until(ExpectedConditions.visibilityOf(DownloadBtn));
		driver.findElement(By.xpath("abc")).click();
							                                            		
  }
	
	
	@Test(groups = "Schemes" , priority = 7)
	public void takingScreenshotofRecentlySubscribedSchemeAfterDownlodingTest() throws Exception
	{
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
			    .withTimeout(Duration.ofSeconds(100)) 
			    .pollingEvery(Duration.ofSeconds(2))
			    .ignoring(NoSuchElementException.class);
		
		WebElement schemes = driver.findElement(By.xpath("//span[.='Schemes']"));
		fluentWait.until(ExpectedConditions.visibilityOf(schemes));
		schemes.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']")).click();
		Thread.sleep(3000);
		
		WebElement amount = driver.findElement(By.xpath("//select[@formcontrolname='amount']"));
		fluentWait.until(ExpectedConditions.visibilityOf(amount));
		amount.click();
		Select s = new Select(amount);
		s.selectByValue("1500");
		Thread.sleep(3000);
		
		WebElement months = driver.findElement(By.xpath("//select[@placeholder='Months']"));
		fluentWait.until(ExpectedConditions.visibilityOf(months));
		months.click();
		Select s1 = new Select(months);
		s1.selectByVisibleText("12 Months");
		Thread.sleep(3000);
					
		Robot r = new Robot();
		try 
		{
			driver.findElement(By.xpath("//p[.='Use Booking Account']/../..//div/input[@type='checkbox']")).click();
		} 
		catch (Exception e) 
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@formcontrolname='enteredWalletAmount']")).sendKeys("1800");		
		Thread.sleep(3000);
		
		WebElement agreeCheckBox = driver.findElement(By.xpath("//p[.='I Agree to Terms & Conditions']/../..//input[@type='checkbox']"));
		fluentWait.until(ExpectedConditions.visibilityOf(agreeCheckBox)).click();
		Thread.sleep(5000);
		
		while (true)
		{
		try 
		{
			WebElement submitBtn = driver.findElement(By.xpath("//div[@class='coupon-text2']/following-sibling::div/button[@type='submit']"));
			fluentWait.until(ExpectedConditions.visibilityOf(submitBtn)).click();
			break;
		} 
		catch (Exception e) 
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
		}
		Thread.sleep(3000);
		
		fluentWait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(3000);
		
		String AlertMsg = driver.switchTo().alert().getText();
		System.out.println(AlertMsg);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		
//		This is Before Completion of modal popup close button ele
//		driver.findElement(By.xpath("//div[.='Feedback']/following-sibling::div/button[.=' X ']")).click();
		
        WebElement TextArea = driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']"));
		fluentWait.until(ExpectedConditions.visibilityOf(TextArea));
		TextArea.sendKeys("Good Scheme");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[@for='4-star']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[.=' submit ']")).click();
		Thread.sleep(2000);
		
//		This is After Completion of modal popup close button ele
		driver.findElement(By.xpath("//div[.=' Thank for your Feedback']/following-sibling::div/button[.=' X ']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[.='Schemes']")).click();
		Thread.sleep(3000);
		
		WebElement SubscribeBtn = driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']"));
		fluentWait.until(ExpectedConditions.visibilityOf(SubscribeBtn));
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		
		WebElement ViewDetailsBtn = driver.findElement(By.xpath("(//button[.='View Details'])[1]"));
		fluentWait.until(ExpectedConditions.visibilityOf(ViewDetailsBtn));
		ViewDetailsBtn.click();
		Thread.sleep(3000);
		
		WebElement DownloadBtn = driver.findElement(By.xpath("//a[text()=' Download']"));
		fluentWait.until(ExpectedConditions.visibilityOf(DownloadBtn));
		
		DownloadBtn.click();
		driver.findElement(By.xpath("abc")).click();
		
		
					                                            		
}
	
}
