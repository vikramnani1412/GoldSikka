package S2_Negative_Scenarious_for_SignupLoginSchemesDepositAmountSprint_1_Stg;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import GenericUtility.BaseClass;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class Done_BookingAccountUsingExplicitWaitsErrors_StgTest extends BaseClass {
	
	@Test(groups = "expBookingAccount" , priority = 1)
	public void adding1RstoBookingAccount() throws Exception
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
		wait.until(ExpectedConditions.visibilityOf(bookingAccount));
		bookingAccount.click();
		Thread.sleep(3000);
		
		WebElement amountEdtElement = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));
		wait.until(ExpectedConditions.visibilityOf(amountEdtElement));
		amountEdtElement.sendKeys("1",Keys.ENTER);
		Thread.sleep(3000);
		
		WebElement Error = driver.findElement(By.xpath("//p[text()='Enter Amount']/../following-sibling::div/div[.='Please Enter Minimum 50 on your account ']"));
		wait.until(ExpectedConditions.visibilityOf(Error));
		if(Error.isEnabled())
		{
			System.out.println(Error.getText());
			Assert.fail();
		}
		Thread.sleep(3000);
		
	}
	
	
	@Test(groups = "expBookingAccount" , priority = 2)   //Passed Testcase
	public void adding50RstoBookingAccountAndClickingOnSuccessButtonPass() throws Exception
	{
		Robot r = new Robot();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		
		WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
		wait.until(ExpectedConditions.visibilityOf(bookingAccount));
		bookingAccount.click();
		Thread.sleep(2000);
		
		WebElement amountEdtElement = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));
		wait.until(ExpectedConditions.visibilityOf(amountEdtElement));
		amountEdtElement.sendKeys("50",Keys.ENTER);
		Thread.sleep(3000);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
		wait.until(ExpectedConditions.visibilityOf(frame));
		driver.switchTo().frame(frame);
		WebElement ContactEdt = driver.findElement(By.name("contact"));
		wait.until(ExpectedConditions.visibilityOf(ContactEdt));
		ContactEdt.sendKeys("8686184458");
		Thread.sleep(3000);
		
		WebElement proceedBtn = driver.findElement(By.xpath("//div[@class='redesign-v15-cta-wrapper svelte-s8db8t']"));
		wait.until(ExpectedConditions.visibilityOf(proceedBtn));
		proceedBtn.click();
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
	    
		//Dynamic
//		WebElement bank = driver.findElement(By.xpath("//div[contains(@id,'bank-item-"+BankName+"')]"));
		
		WebElement bank = driver.findElement(By.xpath("//div[.='ICICI']"));
		wait.until(ExpectedConditions.visibilityOf(bank));
		bank.click();
		Thread.sleep(3000);
		
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(2000);
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
				WebElement SuccessBtn = driver.findElement(By.xpath("//button[.='Success']"));
				wait.until(ExpectedConditions.elementToBeClickable(SuccessBtn));
				SuccessBtn.click();
				Thread.sleep(3000);
			}
		}
		Thread.sleep(3000);
		
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
        Assert.fail();
		
//		wUtil.takeScreenShot(driver, methodName);
//		
//		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(15));
//		        
//		wait1.until(ExpectedConditions.alertIsPresent());
//
//		String AlertMsg = driver.switchTo().alert().getText();
//		System.out.println(AlertMsg);
//
//        
//		if(AlertMsg.contains("Successfully added Rs"))
//		{
//			System.out.println("Amount Added Successfully");
//		}
//		else
//		{
//			System.out.println("Amount Not Added Successfully");
//		}
//		driver.switchTo().alert().accept();
//		
//		String AfterAddingAmountToBookingAccount = driver.findElement(By.xpath("//p[contains(.,'₹ ')]")).getText();
//		System.out.println("AfterAddingAmountToBookingAccount= " + AfterAddingAmountToBookingAccount);
//		Thread.sleep(2000);

	}
	
	@Test(groups = "expBookingAccount" , priority = 3)
	public void adding50RstoBookingAccountAndClickingOnFailureButton() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
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
		wait.until(ExpectedConditions.visibilityOf(frame));
		driver.switchTo().frame(frame);
		
		WebElement phoneNoEdt = driver.findElement(By.name("contact"));
		wait.until(ExpectedConditions.visibilityOf(phoneNoEdt));
		phoneNoEdt.sendKeys("8686184458");
		Thread.sleep(3000);
		
		WebElement proceedBtn = driver.findElement(By.xpath("//div[@class='redesign-v15-cta-wrapper svelte-s8db8t']"));
		wait.until(ExpectedConditions.visibilityOf(proceedBtn));
		proceedBtn.click();
		Thread.sleep(3000);
		
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		
		while (true)
		{
		try 
		{
			WebElement netBankingLnk = driver.findElement(By.xpath("//div[.='Netbanking']"));
			wait.until(ExpectedConditions.visibilityOf(netBankingLnk));
			netBankingLnk.click();
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
		WebElement bank = driver.findElement(By.xpath("//div[.='ICICI']"));
		wait.until(ExpectedConditions.visibilityOf(bank));
		bank.click();
		Thread.sleep(2000);
		
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(2000);
		
		WebElement PayNowBtn = driver.findElement(By.xpath("//button[text()='Pay Now']"));
		wait.until(ExpectedConditions.visibilityOf(PayNowBtn));
		PayNowBtn.click();
		Thread.sleep(2000);
		
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
        Thread.sleep(3000);
        
        Assertion a = new Assertion();
        a.fail();
        
        driver.findElement(By.xpath("//button[.='Try again']")).click();
        
		Thread.sleep(3000);

	}
	
	
	@Test(groups = "expBookingAccount" , priority = 4)
	public void withoutGivingAmountInBookingAccountTextFieldAndClickingOnSubmitButton() throws Exception
	{	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		
		WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
		wait.until(ExpectedConditions.visibilityOf(bookingAccount));
		bookingAccount.click();
		Thread.sleep(3000);
		
		WebElement amountEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));
		wait.until(ExpectedConditions.visibilityOf(amountEdt));
		amountEdt.sendKeys(Keys.ENTER);
		Assert.fail();
		Thread.sleep(3000);

	}
	
	
	@Test(groups = "expBookingAccount" , priority = 5)
	public void entering1RsInWithdrawAmountTextFieldAndClickonWithdraw() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
		wait.until(ExpectedConditions.visibilityOf(bookingAccount));
		bookingAccount.click();
		Thread.sleep(3000);
			
		WebElement withdrawLnk = driver.findElement(By.xpath("//button[.='Withdraw']"));
		wait.until(ExpectedConditions.visibilityOf(withdrawLnk));
		withdrawLnk.click();
		Thread.sleep(3000);
		
		WebElement amountEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));
		wait.until(ExpectedConditions.visibilityOf(amountEdt));
		amountEdt.sendKeys("1",Keys.ENTER);
		Thread.sleep(3000);
		
		try 
		{
			WebElement entering1RsWhileWithdrawError = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']/following-sibling::div[text()='You have the minimum amount Rs.500 ']"));
			wait.until(ExpectedConditions.visibilityOf(entering1RsWhileWithdrawError));
			String entering1RsWhileWithdrawErrorMsg = entering1RsWhileWithdrawError.getText();
			if(entering1RsWhileWithdrawError.isDisplayed())
			{
				System.out.println(entering1RsWhileWithdrawErrorMsg);
				Assert.fail();
			}
		}
		catch (Exception e) 
		{
			System.out.println("Error Not Found");
		}
		Thread.sleep(3000);
			
	}
	
	
	@Test(groups = "expBookingAccount" , priority = 6)
	public void entering50RsInWithdrawAmountTextFieldAndClickonWithdraw() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		
		WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
		wait.until(ExpectedConditions.visibilityOf(bookingAccount));
		bookingAccount.click();
		Thread.sleep(2000);
		
		WebElement withdrawLnk = driver.findElement(By.xpath("//button[.='Withdraw']"));
		wait.until(ExpectedConditions.visibilityOf(withdrawLnk));
		withdrawLnk.click();
		Thread.sleep(2000);
		
		WebElement amountEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));
		wait.until(ExpectedConditions.visibilityOf(amountEdt));
		amountEdt.sendKeys("50",Keys.ENTER);
		Thread.sleep(2000);
		
		try 
		{
			WebElement entering50RsWhileWithdrawError = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']/following-sibling::div[text()='You have the minimum amount Rs.500 ']"));
			wait.until(ExpectedConditions.visibilityOf(entering50RsWhileWithdrawError));
			String entering50RsWhileWithdrawErrorMsg = entering50RsWhileWithdrawError.getText();
			if(entering50RsWhileWithdrawError.isDisplayed())
			{
				System.out.println(entering50RsWhileWithdrawErrorMsg);
				Assert.fail();
			}
		}
		catch (Exception e) 
		{
			System.out.println("Error Not Found");
		}
		Thread.sleep(2000);
		
				
	}
	
	@Test(groups = "expBookingAccount" , priority = 7)
	public void entering499RsInWithdrawAmountTextFieldAndClickonWithdraw() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		
		WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
		wait.until(ExpectedConditions.visibilityOf(bookingAccount));
		bookingAccount.click();
		Thread.sleep(2000);
		
		WebElement withdrawLnk = driver.findElement(By.xpath("//button[.='Withdraw']"));
		wait.until(ExpectedConditions.visibilityOf(withdrawLnk));
		withdrawLnk.click();
		Thread.sleep(2000);
		
		WebElement amountEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));
		wait.until(ExpectedConditions.visibilityOf(amountEdt));
		amountEdt.sendKeys("499",Keys.ENTER);
		Thread.sleep(2000);
		
		try 
		{
			WebElement entering499RsWhileWithdrawError = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']/following-sibling::div[text()='You have the minimum amount Rs.500 ']"));
			wait.until(ExpectedConditions.visibilityOf(entering499RsWhileWithdrawError));
			String entering499RsWhileWithdrawErrorMsg = entering499RsWhileWithdrawError.getText();
			if(entering499RsWhileWithdrawError.isDisplayed())
			{
				System.out.println(entering499RsWhileWithdrawErrorMsg);
				Assert.fail();
			}
		}
		catch (Exception e) 
		{
			System.out.println("Error Not Found");
		}
		
		
				
	}
	
	@Test(groups = "expBookingAccount" , priority = 8 , invocationCount = 2)    //This is for withdraw 500Rs/- 2 times, 2nd time we got error
	public void entering500RsInWithdrawAmountTextFieldAndClickonWithdraw() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		
		WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
		wait.until(ExpectedConditions.visibilityOf(bookingAccount));
		bookingAccount.click();
		Thread.sleep(3000);
		
		WebElement withdrawLnk = driver.findElement(By.xpath("//button[.='Withdraw']"));
		wait.until(ExpectedConditions.visibilityOf(withdrawLnk));
		withdrawLnk.click();
		Thread.sleep(2000);
		
		WebElement amountEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));
		wait.until(ExpectedConditions.visibilityOf(amountEdt));
		amountEdt.sendKeys("500",Keys.ENTER);
		Thread.sleep(2000);
		
		try 
		{
			WebElement WhileWithdrawing1stTimeSuccess = driver.findElement(By.xpath("//div[@class='alert alert-success mb-4 pl-5 pt-5 pb-5']"));
			wait.until(ExpectedConditions.visibilityOf(WhileWithdrawing1stTimeSuccess));
			String WhileWithdrawing1stTimeSuccessMsg = WhileWithdrawing1stTimeSuccess.getText();
			if(WhileWithdrawing1stTimeSuccess.isDisplayed())
			{
				System.out.println(WhileWithdrawing1stTimeSuccessMsg);
			}		
		}
		catch (Exception e) 
		{
			WebElement WhileWithdrawing2ndTimeError = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
			wait.until(ExpectedConditions.visibilityOf(WhileWithdrawing2ndTimeError));
			String WhileWithdrawing2ndTimeErrorMsg = WhileWithdrawing2ndTimeError.getText();
			if(WhileWithdrawing2ndTimeError.isDisplayed())
			{
				System.out.println(WhileWithdrawing2ndTimeErrorMsg);
			}
			Assertion a = new Assertion();
			a.fail();
			Thread.sleep(2000);
		}
		
				
	}
	
	
	@Test(groups = "expBookingAccount" , priority = 9)
	public void enteringNegative5RsInWithdrawAmountTextFieldAndClickonWithdraw() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		
		WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
		wait.until(ExpectedConditions.visibilityOf(bookingAccount));
		bookingAccount.click();
		Thread.sleep(3000);		
				
		WebElement withdrawLnk = driver.findElement(By.xpath("//button[.='Withdraw']"));
		wait.until(ExpectedConditions.visibilityOf(withdrawLnk));
		withdrawLnk.click();
		Thread.sleep(2000);
		
		WebElement amountEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));
		wait.until(ExpectedConditions.visibilityOf(amountEdt));
		amountEdt.sendKeys("-5",Keys.ENTER);
		Thread.sleep(2000);
		
		try 
		{
			WebElement WhileWithdrawingNegative5RsError = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']/following-sibling::div[.='You have the minimum amount Rs.500 ']"));
			wait.until(ExpectedConditions.visibilityOf(WhileWithdrawingNegative5RsError));
			String WhileWithdrawingNegative5RsErrorMsg = WhileWithdrawingNegative5RsError.getText();
			if(WhileWithdrawingNegative5RsError.isDisplayed())
			{
				System.out.println(WhileWithdrawingNegative5RsErrorMsg);
				Assert.fail();
			}
		}
		catch (Exception e) 
		{
			System.out.println("Error Not Found");
		}
		Thread.sleep(2000);
		
				
	}
	
}
