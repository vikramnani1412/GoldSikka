package S2_Negative_Scenarious_for_SignupLoginSchemesDepositAmountSprint_1_Stg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class Done_SchemesUsingExplicitWaitsErrors_StgTest extends BaseClass {

	@Test(groups = "expSchemes" , priority = 1)
	public void givingInvalidCouponDetailsToSchemesPageTest() throws AWTException, InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		Robot r = new Robot();
		
		WebElement schemesLnk = driver.findElement(By.xpath("//span[.='Schemes']"));
		wait.until(ExpectedConditions.visibilityOf(schemesLnk));
		schemesLnk.click();
		Thread.sleep(2000);
		
		WebElement subscribeBtn = driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']"));
		wait.until(ExpectedConditions.visibilityOf(subscribeBtn));
		subscribeBtn.click();
		Thread.sleep(2000);
		
		WebElement amountEdt = driver.findElement(By.xpath("//select[@formcontrolname='amount']"));
		wait.until(ExpectedConditions.visibilityOf(amountEdt));
		amountEdt.click();
		Select s = new Select(amountEdt);
		s.selectByValue("1500");
		Thread.sleep(2000);
		
		WebElement monthsDrpDwn = driver.findElement(By.xpath("//select[@placeholder='Months']"));
		wait.until(ExpectedConditions.visibilityOf(monthsDrpDwn));
		monthsDrpDwn.click();
		Select s1 = new Select(monthsDrpDwn);
		s1.selectByVisibleText("12 Months");
		Thread.sleep(2000);
		
		try 
		{
			WebElement AgreeCheckBox = driver.findElement(By.xpath("//p[.='I Agree to Terms & Conditions']/../..//input[@type='checkbox']"));
			wait.until(ExpectedConditions.visibilityOf(AgreeCheckBox));
            AgreeCheckBox.click();
		} 
		catch (Exception e) 
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
		Thread.sleep(2000);
		
		WebElement couponCodeEdt = driver.findElement(By.xpath("//input[@placeholder='Enter coupon code']"));
		wait.until(ExpectedConditions.visibilityOf(couponCodeEdt));
		couponCodeEdt.sendKeys("ghfhjv56354");
		Thread.sleep(2000);
		
		WebElement applyBtn = driver.findElement(By.xpath("//button[.='Apply']"));
		wait.until(ExpectedConditions.visibilityOf(applyBtn));
		applyBtn.click();
		Thread.sleep(2000);
        
		try 
		{
			WebElement error = driver.findElement(By.xpath("//button[.='Apply']/../../../../../following-sibling::div[@class='form-group ng-star-inserted']"));
			wait.until(ExpectedConditions.visibilityOf(error));
			String ErrorMsg = error.getText();
			System.out.println(ErrorMsg);
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			if(ErrorMsg.contains("Wrong Coupon Code"))
			{
				Assert.fail();
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(2000);
		}
		
	}
	
	//New Script Starts
	
		@Test(groups = "expSchemes" , priority = 2)
		public void withoutGivingAnyDetailsInSchemesPageErrorTest() throws AWTException, InterruptedException
		{
			Robot r = new Robot();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			
			WebElement schemesLnk = driver.findElement(By.xpath("//span[.='Schemes']"));
			wait.until(ExpectedConditions.visibilityOf(schemesLnk));
			schemesLnk.click();
			Thread.sleep(2000);
			
			WebElement subscribeBtn = driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']"));
			wait.until(ExpectedConditions.visibilityOf(subscribeBtn));
			subscribeBtn.click();
			Thread.sleep(2000);
			
			while (true)
			{
			try 
			{
				WebElement startSubscribeBtn = driver.findElement(By.xpath("//div[@class='coupon-text2']/following-sibling::div/button[@type='submit']"));
				wait.until(ExpectedConditions.elementToBeClickable(startSubscribeBtn));
				startSubscribeBtn.click();
				break;
			} 
			catch (Exception e) 
			{
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
			}
			Thread.sleep(3000);
			
			while(true)
			{
			try 
			{
				WebElement amount = driver.findElement(By.xpath("//p[text()='Amount']/../following-sibling::div//div[.=' This field is required ']"));
				wait.until(ExpectedConditions.visibilityOf(amount));
				amount.click();
				String AmountError = amount.getText();
				if(AmountError.contains("This field is required"))
				{
				   Assert.fail();
				   break;
				}
			} 
			catch (Exception e) 
			{
				r.keyPress(KeyEvent.VK_PAGE_UP);
				r.keyRelease(KeyEvent.VK_PAGE_UP);
			}
			}
			Thread.sleep(2000);
			
	  }
		
		
		@Test(groups = "expSchemes" , priority = 3)
		public void clickingOnStartSubscritionButtonWithOutCheckingIAgreeTermsAndConditionsCheckboxTest() throws Exception
		{
			Robot r = new Robot();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			
			WebElement ele = driver.findElement(By.xpath("//span[.='Schemes']"));
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.click();
			Thread.sleep(2000);
			
			WebElement subscribeBtn = driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']"));
			wait.until(ExpectedConditions.visibilityOf(subscribeBtn));
			subscribeBtn.click();
			Thread.sleep(2000);
			
			WebElement amountEdt = driver.findElement(By.xpath("//select[@formcontrolname='amount']"));
			wait.until(ExpectedConditions.visibilityOf(amountEdt));
			amountEdt.click();
			Select s = new Select(amountEdt);
			s.selectByValue("9500");
			Thread.sleep(3000);
			
			WebElement monthsDrpDwn = driver.findElement(By.xpath("//select[@placeholder='Months']"));
			wait.until(ExpectedConditions.visibilityOf(monthsDrpDwn));
			monthsDrpDwn.click();
			Select s1 = new Select(monthsDrpDwn);
			s1.selectByVisibleText("12 Months");
			Thread.sleep(3000);
			
			while (true)
			{
			try 
			{
				WebElement startSubscribeBtn = driver.findElement(By.xpath("//div[@class='coupon-text2']/following-sibling::div/button[@type='submit']"));
				wait.until(ExpectedConditions.visibilityOf(startSubscribeBtn));
				startSubscribeBtn.click();
				break;
			} 
			catch (Exception e) 
			{
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			}
			}
			Thread.sleep(2000);
			
			WebElement AgreeCheckBoxError = driver.findElement(By.xpath("//input[@formcontrolname='agree']/following-sibling::div[.='You must accept the terms & conditions to continue. ']"));
			wait.until(ExpectedConditions.visibilityOf(AgreeCheckBoxError));
			if(AgreeCheckBoxError.isDisplayed())
			{
				Assert.fail();
			}
			Thread.sleep(2000);
		}
		
		@Test(groups = "expSchemes" , priority = 4)
		public void afterSchemeSubscriptionFetchingSuccessMsgTest() throws Exception
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
			
			WebElement schemesLnk = driver.findElement(By.xpath("//span[.='Schemes']"));
			wait.until(ExpectedConditions.visibilityOf(schemesLnk));
			schemesLnk.click();
			Thread.sleep(2000);
			
			WebElement subscribeBtn = driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']"));
			wait.until(ExpectedConditions.visibilityOf(subscribeBtn));
			subscribeBtn.click();
			Thread.sleep(2000);
			
			WebElement amountEdt = driver.findElement(By.xpath("//select[@formcontrolname='amount']"));
			wait.until(ExpectedConditions.visibilityOf(amountEdt));
			amountEdt.click();
			Select s = new Select(amountEdt);
			s.selectByValue("9500");
			Thread.sleep(2000);
			
			WebElement monthsDrpDwn = driver.findElement(By.xpath("//select[@placeholder='Months']"));
			wait.until(ExpectedConditions.visibilityOf(monthsDrpDwn));
			monthsDrpDwn.click();
			Select s1 = new Select(monthsDrpDwn);
			s1.selectByVisibleText("12 Months");
			Thread.sleep(2000);
			
			Robot r = new Robot();
			try 
			{
				WebElement bookingAccountCheckBox = driver.findElement(By.xpath("//p[.='Use Booking Account']/../..//div/input[@type='checkbox']"));
				wait.until(ExpectedConditions.visibilityOf(bookingAccountCheckBox));
				bookingAccountCheckBox.click();
			} 
			catch (Exception e) 
			{
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[.='I Agree to Terms & Conditions']/../..//input[@type='checkbox']"))).click();
			Thread.sleep(2000);
			
			WebElement walletAmountEdt = driver.findElement(By.xpath("//input[@formcontrolname='enteredWalletAmount']"));
			wait.until(ExpectedConditions.visibilityOf(walletAmountEdt));
			walletAmountEdt.sendKeys("9500");		
			Thread.sleep(5000);
			
//			String PayableAmount = driver.findElement(By.xpath("//p[text()=' Payable Amount:']/span[contains(.,'₹')]")).getText();
//			if(!PayableAmount.equals(0))
//			{
//				Thread.sleep(3000);                   //This is to know that payable amount
//				System.out.println(PayableAmount);    //got Reduced based on given amount
//			}
			
			while (true)
			{
			try 
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='coupon-text2']/following-sibling::div/button[@type='submit']"))).click();
				break;
			} 
			catch (Exception e) 
			{
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
			}
			Thread.sleep(2000);
			
			WebElement frame = driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
			wait.until(ExpectedConditions.visibilityOf(frame));
			driver.switchTo().frame(frame);
			Thread.sleep(2000);
			
			WebElement contactNumEdt = driver.findElement(By.xpath("//input[@id='contact']"));
			wait.until(ExpectedConditions.visibilityOf(contactNumEdt));
			contactNumEdt.sendKeys("8686184458");
			Thread.sleep(2000);
			
			WebElement proceedBtn = driver.findElement(By.xpath("//button[@class='svelte-s8db8t']"));
			wait.until(ExpectedConditions.visibilityOf(proceedBtn));
			proceedBtn.click();
			Thread.sleep(2000);
			
			WebElement netBankingLnk = driver.findElement(By.xpath("//div[.='Netbanking']"));
			wait.until(ExpectedConditions.visibilityOf(netBankingLnk));
			netBankingLnk.click();
			Thread.sleep(2000);
			
			WebElement bank = driver.findElement(By.xpath("//div[.='ICICI']"));
			wait.until(ExpectedConditions.visibilityOf(bank));
			bank.click();
			Thread.sleep(1000);
			
			String parentWindow = driver.getWindowHandle();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Pay Now']"))).click();
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
			
	        wait.until(ExpectedConditions.alertIsPresent());
	        Thread.sleep(2000);
	        
			String AlertMsg = driver.switchTo().alert().getText();
			System.out.println(AlertMsg);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			
			WebElement TextArea = driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']"));
			Thread.sleep(2000);
			
//			This is Before Completion of modal popup close button ele
//			driver.findElement(By.xpath("//div[.='Feedback']/following-sibling::div/button[.=' X ']")).click();
			
			wait.until(ExpectedConditions.visibilityOf(TextArea));
			TextArea.sendKeys("Good Scheme");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//label[@for='4-star']")).click();
			Thread.sleep(2000);
			
			WebElement submitBtn = driver.findElement(By.xpath("//button[.=' submit ']"));
			wait.until(ExpectedConditions.visibilityOf(submitBtn));
			submitBtn.click();
			Thread.sleep(2000);
						
			//This is After Completion of modal popup close button ele
			driver.findElement(By.xpath("//div[.=' Thank for your Feedback']/following-sibling::div/button[.=' X ']")).click();
			Thread.sleep(2000);
			
			try
			{
				WebElement SuccessPopup = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
				wait.until(ExpectedConditions.visibilityOf(SuccessPopup));
				String SuccessMsg = SuccessPopup.getText();
				if(SuccessPopup.isDisplayed())
				{
					System.out.println(SuccessMsg);
					Assert.fail();
				}
			}
			catch(Exception e)
			{
				System.out.println("Failed");
			}
			Thread.sleep(3000);
		}
		
		
		@Test(groups = "expSchemes" , priority = 5)
		public void afterSchemeSubscriptionFetchingFailureMsgTest() throws Exception
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
			
			WebElement schemesLnk = driver.findElement(By.xpath("//span[.='Schemes']"));
			wait.until(ExpectedConditions.visibilityOf(schemesLnk));
			schemesLnk.click();
			Thread.sleep(3000);
			
			WebElement subscribeBtn = driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']"));
			wait.until(ExpectedConditions.visibilityOf(subscribeBtn));
			subscribeBtn.click();
			Thread.sleep(3000);
			
			WebElement amountEdt = driver.findElement(By.xpath("//select[@formcontrolname='amount']"));
			wait.until(ExpectedConditions.visibilityOf(amountEdt));
			amountEdt.click();
			Select s = new Select(amountEdt);
			s.selectByValue("4500");
			Thread.sleep(3000);
			
			WebElement monthsDrpDwn = driver.findElement(By.xpath("//select[@placeholder='Months']"));
			wait.until(ExpectedConditions.visibilityOf(monthsDrpDwn));
			monthsDrpDwn.click();
			Select s1 = new Select(monthsDrpDwn);
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
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[.='I Agree to Terms & Conditions']/../..//input[@type='checkbox']"))).click();
			Thread.sleep(3000);
			
			WebElement walletAmtEdt = driver.findElement(By.xpath("//input[@formcontrolname='enteredWalletAmount']"));
			wait.until(ExpectedConditions.visibilityOf(walletAmtEdt));
			walletAmtEdt.sendKeys("4500");
			Thread.sleep(5000);
			
			while (true)
			{
			try 
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='coupon-text2']/following-sibling::div/button[@type='submit']"))).click();
				break;
			} 
			catch (Exception e) 
			{
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
			}
			Thread.sleep(2000);
			
			WebElement frame = driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
			wait.until(ExpectedConditions.visibilityOf(frame));
			driver.switchTo().frame(frame);
			Thread.sleep(2000);
			
			WebElement contactEdt = driver.findElement(By.xpath("//input[@id='contact']"));
			wait.until(ExpectedConditions.visibilityOf(contactEdt));
			contactEdt.sendKeys("8686184458");
			Thread.sleep(2000);
			
			WebElement proceedBtn = driver.findElement(By.xpath("//button[@class='svelte-s8db8t']"));
			wait.until(ExpectedConditions.visibilityOf(proceedBtn));
			proceedBtn.click();
			Thread.sleep(2000);
			
			WebElement netBankingLnk = driver.findElement(By.xpath("//div[.='Netbanking']"));
			wait.until(ExpectedConditions.visibilityOf(netBankingLnk));
			netBankingLnk.click();
			Thread.sleep(2000);
			
			WebElement bank = driver.findElement(By.xpath("//div[.='ICICI']"));
			wait.until(ExpectedConditions.visibilityOf(bank));
			bank.click();
			Thread.sleep(2000);
			
			String parentWindow = driver.getWindowHandle();
			Thread.sleep(2000);
			
			WebElement payNowBtn = driver.findElement(By.xpath("//button[.='Pay Now']"));
			wait.until(ExpectedConditions.visibilityOf(payNowBtn));
			payNowBtn.click();
			Thread.sleep(2000);
			
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
			Assert.fail();
			
			
		}
		
		
		@Test(groups = "expSchemes" , priority = 6)
		public void takingScreenshotofRecentlySubscribedSchemeTest() throws Exception
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
			
			WebElement ele = driver.findElement(By.xpath("//span[.='Schemes']"));
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.click();
			Thread.sleep(3000);
			
			WebElement subscribeBtn = driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']"));
			wait.until(ExpectedConditions.visibilityOf(subscribeBtn));
			subscribeBtn.click();
			Thread.sleep(3000);
			
			WebElement amountEdt = driver.findElement(By.xpath("//select[@formcontrolname='amount']"));
			wait.until(ExpectedConditions.visibilityOf(amountEdt));
			amountEdt.click();
			Select s = new Select(amountEdt);
			s.selectByValue("1500");
			Thread.sleep(3000);
			
			WebElement monthsEdt = driver.findElement(By.xpath("//select[@placeholder='Months']"));
			wait.until(ExpectedConditions.visibilityOf(monthsEdt));
			monthsEdt.click();
			Select s1 = new Select(monthsEdt);
			s1.selectByVisibleText("12 Months");
			Thread.sleep(3000);
						
			Robot r = new Robot();
			try 
			{
				WebElement bookingAccCheckBox = driver.findElement(By.xpath("//p[.='Use Booking Account']/../..//div/input[@type='checkbox']"));
				wait.until(ExpectedConditions.visibilityOf(bookingAccCheckBox));
				bookingAccCheckBox.click();
			} 
			catch (Exception e) 
			{
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			}
			Thread.sleep(3000);
			
			WebElement walletAmountEdt = driver.findElement(By.xpath("//input[@formcontrolname='enteredWalletAmount']"));
			wait.until(ExpectedConditions.visibilityOf(walletAmountEdt));
			walletAmountEdt.sendKeys("1800");		
			Thread.sleep(3000);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[.='I Agree to Terms & Conditions']/../..//input[@type='checkbox']"))).click();
			Thread.sleep(5000);
			
			while (true)
			{
			try 
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='coupon-text2']/following-sibling::div/button[@type='submit']"))).click();
				break;
			} 
			catch (Exception e) 
			{
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			}
			}
			Thread.sleep(3000);
			
			wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(3000);
			
			String AlertMsg = driver.switchTo().alert().getText();
			System.out.println(AlertMsg);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			
//			This is Before Completion of modal popup close button ele
//			driver.findElement(By.xpath("//div[.='Feedback']/following-sibling::div/button[.=' X ']")).click();
			
            WebElement TextArea = driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']"));
			wait.until(ExpectedConditions.visibilityOf(TextArea));
			TextArea.sendKeys("Good Scheme");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//label[@for='4-star']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[.=' submit ']")).click();
			Thread.sleep(2000);
			
//			This is After Completion of modal popup close button ele
			driver.findElement(By.xpath("//div[.=' Thank for your Feedback']/following-sibling::div/button[.=' X ']")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//span[.='Schemes']")).click();
			Thread.sleep(3000);
			
			WebElement SubscribeBtn = driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']"));
			wait.until(ExpectedConditions.visibilityOf(SubscribeBtn));
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(3000);
			
			WebElement ViewDetailsBtn = driver.findElement(By.xpath("(//button[.='View Details'])[1]"));
			wait.until(ExpectedConditions.visibilityOf(ViewDetailsBtn));
			ViewDetailsBtn.click();
			Thread.sleep(3000);
			
			WebElement DownloadBtn = driver.findElement(By.xpath("//a[text()=' Download']"));
			wait.until(ExpectedConditions.visibilityOf(DownloadBtn));
			Assert.fail();
								                                            		
	  }
		
		
		@Test(groups = "expSchemes" , priority = 7)
		public void takingScreenshotofRecentlySubscribedSchemeAfterDownlodingTest() throws Exception
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			WebElement schemesLnk = driver.findElement(By.xpath("//span[.='Schemes']"));
			wait.until(ExpectedConditions.visibilityOf(schemesLnk));
			schemesLnk.click();
			Thread.sleep(3000);
			
			WebElement subscribeBtn = driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']"));
			wait.until(ExpectedConditions.visibilityOf(subscribeBtn));
			subscribeBtn.click();
			Thread.sleep(3000);
			
			WebElement amountEdt = driver.findElement(By.xpath("//select[@formcontrolname='amount']"));
			wait.until(ExpectedConditions.visibilityOf(amountEdt));
			amountEdt.click();
			Select s = new Select(amountEdt);
			s.selectByValue("1500");
			Thread.sleep(3000);
			
			WebElement monthsDrpDwn = driver.findElement(By.xpath("//select[@placeholder='Months']"));
			wait.until(ExpectedConditions.visibilityOf(amountEdt));
			monthsDrpDwn.click();
			Select s1 = new Select(monthsDrpDwn);
			s1.selectByVisibleText("12 Months");
			Thread.sleep(3000);
						
			Robot r = new Robot();
			try 
			{
				WebElement useBookingAcCheckBox = driver.findElement(By.xpath("//p[.='Use Booking Account']/../..//div/input[@type='checkbox']"));
				wait.until(ExpectedConditions.visibilityOf(useBookingAcCheckBox));
				useBookingAcCheckBox.click();
			} 
			catch (Exception e) 
			{
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			}
			Thread.sleep(3000);
			
			WebElement walletAmountEdt = driver.findElement(By.xpath("//input[@formcontrolname='enteredWalletAmount']"));
			wait.until(ExpectedConditions.visibilityOf(walletAmountEdt));
			walletAmountEdt.sendKeys("1800");		
			Thread.sleep(3000);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[.='I Agree to Terms & Conditions']/../..//input[@type='checkbox']"))).click();
			Thread.sleep(5000);
			
			while (true)
			{
			try 
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='coupon-text2']/following-sibling::div/button[@type='submit']"))).click();
				break;
			} 
			catch (Exception e) 
			{
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			}
			}
			Thread.sleep(3000);
			
			wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(3000);
			
			String AlertMsg = driver.switchTo().alert().getText();
			System.out.println(AlertMsg);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			
//			This is Before Completion of modal popup close button ele
//			driver.findElement(By.xpath("//div[.='Feedback']/following-sibling::div/button[.=' X ']")).click();
			
            WebElement TextArea = driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']"));
			wait.until(ExpectedConditions.visibilityOf(TextArea));
			TextArea.sendKeys("Good Scheme");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//label[@for='4-star']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[.=' submit ']")).click();
			Thread.sleep(2000);
			
//			This is After Completion of modal popup close button ele
			driver.findElement(By.xpath("//div[.=' Thank for your Feedback']/following-sibling::div/button[.=' X ']")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//span[.='Schemes']")).click();
			Thread.sleep(3000);
			
			WebElement SubscribeBtn = driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']"));
			wait.until(ExpectedConditions.visibilityOf(SubscribeBtn));
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(3000);
			
			WebElement ViewDetailsBtn = driver.findElement(By.xpath("(//button[.='View Details'])[1]"));
			wait.until(ExpectedConditions.visibilityOf(ViewDetailsBtn));
			ViewDetailsBtn.click();
			Thread.sleep(3000);
			
			WebElement DownloadBtn = driver.findElement(By.xpath("//a[text()=' Download']"));
			wait.until(ExpectedConditions.visibilityOf(DownloadBtn));
			DownloadBtn.click();
			
			Assert.fail();
			
						                                            		
	}

}
